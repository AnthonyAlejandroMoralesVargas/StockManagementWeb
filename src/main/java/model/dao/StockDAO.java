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
    public boolean create(Stock stock) {
        EntityManager em = null;
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(stock);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return false;
        }finally {
            if (em != null) {
                em.close();
            }
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

    public List<Stock> getStocksOrderedByName() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT s FROM Stock s ORDER BY s.symbol ASC", Stock.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<Stock> getStocksOrderedByUnitGainAsc() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT s FROM Stock s ORDER BY s.unitGain ASC", Stock.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<Stock> getStocksOrderedByUnitGainDesc() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT s FROM Stock s ORDER BY s.unitGain DESC", Stock.class)
                    .getResultList();
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