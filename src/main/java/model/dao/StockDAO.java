package model.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.entities.Stock;

import java.io.Serializable;
import java.util.List;

public class StockDAO implements Serializable {

    private EntityManagerFactory emf = null;

    // Constructor con un EntityManagerFactory externo
    public StockDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    // Constructor que inicializa un EntityManagerFactory internamente
    public StockDAO() {
        this.emf = Persistence.createEntityManagerFactory("StockManagementDG");
    }

    // Método para obtener un EntityManager
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Guardar o actualizar una acción
    public void saveOrUpdate(Stock stock) {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            Stock existingStock = em.find(Stock.class, stock.getSymbol());
            if (existingStock == null) {
                em.persist(stock); // Crear un nuevo registro
            } else {
                em.merge(stock); // Actualizar el registro existente
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error al guardar o actualizar el Stock: " + e.getMessage(), e);
        } finally {
            em.close(); // Cerrar el EntityManager
        }
    }

    // Buscar una acción por su símbolo
    public Stock findBySymbol(String symbol) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Stock.class, symbol);
        } finally {
            em.close();
        }
    }

    // Listar todas las acciones
    public List<Stock> findAll() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT s FROM Stock s", Stock.class).getResultList();
        } finally {
            em.close();
        }
    }

    // Eliminar una acción por su símbolo
    public void deleteBySymbol(String symbol) {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            Stock stock = em.find(Stock.class, symbol);
            if (stock != null) {
                em.remove(stock); // Eliminar el registro
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error al eliminar el Stock: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }
}
