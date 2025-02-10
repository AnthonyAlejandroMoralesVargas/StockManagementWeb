# Manual Técnico de la Aplicación de Stock Management

## 1. Introducción

### 1.1 Propósito del documento
Este manual técnico está dirigido a desarrolladores y tiene como objetivo proporcionar una guía detallada sobre la arquitectura, funcionalidades y configuración de la aplicación de Stock Management. El documento cubre tanto el backend como la integración con la API de Alpha Vantage.

### 1.2 Alcance
El manual cubre:

- La estructura de carpetas y archivos del proyecto.
- Las tecnologías utilizadas (Java, JSP, CSS, iTextPDF, Chart.js, Hibernate).
- La integración con la API de Alpha Vantage.
- Ejemplos de código y explicaciones de las funcionalidades principales.

### 1.3 Audiencia
Este documento está dirigido a:

- Desarrolladores backend y frontend.
- Integradores de APIs.
- Mantenedores del proyecto.

## 2. Descripción General del Sistema

### 2.1 Resumen de la Aplicación
La aplicación permite a los usuarios:

- Registrar compras de acciones con detalles como símbolo, cantidad, precio de compra y fecha.
- Visualizar un historial de compras ordenado por nombre o ganancia/pérdida.
- Consolidar las acciones compradas por símbolo y generar un informe en PDF.
- Visualizar un gráfico de rendimiento que muestra la evolución de las inversiones.

### 2.2 Arquitectura del Sistema
La aplicación sigue una arquitectura basada en Java EE con las siguientes capas:

- **Capa de Presentación:** JSP (home.jsp, stockConsolidation.jsp) y CSS (styles.css).
- **Capa de Controladores:** RegisterStockController.java, StockConsolidationController.java.
- **Capa de Servicios:** StockService.java.
- **Capa de Persistencia:** StockDAO.java, Stock.java, persistence.xml.
- **Integración con API Externa:** AlphaVantageAPI.java.
- **Utilidades:** StockPDFGenerator.java.

## 3. Estructura de Carpetas y Archivos

### 3.1 Estructura de Carpetas
```plaintext
src/
├── main/
│   ├── java/
│   │   ├── controllers/
│   │   │   ├── RegisterStockController.java
│   │   │   └── StockConsolidationController.java
│   │   ├── model/
│   │   │   ├── api/
│   │   │   │   └── AlphaVantageAPI.java
│   │   │   ├── dao/
│   │   │   │   └── StockDAO.java
│   │   │   ├── entities/
│   │   │   │   └── Stock.java
│   │   │   ├── services/
│   │   │   │   └── StockService.java
│   │   │   └── utils/
│   │   │       └── StockPDFGenerator.java
│   ├── resources/
│   │   ├── META-INF/
│   │   │   └── persistence.xml
│   └── webapp/
│       ├── css/
│       │   └── styles.css
│       ├── jsp/
│       │   ├── home.jsp
│       │   └── stockConsolidation.jsp
│       └── WEB-INF/
│           └── web.xml
└── 
```

## 4. Tecnologías Utilizadas

### 4.1 Backend
- **Java EE:** Para la lógica del servidor y la gestión de solicitudes HTTP.
- **Hibernate:** Para la persistencia de datos y la interacción con la base de datos.
- **iTextPDF:** Para la generación de informes en formato PDF.
- **API de Alpha Vantage:** Para obtener datos en tiempo real sobre precios de acciones.

### 4.2 Frontend
- **JSP (JavaServer Pages):** Para la generación dinámica de contenido HTML.
- **CSS:** Para los estilos y diseño visual de la aplicación.
- **Chart.js:** Para la visualización de datos en forma de gráficos.

### 4.3 Configuración
- **Maven:** Para la gestión de dependencias y la construcción del proyecto (pom.xml).
- **Hibernate:** Configuración de la persistencia en persistence.xml.
- **Web Application:** Configuración de la aplicación en web.xml.

## 5. Integración con la API de Alpha Vantage

### 5.1 Descripción de la API
La API de Alpha Vantage proporciona datos financieros en tiempo real, incluyendo precios de acciones, volúmenes de trading, y más. Se utiliza para calcular ganancias y pérdidas en la aplicación.

### 5.2 Uso de la API
- **Endpoint utilizado:** `https://www.alphavantage.co/query`
- **Parámetros usados:**
  - `function=TIME_SERIES_INTRADAY`: Para obtener datos en tiempo real.
  - `symbol=(ticker)`: Símbolo de la acción (ej: "MSFT" para Microsoft).
  - `apikey=(API_KEY)`: Clave de API para autenticación.

### 5.3 Limitaciones
La aplicación está funcionando con el servicio gratuito, lo que limita a un máximo de 25 peticiones por día. Se espera a futuro conseguir el servicio sin limitaciones y en tiempo real.

## 6. Funcionalidades Principales

### 6.1 Registro de Compras de Acciones
- **Formulario JSP:** Permite al usuario ingresar el símbolo, cantidad, precio de compra y fecha de compra.
- **Almacenamiento:** Los datos se almacenan en la base de datos mediante Hibernate.

### 6.2 Consolidación de Acciones
- **Resumen de acciones:** Muestra la cantidad total, el valor total, el precio de costo, el porcentaje de ganancia/pérdida y la ganancia/pérdida total por símbolo.

### 6.3 Generación de PDF
- **Informe en PDF:** Permite al usuario descargar un informe en PDF con el resumen de las acciones compradas.

### 6.4 Gráfico de Rendimiento
- **Gráfico de líneas:** Muestra la evolución de las inversiones a lo largo del tiempo, incluyendo el precio acumulado de compra, el precio acumulado actual y el rendimiento total.

## 7. Ejemplos de Código

### 7.1 Listars acciones registradas
```java
// RegisterStockController.java
private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StockService stockService = new StockService();

        String sort = req.getParameter("sort");

        List<Stock> stocks;
        if ("name".equals(sort)) {
            stocks = stockService.getOrderedStocksByName(); // Ordenar por nombre
        } else if("unitGainAsc".equals(sort)){
            stocks = stockService.getOrderedStocksByUnitGainAsc();
            // Ordenar por ganancia unitaria ascendente
        } else if("unitGainDesc".equals(sort)){
            stocks = stockService.getOrderedStocksByUnitGainDesc(); // Ordenar por ganancia unitaria descendente
        } else {
            stocks = stockService.listAllStocks(); // Ordenar por defecto
        }

        req.setAttribute("stocks", stocks);
        req.setAttribute("sort", sort); // Pasar el valor seleccionado al JSP
        req.getRequestDispatcher("jsp/home.jsp").forward(req, resp);
    }
```

### 7.2 Generación de PDF
```java
// StockPDFGenerator.java
private void generatePDF(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String symbol = req.getParameter("symbol");
        if (symbol == null || symbol.isEmpty()) {
            resp.sendRedirect("StockConsolidationController?route=enter");
            return;
        }

        StockService stockService = new StockService();
        List<Stock> stocks = stockService.findStocksBySymbol(symbol);

        resp.setContentType("application/pdf");
        resp.setHeader("Content-Disposition", "attachment; filename=Stock_Consolidation_" + symbol + ".pdf");

        StockPDFGenerator.generatePDF(resp.getOutputStream(), symbol, stocks);
    }
```

## 8. Configuración y Despliegue

### 8.1 Requisitos
- **Java JDK 22:** Para compilar y ejecutar la aplicación.
- **Apache Tomcat:** Para desplegar la aplicación web.
