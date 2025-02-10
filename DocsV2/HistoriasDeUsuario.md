# Historias de Usuario

## HU-001: Registrar una nueva acción
**Prioridad:** Alta  
**Estimación:** 5 SP  

### Historia de usuario
Como usuario del sistema de gestión de acciones, quiero registrar mis acciones, para mantener un registro centralizado de mis acciones.

### Criterios de Aceptación
#### Escenario 1: Registro exitoso de una acción
- **Dado** que el usuario se encuentra en la pantalla principal y hace clic en "Register New Stock".
- **Cuando** completa el formulario con:
  - **Símbolo:** "AAPL"
  - **Precio de compra:** 150.00
  - **Cantidad:** 10
  - **Fecha de compra:** "2023-10-01"
  - **Cuando** hace clic en "Guardar".
- **Entonces** la acción se registra correctamente en la base de datos y se muestra el mensaje: "Stock added successfully!".

#### Escenario 2: Registro fallido por cantidad negativa
- **Dado** que el usuario ingresa una cantidad negativa.
- **Cuando** intenta registrar la acción.
- **Entonces** se muestra el mensaje de error: "Quantity must be positive.".

#### Escenario 3: Registro fallido por precio de compra negativo
- **Dado** que el usuario ingresa un precio negativo.
- **Cuando** intenta registrar la acción.
- **Entonces** se muestra el mensaje de error: "Purchase price must be positive.".

#### Escenario 4: Registro fallido por cantidad y precio negativos
- **Dado** que el usuario ingresa una cantidad y precio negativos.
- **Cuando** intenta registrar la acción.
- **Entonces** se muestra el mensaje de error: "Quantity and Purchase price must be positive.".

#### Escenario 5: Registro fallido por excepción inesperada
- **Dado** que ocurre un error inesperado.
- **Cuando** el usuario intenta registrar la acción.
- **Entonces** se muestra el mensaje de error: "An error occurred while registering the stock.".

### Tareas de implementación
1. Diseñar el formulario de registro. *(2 horas)*
2. Implementar la lógica de validación del formulario. *(2 horas)*
3. Integrar el servicio para guardar la acción en la base de datos. *(2 horas)*
4. Probar la funcionalidad con datos válidos e inválidos. *(2 horas)*

---

## HU-002: Ordenar acciones por nombre y ganancia/pérdida
**Prioridad:** Baja  
**Estimación:** 3 SP  

### Historia de usuario
Como usuario del sistema de gestión de acciones, quiero ordenar mis acciones, para revisar las acciones que más me interesan.

### Criterios de Aceptación
#### Escenario 1: Ordenar por nombre (símbolo)
- **Dado** que el usuario selecciona "Order by Name" en el menú desplegable.
- **Cuando** el usuario selecciona la opción.
- **Entonces** las acciones se muestran en orden alfabético.

#### Escenario 2: Ordenar por ganancia ascendente
- **Dado** que el usuario selecciona "Unit Gain Ascending".
- **Cuando** el usuario elige la opción.
- **Entonces** las acciones se ordenan de menor a mayor según su ganancia/pérdida unitaria.

#### Escenario 3: Ordenar por pérdida descendente
- **Dado** que el usuario selecciona "Unit Gain Descending".
- **Cuando** el usuario elige la opción.
- **Entonces** las acciones se ordenan de mayor a menor según su ganancia/pérdida unitaria.

### Tareas de implementación
1. Implementar la lógica de ordenamiento. *(2 horas)*
2. Modificar el código para manejar las solicitudes de ordenamiento. *(2 horas)*
3. Actualizar la interfaz de usuario. *(2 horas)*

---

## HU-003: Consolidación de acciones
**Prioridad:** Alta  
**Estimación:** 5 SP  

### Historia de usuario
Como usuario del sistema de gestión de acciones, quiero que mis acciones se consoliden, para ver un resumen detallado de mis inversiones.

### Criterios de Aceptación
#### Escenario 1: Visualización por defecto
- **Dado** que el usuario accede a "Stock Consolidation".
- **Cuando** ve la interfaz.
- **Entonces** el selector de símbolos muestra "Select a symbol" y el resumen está vacío.

#### Escenario 2: No hay compras registradas
- **Dado** que el usuario no ha seleccionado un símbolo.
- **Cuando** ve la interfaz.
- **Entonces** se muestra el mensaje "No stock purchases recorded.".

#### Escenario 3: Selección de símbolo y visualización del resumen
- **Dado** que el usuario selecciona un símbolo registrado.
- **Cuando** elige un símbolo.
- **Entonces** se muestra el resumen con estadísticas.

### Tareas de implementación
1. Implementar la lógica de consolidación. *(2 horas)*
2. Actualizar la interfaz de usuario. *(2 horas)*
3. Probar la funcionalidad con datos reales y simulados. *(2 horas)*

---

## HU-004: Generación de informe en PDF
**Prioridad:** Alta  
**Estimación:** 5 SP  

### Historia de usuario
Como usuario del sistema de gestión de acciones, quiero descargar la información consolidada en un PDF, para acceder a la información en cualquier momento.

### Criterios de Aceptación
#### Escenario 1: Generación de PDF exitosa
- **Dado** que el usuario ha consolidado las acciones.
- **Cuando** hace clic en "Descargar PDF".
- **Entonces** se genera y descarga un informe.

### Tareas de implementación
1. Implementar la generación de PDF. *(3 horas)*
2. Integrar el botón de descarga. *(2 horas)*
3. Probar la funcionalidad. *(1 hora)*

---

## HU-005: Visualización de gráfico de rendimiento
**Prioridad:** Media  
**Estimación:** 5 SP  

### Historia de usuario
Como usuario del sistema de gestión de acciones, quiero visualizar un gráfico con la evolución de mis acciones, para comprender su desempeño de forma visual.

### Criterios de Aceptación
#### Escenario 1: Visualización con datos
- **Dado** que el usuario tiene acciones registradas.
- **Cuando** selecciona una acción y hace clic en "Stock Performance Over Time".
- **Entonces** se muestra un gráfico de líneas con:
  - Precio acumulado de compra.
  - Precio acumulado actual.
  - Rendimiento total.

#### Escenario 2: Gráfico sin datos
- **Dado** que el usuario no selecciona una acción.
- **Cuando** intenta visualizar el gráfico.
- **Entonces** el gráfico se muestra vacío.

### Tareas de implementación
1. Implementar la lógica del gráfico. *(3 horas)*
2. Integrar Chart.js en la interfaz. *(3 horas)*
3. Probar la funcionalidad. *(2 horas)*
