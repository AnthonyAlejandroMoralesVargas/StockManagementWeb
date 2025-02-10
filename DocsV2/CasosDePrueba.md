# Casos de Prueba

## ID: P-001 - Registro de compra de acciones
**Descripción:** Se verifica que el registro se cree correctamente una nueva acción en el sistema de gestión de acciones. Se validará que la acción registrada aparezca en la lista de acciones con los valores ingresados correctamente, así como la correcta actualización del balance total y el cálculo de las ganancias o pérdidas generadas.
### **Procedimiento de Prueba**
1.	Navegar a la pestaña “Home”.
2.	Hacer clic en el botón "Register New Stock".
3.	Se abrirá un formulario emergente donde se deben completar los siguientes campos:
•	Symbol: “AAPL”
•	Purchase Price (USD): 200
•	Quantity: 2
•	Purchase Date: 06/02/2025
4.	Hacer clic en "Save" para registrar la acción.

### **Resultados Esperados**
- La acción ingresada debe aparecer en la lista "My stock" con la información correcta.

### **Ejecuciones del Caso de Prueba**
- **Fecha:** 08/02/2025
- **Responsable:** Kerlly Vizuete
- **Resultados Obtenidos:**
  - Se permite el ingreso de los datos con las respectivas validaciones
  - **Estado:** ✅ Aprobado
![image](https://github.com/user-attachments/assets/6dbced1f-595e-46b1-a34f-adda84103789)
  - Los datos ingresados se guardan correctamente y se ven reflejados en la lista de acciones ingresadas
  - **Estado:** ✅ Aprobado
![image](https://github.com/user-attachments/assets/1839580a-cbb1-4652-8630-8879865991f3)

---

## ID: P-002 - Ordenamiento por nombre
**Descripción:** Se verificar que la funcionalidad de ordenamiento por nombre en la sección "My stock" del sistema funcione correctamente. Se probará si los registros de acciones se ordenan alfabéticamente de manera ascendente cuando se selecciona la opción de orden por nombre. También se validará que los datos de las acciones permanezcan intactos después del ordenamiento.
### **Procedimiento de Prueba**
1.	Navegar a la pestaña "Home".
2.	Registrar varias acciones con diferentes nombres MSFT, AMZN y AAPL. 
3.	Verificar que las acciones aparecen en el orden en que fueron ingresadas.
4.	En el selector "Sort by", elegir la opción "Order By Name".
5.	Confirmar que la lista de acciones se reorganiza en orden alfabético ascendente.
6.	Revisar que los valores de cada acción “Stock Name”, “Quantity”, “Purchase Date”, “Purchase Price (USD)”, “Current Date”, “Current Price (USD)”, “Unit Gain (USD)”, “Unit Percentage (%)”, “Total Balance (USD)”, “Total Gain (USD)” permanezcan inalterados tras la ordenación.

### **Resultados Esperados**
- Las acciones deben ordenarse alfabéticamente de manera ascendente con la información de cada acción debe permanecer intacta tras el ordenamiento.

### **Ejecuciones del Caso de Prueba**
- **Fecha:** 08/02/2025
- **Responsable:** Kerlly Vizuete
- **Resultados Obtenidos:**
  - Al seleccionar la opción "Ordenar por nombre", los registros se reorganizaron correctamente en orden alfabético y no se presentaron errores ni modificaciones inesperadas en los datos de las acciones.
  - **Estado:** ✅ Aprobado
![image](https://github.com/user-attachments/assets/1bfd8b04-b98f-4cb7-bfa5-206a7c706f03)

---

## ID: P-003 - Ordenamiento por ganancia ascendente
**Descripción:** Se verifica que la funcionalidad de ordenamiento por ganancia unitaria en orden ascendente funcione correctamente en la sección "My stock". Se validará que las acciones con menor ganancia aparezcan primero en la lista y que la información de cada acción permanezca intacta después de la ordenación.
### **Procedimiento de Prueba**
1.	Navegar a la pestaña "Home".
2.	Registrar correctamente varias acciones.
3.	En el selector "Sort by", elegir la opción "Unit Gain Ascending".
4.	Confirmar que la lista de acciones se reorganiza con las de menor ganancia unitaria en la parte superior.
5.	Revisar que los valores de cada acción “Stock Name”, “Quantity”, “Purchase Date”, “Purchase Price (USD)”, “Current Date”, “Current Price (USD)”, “Unit Gain (USD)”, “Unit Percentage (%)”, “Total Balance (USD)”, “Total Gain (USD)” permanezcan inalterados tras la ordenación.

### **Resultados Esperados**
- Las acciones deben ordenarse en función de la Unit Gain (USD) de menor a mayor. Las acciones con valores negativos deben aparecer antes que las positivas.

### **Ejecuciones del Caso de Prueba**
- **Fecha:** 08/02/2025
- **Responsable:** Kerlly Vizuete
- **Resultados Obtenidos:**
  - Al seleccionar la opción " Unit Gain Ascending", los registros se reorganizaron correctamente desde el menor al mayor.
  - **Estado:** ✅ Aprobado
![image](https://github.com/user-attachments/assets/ddc40608-5209-4658-88a5-a595c7b9c89d)

---

## ID: P-004 - Ordenamiento por ganancia descendente
**Descripción:** Se verifica que la funcionalidad de ordenamiento por ganancia unitaria en orden descendente funcione correctamente en la sección "My stock". Se validará que las acciones con mayor ganancia aparezcan primero en la lista y que la información de cada acción permanezca intacta después de la ordenación.
### **Procedimiento de Prueba**
1.	Navegar a la pestaña "Home".
2.	Registrar correctamente varias acciones.
3.	En el selector "Sort by", elegir la opción "Unit Gain Descending".
4.	Confirmar que la lista de acciones se reorganiza con las de mayor ganancia unitaria en la parte superior.
5.	Revisar que los valores de cada acción “Stock Name”, “Quantity”, “Purchase Date”, “Purchase Price (USD)”, “Current Date”, “Current Price (USD)”, “Unit Gain (USD)”, “Unit Percentage (%)”, “Total Balance (USD)”, “Total Gain (USD)” permanezcan inalterados tras la ordenación.

### **Resultados Esperados**
- Las acciones deben ordenarse en función de la Unit Gain (USD) de mayor a menor. Las acciones con valores negativos deben aparecer después que las positivas.
- 
### **Ejecuciones del Caso de Prueba**
- **Fecha:** 08/02/2025
- **Responsable:** Kerlly Vizuete
- **Resultados Obtenidos:**
  - Al seleccionar la opción " Unit Gain Descending", los registros se reorganizaron correctamente desde el mayor al menor.
  - **Estado:** ✅ Aprobado
![image](https://github.com/user-attachments/assets/442747af-2d7c-45d7-a82c-b2cc589d0378)

---

## ID: P-005 - Consolidación de acciones por abreviatura
**Descripción:** Se verifica que la funcionalidad de consolidación de acciones por abreviatura funcione correctamente. Se validará que, al seleccionar una abreviatura de acción en la sección "Stock Consolidation", el sistema muestre la información consolidada de todas las compras realizadas para esa acción. 

### **Procedimiento de Prueba**
1.	Navegar a la pestaña "Stock Consolidation".
2.	En el desplegable "Symbol", seleccionar AAPL
3.	Verificar que se muestre la información consolidada de todas las compras realizadas para esa acción.
4.	Validar que los valores consolidados coincidan con los datos de compras individuales de esa acción en la sección "My stock".

### **Resultados Esperados**
- Al seleccionar una abreviatura, el sistema debe mostrar correctamente la información consolidada de todas las compras realizadas para esa acción.
- 
### **Ejecuciones del Caso de Prueba**
- **Fecha:** 08/02/2025
- **Responsable:** Kerlly Vizuete
- **Resultados Obtenidos:**
  - Se seleccionó una abreviatura válida en el campo "Symbol". El sistema consolidó correctamente la información de todas las compras de la acción seleccionada. Los valores mostrados coincidieron con los cálculos esperados.
  - **Estado:** ✅ Aprobado
![image](https://github.com/user-attachments/assets/3359b597-3d8c-4a04-a2f2-f0826b123201)

---

## ID: P-006 - Generación de documento PDF de consolidación
**Descripción:** Se verifica que la funcionalidad de generación de un documento en formato PDF desde la pantalla de consolidación de acciones funcione correctamente. Se validará que el informe contenga la información consolidada de una acción seleccionada, con los datos correctos, y que su descarga sea correcta.

### **Procedimiento de Prueba**
1.	Navegar a la pestaña "Stock Consolidation".
2.	En el campo "Symbol", seleccionar AAPL
3.	Hacer clic en el botón "Download PDF".
4.	Confirmar que se inicie la descarga del archivo en formato PDF.
5.	Abrir el archivo descargado y verificar que contenga la siguiente información:
•	Título “Stock Consolidation Report”
•	Símbolo de la acción “Symbol: AAPL”.
•	Una tabla de métricas con los valores que le corresponden a “Total Quantity of Stocks Purchased”, “Total Value of Stocks Purchased (USD)”, “Cost Price (USD)”, “% Gain/Loss”, “$ Gain/Loss”
•	Una tabla con el resumen de compras con los valores que le corresponden a “Purchase Date”, Stock”, “Purchase Price (USD)”, “Quantity” y “USD Purchase”
•	Fecha en la que se generó el informe como “Generated on: 08-02-2025”
6.	Confirmar que el diseño del documento es legible, organizado y sin errores de formato.

### **Resultados Esperados**
- Al hacer clic en "Download PDF", el archivo debe generarse y descargarse correctamente. El documento PDF debe contener toda la información consolidada de la acción seleccionada con valores correctos. La estructura y formato del documento deben ser claros y bien organizados.
- 
### **Ejecuciones del Caso de Prueba**
- **Fecha:** 08/02/2025
- **Responsable:** Kerlly Vizuete
- **Resultados Obtenidos:**
  - Se seleccionó una abreviatura válida en el campo "Symbol". El sistema consolidó correctamente la información de la acción.
  - **Estado:** ✅ Aprobado
![image](https://github.com/user-attachments/assets/d4d33864-8b93-49b9-8007-fc6223c80190)
  - Se generó correctamente el informe en PDF con los datos esperados. El documento fue descargado y su contenido verificado con éxito.
![image](https://github.com/user-attachments/assets/f7c853ca-0f72-4abc-bd7a-6628b7d41e9f)

---

## ID: P-007 - Obtención del resumen de compras
**Descripción:** Se verifica que el sistema pueda mostrar correctamente el resumen de compras de una acción seleccionada en la pestaña "Stock Consolidation". Se validará que los datos presentados sean correctos y coincidan con las compras individuales realizadas previamente. 

### **Procedimiento de Prueba**
1.	Navegar a la pestaña "Stock Consolidation".
2.	En el campo "Symbol", seleccionar AAPL
3.	Hacer clic en el botón "Summary Purchases".
4.	Confirmar que la tabla contenga la siguiente información de “Purchase Date”, “Stock”, “Purchase Price (USD)”, “Quantity”, ”USD Purchase” y “Gain/Loss (USD)”  

### **Resultados Esperados**
- Al hacer clic en "Summary Purchases", se debe mostrar una tabla con el historial de compras de la acción seleccionada. Los valores mostrados en la tabla deben coincidir con los datos de compras ingresados previamente en el sistema.

### **Ejecuciones del Caso de Prueba**
- **Fecha:** 08/02/2025
- **Responsable:** Kerlly Vizuete
- **Resultados Obtenidos:**
  - Se seleccionó una abreviatura válida en el campo "Symbol". El sistema mostró correctamente el historial de compras de la acción seleccionada. Los valores en la tabla coincidieron con los datos de compras ingresados previamente.
  - **Estado:** ✅ Aprobado
![image](https://github.com/user-attachments/assets/07a2df5d-6c5e-4ceb-bf10-35378708abbc)

---

## ID: P-008 - Obtención del rendimiento de las acciones
**Descripción:** Se verifica que el sistema pueda mostrar correctamente el rendimiento de las acciones a lo largo del tiempo en la sección "Stock Consolidation". Se evaluará la generación de gráficos con datos históricos de compra y el comportamiento del valor de las acciones.

### **Procedimiento de Prueba**
1.	Navegar a la pestaña "Stock Consolidation".
2.	En el campo "Symbol", seleccionar AAPL 
3.	Hacer clic en el botón "Stock Performance Over Time".
4.	Confirmar que el gráfico muestre correctamente las siguientes métricas “Purchase Price” para el eje X y “Value in USD” para el eje Y con indicativos de “Cumulative Purchase Price (USD)”, “Cumulative Current Price (USD)” y “Total Performance (USD)”
5.	Validar que la representación gráfica corresponda con los datos de compras y valores actuales de la acción.

### **Resultados Esperados**
- Al hacer clic en "Stock Performance Over Time", se debe generar un gráfico que refleje la evolución del rendimiento de la acción seleccionada. Los datos del gráfico deben coincidir con los valores históricos de compra y los precios actuales de la acción.

### **Ejecuciones del Caso de Prueba**
- **Fecha:** 08/02/2025
- **Responsable:** Kerlly Vizuete
- **Resultados Obtenidos:**
  - Se seleccionó una abreviatura válida en el campo "Symbol". El sistema generó el gráfico con los datos históricos de la acción. Los valores del gráfico coincidieron con los datos de compras y precios actuales. 
  - **Estado:** ✅ Aprobado
![image](https://github.com/user-attachments/assets/2c488587-0111-42b0-9d88-9e0e933bc2b0)
