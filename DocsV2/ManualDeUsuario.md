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

![image](https://github.com/user-attachments/assets/7e797171-188b-40d6-b7a4-4528f183aa3e)

## Registro de una Nueva Acción

1. Hacer clic en el botón "Register New Stock". Se abrirá una ventana emergente con un formulario.

![image](https://github.com/user-attachments/assets/7713b42c-436d-4fe4-ae07-e5e623eef20c)

2. Completar los siguientes campos:

- Symbol: Código de la acción.
- Purchase Price (USD): Precio de compra por unidad.
- Quantity: Cantidad adquirida.
- Purchase Date: Fecha de compra.
- Presionar el botón "Save".

![image](https://github.com/user-attachments/assets/b1e16d52-9c48-401e-a5e1-b0b43466846c)

3. La acción será guardada y aparecerá en la lista de acciones registradas.

![image](https://github.com/user-attachments/assets/f22f0d27-e966-4966-8a18-342b3c1c286b)

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

![image](https://github.com/user-attachments/assets/7dd33211-0926-4fdc-938e-221ed9609e91)

## Consolidación de Acciones

1. Hacer clic en la pestaña "Stock Consolidation".

![image](https://github.com/user-attachments/assets/aa62c706-6dce-477d-828b-0a10b867583c)

2. Seleccionar un símbolo de acción en el desplegable "Symbol".

![image](https://github.com/user-attachments/assets/08164c4a-5616-4157-b4f4-d1555106bf66)

3. Se mostrará un resumen con la siguiente información:
- Total Quantity of Stocks Purchased
- Total Value of Stocks Purchased (USD)
- Cost Price (USD)
- % Gain/Loss
- $ Gain/Loss

![image](https://github.com/user-attachments/assets/4d21c57a-1f0c-4c6d-8b5f-c716e9bd5dfb)

4. Presionar "Summary Purchases" para ver un desglose de compras.

![image](https://github.com/user-attachments/assets/a812b370-13ef-4d5e-ac00-8634f748e091)

5. Hacer clic en "Stock Performance Over Time" para visualizar un gráfico del rendimiento de la acción a lo largo del tiempo.

![image](https://github.com/user-attachments/assets/bed1cc18-b72c-4b89-9373-20ac92b4cd0b)

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

![image](https://github.com/user-attachments/assets/7ef837bd-7290-451c-a2f5-49cc6e23c522)

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
