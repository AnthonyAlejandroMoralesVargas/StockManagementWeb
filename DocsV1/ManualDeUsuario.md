# Manual de Usuario: Stock Management

## **Alcance del aplicativo**
1. Registrar información sobre acciones compradas.
2. Consultar precios actuales e históricos utilizando la API de Alpha Vantage.
3. Calcular ganancias, pérdidas y balances de tu inversión.
4. Visualizar la información en un panel de control amigable.
 
## **Requisitos del Sistema**

1. Sistema Operativo: Windows, macOS o Linux.
2. Java: Versión 22.
3. Conexión a Internet: Requerida para consultar la API de Alpha Vantage.
4. API Key: Clave API de Alpha Vantage (disponible en Alpha Vantage).

## **Interfaz Principal**

La interfaz de Stock Management se divide en varias secciones principales:

![image](https://github.com/user-attachments/assets/6f838cc5-689b-4223-a611-d7b6d52b2611)

### **Encabezado**
  - **Título:** "STOCK MANAGER".
### **Formulario de Registro de Acciones**
#### **Campos**
  - Symbol: Desplegable para seleccionar el símbolo de la acción (ejemplo: AAPL para Apple).
  - Purchase Price: Campo de texto para ingresar el precio de compra por acción.
  - Quantity: Campo de texto para ingresar la cantidad de acciones adquiridas.
  - Purchase Date: Campo de texto para ingresar la fecha de compra en formato dd/mm/yyyy.
  - Botón Save: Procesa los datos ingresados en el formulario.
### **Sección "My Stock"**
Una tabla que muestra la información de las acciones registradas, con las siguientes columnas:
  - Stock Name: Nombre o símbolo de la acción.
  - Quantity: Cantidad de acciones.
  - Purchase Date: Fecha de compra.
  - Purchase Price: Precio de compra por acción.
  - Current Date: Fecha actual.
  - Current Price: Precio actual de la acción.
  - Unit Gain: Ganancia por unidad.
  - Unit Percentage: Porcentaje de ganancia por unidad.
  - Total Balance: Saldo total actual.
  - Total Gain: Ganancia total.
  - Botón Refresh: Actualiza la tabla con las últimas acciones registradas.

## **Registrar una Acción**
Ingresa los datos en el formulario, de modo que:

![image](https://github.com/user-attachments/assets/27f4fcfd-80d1-4846-992c-5f4388b77f74)

  - Symbol: Símbolo de la acción (ejemplo: MSFT para Microsoft).
  - Purchase Price: Precio de compra (ejemplo: 427.67).
  - Quantity: Cantidad de acciones (ejemplo: 1).
  - Purchase Date: Fecha de compra (ejemplo: 26/11/2024).

**Acciones Disponibles tras Guardar**
  - Visualización: Los datos ingresados y calculados se agregan automáticamente a la tabla en la sección "My Stock".
  - Actualización: refresca la tabla con nuevas acciones o correcciones.

## **Visualización de Resultados**
Una vez que los datos son procesados, la tabla en la sección "My Stock" se llenará automáticamente con la información de la acción. 

![image](https://github.com/user-attachments/assets/fc0c95ea-cc5e-40b4-bbe2-90a6719e2835)

  - El precio actual de la acción.
  - Las ganancias o pérdidas calculadas.
  - El balance total de la inversión.

## **Actualización de la Tabla**
En caso de refrescar los datos de la tabla, clic en el botón Refresh.

## **Errores Comunes y Soluciones**
### **Error: "Purchase price must be a valid decimal number.":**

![image](https://github.com/user-attachments/assets/1b4f0f20-08bc-4408-a29e-93c81fb0af4d)

**Causa:** El campo de precio no contiene un número válido.

**Solución:** Ingresar un número mayor que cero.

### **Error: "Purchase price must be a valid decimal number.":**

![image](https://github.com/user-attachments/assets/52c9b0d9-8091-4090-a4fa-ca71a4e0cd44)

**Causa:** El campo de la cantidad no contiene un número válido.

**Solución:** Ingresar un número mayor que cero.

### **Error: "Invalid date: Incorrect format. Use dd/MM/yyyy.":**

![image](https://github.com/user-attachments/assets/5a91be7f-e50c-45bd-a79b-4c7a746c1908)

**Causa:** La fecha no está en el formato dd/mm/yyyy o es una fecha futura.

**Solución:** Revisar el formato de la fecha e ingresa una fecha válida.

### **Error: "The year of the date must be greater than or equal to 2000.":**

![image](https://github.com/user-attachments/assets/27051c73-8322-467e-b721-2aa0739c7c10)

**Causa:** La fecha ingresada tiene un año anterior a 2000, lo cual no es permitido por el sistema.

**Solución:** Revisar de que el año sea 2000 o posterior.

### **Error: "The date cannot be later than the current date.":**

![image](https://github.com/user-attachments/assets/716ab0d7-564c-45dc-bf87-5ac4939b25e9)

**Causa:** La fecha ingresada es una fecha futura, lo que no está permitido por el sistema.

**Solución:** Verifica que la fecha no sea mayor que la fecha actual.

## **Cálculo de Valores**
El sistema calcula automáticamente:

  - Unit Gain: Ganancia por acción (Current Price - Purchase Price).
  - Unit Percentage: Porcentaje de ganancia o pérdida ((Unit Gain / Purchase Price) * 100).
  - Total Balance: Saldo total actual (Current Price × Quantity).
  - Total Gain: Ganancia o pérdida total (Total Balance - Total Cost).
