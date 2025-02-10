# Manual de Usuario: Stock Management
----------------------------------------------------------------------------------------------------------------------------
# 1. Introducción

El sistema de gestión de acciones Stock Management System permite registrar, visualizar y consolidar acciones adquiridas, aporta con información sobre las ganancias y pérdidas. Además, permite la generación de reportes en formato PDF y la representación gráfica del rendimiento de las acciones.

# 2. Requisitos del Sistema

- Navegador web actualizado (Chrome, Firefox, Edge)
- Conexión a Internet

# Pasos para usar el sistema

## Acceso al Sistema

1. Abrir el navegador web.
2. Ingresar la URL del sistema.
3. Se mostrará la pantalla principal con las opciones disponibles.

![image](https://github.com/user-attachments/assets/15f2d584-1b8e-4af4-91f9-f811901de757)


## Registro de una Nueva Acción

1. Hacer clic en el botón "Register New Stock". Se abrirá una ventana emergente con un formulario.

![image](https://github.com/user-attachments/assets/591a03fe-6efb-4d86-b411-cdc03f8b3bdd)


2. Completar los siguientes campos:

- Symbol: Código de la acción.
- Purchase Price (USD): Precio de compra por unidad.
- Quantity: Cantidad adquirida.
- Purchase Date: Fecha de compra.
- Presionar el botón "Save".

![image](https://github.com/user-attachments/assets/513a8ab1-cc8b-4f8b-a5d3-0f572b3a6480)

3. La acción será guardada y aparecerá en la lista de acciones registradas.

![image](https://github.com/user-attachments/assets/dd89673f-fae9-4f88-8190-c477f02b88ff)


## Visualización de Acciones Registradas

En la pantalla principal, en la sección "My stock", se mostrará la lista de acciones registradas. La tabla presenta la siguiente información:

- Stock Name
- Quantity
- Purchase Date
- Purchase Price (USD)
- Current Date
- Current Price (USD)
- Unit Gain (USD)
- Unit Percentage (%)
- Total Balance (USD)
- Total Gain (USD)

Se puede ordenar la lista según diferentes criterios utilizando el selector "Sort by".

![image](https://github.com/user-attachments/assets/0c699c7c-7db0-493a-9f2c-244b3f6598f7)

## Consolidación de Acciones

1. Hacer clic en la pestaña "Stock Consolidation".

![image](https://github.com/user-attachments/assets/ee2313bf-e55a-420a-875e-bd21c47e6331)

2. Seleccionar un símbolo de acción en el desplegable "Symbol".

![image](https://github.com/user-attachments/assets/947f8974-4a31-408e-a0e2-c9467f35a69d)

3. Se mostrará un resumen con la siguiente información:
- Total Quantity of Stocks Purchased
- Total Value of Stocks Purchased (USD)
- Cost Price (USD)
- % Gain/Loss
- $ Gain/Loss

![image](https://github.com/user-attachments/assets/28708fd8-2bde-4122-bcfe-08165652721c)

4. Presionar "Summary Purchases" para ver un desglose de compras.

![image](https://github.com/user-attachments/assets/078eab22-303a-4933-b64b-3f4314c273a3)

5. Hacer clic en "Stock Performance Over Time" para visualizar un gráfico del rendimiento de la acción a lo largo del tiempo.

![image](https://github.com/user-attachments/assets/61399797-c10c-4507-a1eb-b468043b1169)

### Gráfico de Rendimiento de Acciones

1. En la pantalla de Stock Consolidation, hacer clic en "Stock Performance Over Time".
2. Se mostrará un gráfico con:
- Cumulative Purchase Price (USD)
- Cumulative Current Price (USD)
- Total Performance (USD)
Nota: Si no hay datos registrados, el gráfico estará vacío.

## Generación de Reportes en PDF

Desde la pantalla de Stock Consolidation, seleccionar un símbolo.

1. Hacer clic en el botón "Download PDF".

![image](https://github.com/user-attachments/assets/e8bc67f2-1e8a-43dd-b88c-053177fdb7a3)

Nota: Se generará y descargará un informe en formato PDF con los datos de la acción seleccionada.

## Posibles Problemas y Soluciones

1. No se pueden registrar acciones
- **Causa**: Faltan campos obligatorios o se ingresaron valores negativos.
- **Solución**: Asegúrese de completar todos los campos correctamente y de ingresar valores positivos en "Purchase Price" y "Quantity".

2. No aparecen las acciones registradas
- **Causa**: No hay registros guardados o hay un problema con la base de datos.
- **Solución**: Intente recargar la página. Si el problema persiste, verifique la conexión a Internet o contacte al soporte.

3. No se genera el archivo PDF
- **Causa**: No se ha seleccionado un símbolo de acción o hay un error en la generación del archivo.
- **Solución**: Asegúrese de haber seleccionado un símbolo antes de presionar "Download PDF".

4. El gráfico de rendimiento no muestra datos
- **Causa**: No hay datos suficientes o el símbolo seleccionado no tiene registros.
- **Solución**: Verifique que haya registrado transacciones con el símbolo seleccionado.

## Consideraciones Finales

- Se recomienda ingresar datos precisos para un correcto análisis de inversiones.
- Si hay problemas al guardar o visualizar datos, revisar la conexión a Internet.
