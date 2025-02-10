# Historias de Usuario

## HU-001: Registrar una nueva acción
**Prioridad:** Alta  
**Estimación:** 5 SP  

### Historia de usuario
Como usuario del sistema de gestión de acciones,
quiero registrar mis acciones,
para mantener un registro centralizado de mis acciones.

### Criterios de Aceptación
Escenario 1: Registro exitoso de una acción
- Dado  que el usuario se encuentra en la pantalla principal y hace clic en "Register New Stock", luego completa el formulario con:
  - Símbolo: "AAPL"
  - Precio de compra: 150.00
  - Cantidad: 10
  - Fecha de compra: "2023-10-01"
  - Cuando hace clic en "Guardar"
- Entonces la acción se registra correctamente en la base de datos y se muestra el mensaje: "Stock added successfully!"

Escenario 2: Registro fallido por cantidad negativa
- Dado que el usuario se encuentra en la pantalla principal y hace clic en "Register New Stock", luego completa el formulario con:
  - Símbolo: "AAPL"
  - Precio de compra: 150.00
  - Cantidad: -5
  - Fecha de compra: "2023-10-01"
- Cuando hace clic en "Guardar"
- Entonces se muestra el mensaje de error: "Quantity must be positive."

Escenario 3: Registro fallido por precio de compra negativo
- Dado que el usuario se encuentra en la pantalla principal y hace clic en "Register New Stock", luego completa el formulario con:
  - Símbolo: "AAPL"
  - Precio de compra: -100.00
  - Cantidad: 10
  - Fecha de compra: "2023-10-01"
- Cuando hace clic en "Guardar"
- Entonces se muestra el mensaje de error: "Purchase price must be positive."


Escenario 4: Registro fallido por cantidad y precio de compra negativos
- Dado que el usuario se encuentra en la pantalla principal y hace clic en "Register New Stock", luego completa el formulario con:
  - Símbolo: "AAPL"
  - Precio de compra: -100.00
  - Cantidad: -5
  - Fecha de compra: "2023-10-01"
- Cuando hace clic en "Guardar"
- Entonces se muestra el mensaje de error: "Quantity and Purchase price must be positive."

Escenario 5: Registro fallido por excepción inesperada
- Dado que el usuario se encuentra en la pantalla principal y ocurre un error inesperado durante el proceso de registro (error en la base de datos o problema de conexión)
- Cuando hace clic en "Guardar"
- Entonces se muestra el mensaje de error: "An error occurred while registering the stock."

### Tareas de implementación
1.	Diseñar el formulario de registro. (2 horas)
2.	Implementar la lógica de validación del formulario. (2 horas)
3.	Integrar el servicio para guardar la acción en la base de datos. (2 horas)
4.	Probar la funcionalidad con datos válidos e inválidos. (2 horas)

---

## HU-002: Ordenar acciones por nombre y ganancia/pérdida
**Prioridad:** Baja  
**Estimación:** 3 SP  

### Historia de usuario
Como usuario del sistema de gestión de acciones,
quiero ordenar mis acciones,
para revisar las acciones que más me interesan.

### Criterios de Aceptación
Escenario 1: Ordenar por nombre (símbolo)
- Dado que el usuario selecciona "Order by Name" en el menú desplegable,
- cuando el usuario selecciona una opción del menú,
- entonces las acciones se muestran en orden alfabético ascendente de los símbolos, de la siguiente forma: "AAPL", "GOOGL", "MSFT".

Escenario 2: Ordenar por ganancia ascendente
- Dado que el usuario selecciona "Unit Gain Ascending" en el menú desplegable,
- cuando el usuario selecciona una opción del menú,
- entonces las acciones se muestran ordenadas de menor a mayor según su ganancia/pérdida unitaria, de la siguiente forma: -10.50, 5.00, 20.75.

Escenario 3: Ordenar por pérdida descendente
- Dado que el usuario selecciona "Unit Gain Descending" en el menú desplegable,
- cuando el usuario selecciona una opción del menú,
- entonces las acciones se muestran ordenadas de mayor a menor según su ganancia/pérdida unitaria, de la siguiente forma: 20.75, 5.00, -10.50.


### Tareas de implementación
1.	Implementar la lógica de ordenamiento. (2 horas)
2.	Modificar el código para manejar las solicitudes de ordenamiento. (2 horas)
3.	Actualizar la interfaz de usuario para incluir los botones de ordenamiento. (2 horas)
---

## HU-003: Consolidación de acciones
**Prioridad:** Alta  
**Estimación:** 5 SP  

### Historia de usuario
Como usuario del sistema de gestión de acciones,
quiero que mis acciones se consoliden,
para ver un resumen detallado de mis inversiones.

### Criterios de Aceptación
Escenario 1: Visualización por defecto de la pestaña "Stock Consolidation"
- Dado que el usuario accede a la pestaña "Stock Consolidation",
- Cuando el usuario ve la interfaz,
- Entonces el selector de símbolos muestra "Select a symbol" por defecto y el resumen y la parte de "Summary Purchases" están vacíos.

Escenario 2: No hay compras registradas para un símbolo seleccionado
- Dado que el usuario está en la pestaña "Stock Consolidation" con el selector en "Select a symbol" y no ha seleccionado ningún símbolo,
- Cuando el usuario ve la interfaz,
- Entonces la tabla de "Summary Purchases" muestra el mensaje "No stock purchases recorded."

Escenario 3: Selección de símbolo y visualización del resumen
- Dado que el usuario selecciona un símbolo de acción previamente registrado (por ejemplo, "MSFT") en el menú desplegable de la pestaña "Stock Consolidation",
- Cuando el usuario elige un símbolo,
- Entonces se muestra el resumen con las estadísticas correspondientes:
  - Cantidad total de acciones compradas: 62
  - Valor total en USD de las compras: $146.00
  - Precio de costo promedio: $2.35
  - Porcentaje de ganancia/pérdida: 25.5%
  - Ganancia/pérdida total en USD: $37.23

Escenario 4: Visualización de compras individuales
- Dado que el usuario ha seleccionado un símbolo con compras registradas,
- Cuando el usuario ve el resumen de "Summary Purchases",
- Entonces se muestra una lista con las compras de esa acción, que incluye:
  - Purchase Date
  - Stock
  - Purchase Price (USD)
  - Quantity
  - USD Purchase
  - Gain/Loss (USD)

### Tareas de implementación
1.	Implementar la lógica de consolidación. (2 horas)
2.	Actualizar la interfaz de usuario para mostrar el resumen de consolidación. (2 horas)
3.	Probar la funcionalidad con datos reales y simulados. (2 horas)

---

## HU-004: Generación de informe en PDF
**Prioridad:** Alta  
**Estimación:** 5 SP  

### Historia de usuario
Como usuario del sistema de gestión de acciones,
quiero descargar la información de la consolidación de mis acciones,
para acceder a la información en cualquier momento.

### Criterios de Aceptación
Escenario 1: Generación de PDF exitosa
- Dado que el usuario ha consolidado las acciones para el símbolo "AMZN",
- cuando el usuario hace clic en "Descargar PDF",
- entonces se genera y descarga un informe en PDF con el siguiente contenido:

Stock Consolidation Report

Symbol: AMZN

Total Quantity of Stocks Purchased: 62
Total Value of Stocks Purchased USD: $146.00
Cost Price USD: $2.35
% Gain/Loss: 25.5%
$ Gain/Loss: $37.23

Summary Purchases:
Purchase Date    Stock    Purchase Price (USD)    Quantity    USD Purchase
27-nov          MSFT     1.00                   20          20.00
17-dic          MSFT     3.00                   42          126.00

Escenario 2: Intento de generar PDF sin seleccionar símbolo
- Dado que el usuario está en la pestaña "Stock Consolidation" con el selector en "Select a symbol" y no ha seleccionado ningún símbolo,
- Cuando el usuario hace clic en "Descargar PDF",
- Entonces no se descarga ningún archivo PDF y la interfaz no muestra ningún archivo ni mensaje de error.


### Tareas de implementación
1.	Implementar la generación de PDF. (3 horas)
2.	Integrar el botón de descarga de PDF en la interfaz de consolidación. (2 horas)
3.	Probar la funcionalidad con datos reales y simulados. (1 hora) 

---

## HU-005: Visualización de gráfico de rendimiento
**Prioridad:** Media  
**Estimación:** 5 SP  

### Historia de usuario
Como usuario del sistema de gestión de acciones,
quiero visualizar un gráfico que muestre la evolución de mis acciones,
para comprender su desempeño de forma visual.

### Criterios de Aceptación
Escenario 1: Visualización del gráfico de rendimiento con datos
- Dado que el usuario ha registrado previamente acciones y se encuentra en la pestaña "Stock Consolidation",
- Cuando selecciona la acción "MSFT" en el menú desplegable y hace clic en "Stock Performance Over Time",
- Entonces se muestra un gráfico de líneas con:
  - Cumulative Purchase Price (USD): Línea azul que muestra el precio acumulado de compra.
  - Cumulative Current Price (USD): Línea verde que muestra el precio acumulado actual.
  - Total Performance (USD): Línea naranja que muestra el rendimiento total (ganancia/pérdida acumulada).

Escenario 2: Gráfico sin datos cuando no se ha seleccionado un símbolo
- Dado que el usuario está en la pestaña "Stock Consolidation" con el selector en "Select a symbol" (sin seleccionar ninguna acción),
- Cuando hace clic en "Stock Performance Over Time",
- Entonces el gráfico se muestra vacío, sin líneas, ya que no hay datos disponibles.


### Tareas de implementación
1.	Implementar la lógica para calcular los datos del gráfico. (3 horas)
2.	Integrar Chart.js en la interfaz de usuario para mostrar el gráfico. (3 horas)
3.	Probar la funcionalidad con datos reales y simulados. (2 horas) 
