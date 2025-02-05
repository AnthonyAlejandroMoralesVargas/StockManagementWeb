La API se agrupa en ocho categorías: (1) API de datos de acciones de series temporales básicas, (2) API de datos de opciones de EE. UU., (3) Alpha Intelligence™, (4) Datos fundamentales, (5) Monedas físicas y digitales/criptomonedas (por ejemplo, Bitcoin), (6) Materias primas, (7) Indicadores económicos y (8) Indicadores técnicos.

Para este proyecto se usa específicamente **API de datos de acciones de series temporales básicas**
---
# API de datos bursátiles de series temporales
## Conjunto de API de Renta Variable Global

Este conjunto de API proporciona datos de renta variable globales en cuatro resoluciones temporales diferentes:  
1. **Diaria**  
2. **Semanal**  
3. **Mensual**  
4. **Intradiaria**  

Ofrece un punto final de cotización de ticket ligero y varias funciones de utilidad, como búsqueda de tickets y estado de apertura/cierre del mercado.

---

## **TIME_SERIES_INTRADAY Tendencias**

Esta API devuelve la serie temporal intradiaria de **OHLCV** (Open, High, Low, Close, Volume) actual y con más de 20 años de historial.  
- **Cobertura horaria:** Incluye horas previas y posteriores a la apertura del mercado (por ejemplo, de 4:00 a. m. a 8:00 p. m., hora del este, para el mercado de EE. UU.).  
- **Datos disponibles:** Datos intradiarios brutos y ajustados por dividendos/divisiones históricas.  
- **Terminología:** Los datos de OHLCV también son conocidos como "velas" en la literatura financiera.

---

## **Parámetros de la API**

### Obligatorios
- **`function`:** La serie temporal deseada. En este caso: `function=TIME_SERIES_INTRADAY`.  
- **`symbol`:** Nombre del valor. Ejemplo: `symbol=IBM`.  
- **`interval`:** Intervalo de tiempo entre dos puntos consecutivos. Valores admitidos:  
  `1min`, `5min`, `15min`, `30min`, `60min`.  

### Opcionales
- **`adjusted`:**  
  - Predeterminado: `adjusted=true` (ajusta la salida según eventos históricos).  
  - Para datos intradiarios brutos: `adjusted=false`.  

- **`extended_hours`:**  
  - Predeterminado: `extended_hours=true` (incluye horarios extendidos).  
  - Solo horario habitual: `extended_hours=false` (9:30 a. m. a 4:00 p. m., hora del este).  

- **`month`:**  
  - Sin configurar: devuelve datos recientes.  
  - Para consultar un mes específico (formato `AAAA-MM`): `month=2009-01`.  
  - Admite meses desde enero de 2000 (`2000-01`).  

- **`outputsize`:**  
  - Predeterminado: `outputsize=compact` (últimos 100 puntos de datos o 30 días recientes).  
  - Para datos completos de un mes histórico: `outputsize=full`.  

- **`datatype`:**  
  - Predeterminado: `datatype=json` (JSON).  
  - Opción CSV: `datatype=csv`.  

---

## **Ejemplos**

1. **Consulta predeterminada:** Últimos 100 puntos de datos intradiarios.  
   [Resultado JSON](https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=IBM&interval=5min&apikey=demo)

2. **Últimos 30 días de datos completos:**  
   [Resultado JSON](https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=IBM&interval=5min&outputsize=full&apikey=demo)

3. **Datos de un mes específico (por ejemplo, enero de 2009):**  
   [Resultado JSON](https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=IBM&interval=5min&month=2009-01&outputsize=full&apikey=demo)

4. **Archivo CSV descargable:**  
   [Descargar CSV](https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=IBM&interval=5min&apikey=demo&datatype=csv)

---
# SERIE_TEMPORAL_DIARIA

Esta API proporciona series temporales diarias sin procesar de las acciones globales especificadas. Los datos incluyen:  
- **Fecha**,  
- **Apertura diaria**,  
- **Máximo diario**,  
- **Mínimo diario**,  
- **Cierre diario**,  
- **Volumen diario**.  

Los datos **OHLCV** (Open, High, Low, Close, Volume) son comúnmente referidos como "velas" en la literatura financiera.  

---

## **Parámetros de la API**

### Obligatorios
- **`function`:** La serie temporal deseada. En este caso: `function=TIME_SERIES_DAILY`.  
- **`symbol`:** Nombre del valor. Ejemplo: `symbol=IBM`.  

### Opcionales
- **`outputsize`:**  
  - Predeterminado: `outputsize=compact` (últimos 100 puntos de datos).  
  - Para la serie completa de más de 20 años: `outputsize=full`.  
  - **Recomendación:** Usa la opción "compacta" para reducir el tamaño de los datos por llamada a la API.  

- **`datatype`:**  
  - Predeterminado: `datatype=json` (formato JSON).  
  - Opción CSV: `datatype=csv`.  

---

## **Ejemplos**

1. **Ticket negociado en Estados Unidos:**  
   - [JSON](https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=IBM&apikey=demo)  
   - [JSON con datos completos](https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=IBM&outputsize=full&apikey=demo)  

2. **Ticket negociado en Reino Unido (Bolsa de Londres):**  
   [JSON](https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=TSCO.LON&outputsize=full&apikey=demo)  

3. **Ticket negociado en Canadá (Bolsa de Toronto):**  
   [JSON](https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=SHOP.TRT&outputsize=full&apikey=demo)  

4. **Ticket negociado en Canadá (Toronto Venture Exchange):**  
   [JSON](https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=GPV.TRV&outputsize=full&apikey=demo)  

5. **Ticket negociado en Alemania (XETRA):**  
   [JSON](https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=MBG.DEX&outputsize=full&apikey=demo)  

6. **Ticket negociado en India (BSE):**  
   [JSON](https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=RELIANCE.BSE&outputsize=full&apikey=demo)  

7. **Ticket negociado en China (Bolsa de Shanghái):**  
   [JSON](https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=600104.SHH&outputsize=full&apikey=demo)  

8. **Ticket negociado en China (Bolsa de Shenzhen):**  
   [JSON](https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=000002.SHZ&outputsize=full&apikey=demo)  

---

## **Archivo CSV descargable**
[Descargar CSV](https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=IBM&apikey=demo&datatype=csv)

---
# SERIE_TEMPORAL_AJUSTADA_DIARIA

Esta API proporciona:
- Valores diarios brutos (apertura, máximo, mínimo, cierre, volumen).
- Valores de cierre ajustados.
- Eventos históricos de divisiones y dividendos.  

Cubre más de **20 años de datos históricos** de acciones globales.  
Los datos **OHLCV** (Open, High, Low, Close, Volume) también se conocen como "velas" en la literatura financiera.

---

## **Parámetros de la API**

### Obligatorios
- **`function`:** La serie temporal deseada. En este caso: `function=TIME_SERIES_DAILY_ADJUSTED`.  
- **`symbol`:** Nombre del valor. Ejemplo: `symbol=IBM`.  

### Opcionales
- **`outputsize`:**  
  - Predeterminado: `outputsize=compact` (últimos 100 puntos de datos).  
  - Para la serie completa de más de 20 años: `outputsize=full`.  
  - **Recomendación:** Usa la opción "compacta" para reducir el tamaño de los datos por llamada a la API.  

- **`datatype`:**  
  - Predeterminado: `datatype=json` (formato JSON).  
  - Opción CSV: `datatype=csv`.    

---

## **Ejemplos**

1. **Ticket negociado en Estados Unidos:**  
   - [JSON](https://www.alphavantage.co/query?function=TIME_SERIES_DAILY_ADJUSTED&symbol=IBM&apikey=demo)  
   - [JSON con datos completos](https://www.alphavantage.co/query?function=TIME_SERIES_DAILY_ADJUSTED&symbol=IBM&outputsize=full&apikey=demo)  

2. **Ticket negociado en Reino Unido (Bolsa de Londres):**  
   [JSON](https://www.alphavantage.co/query?function=TIME_SERIES_DAILY_ADJUSTED&symbol=TSCO.LON&outputsize=full&apikey=demo)  

3. **Ticket negociado en Canadá (Bolsa de Toronto):**  
   [JSON](https://www.alphavantage.co/query?function=TIME_SERIES_DAILY_ADJUSTED&symbol=SHOP.TRT&outputsize=full&apikey=demo)  

4. **Ticket negociado en Canadá (Toronto Venture Exchange):**  
   [JSON](https://www.alphavantage.co/query?function=TIME_SERIES_DAILY_ADJUSTED&symbol=GPV.TRV&outputsize=full&apikey=demo)  

5. **Ticket negociado en Alemania (XETRA):**  
   [JSON](https://www.alphavantage.co/query?function=TIME_SERIES_DAILY_ADJUSTED&symbol=MBG.DEX&outputsize=full&apikey=demo)  

6. **Ticket negociado en India (BSE):**  
   [JSON](https://www.alphavantage.co/query?function=TIME_SERIES_DAILY_ADJUSTED&symbol=RELIANCE.BSE&outputsize=full&apikey=demo)  

7. **Ticket negociado en China (Bolsa de Shanghái):**  
   [JSON](https://www.alphavantage.co/query?function=TIME_SERIES_DAILY_ADJUSTED&symbol=600104.SHH&outputsize=full&apikey=demo)  

8. **Ticket negociado en China (Bolsa de Shenzhen):**  
   [JSON](https://www.alphavantage.co/query?function=TIME_SERIES_DAILY_ADJUSTED&symbol=000002.SHZ&outputsize=full&apikey=demo)  

---

## **Archivo CSV descargable**
[Descargar CSV](https://www.alphavantage.co/query?function=TIME_SERIES_DAILY_ADJUSTED&symbol=IBM&apikey=demo&datatype=csv)

---
# SERIE_TEMPORAL_SEMANAL

Esta API devuelve:
- Series de tiempo semanales:  
  Último día de negociación de cada semana, apertura semanal, máximo semanal, mínimo semanal, cierre semanal y volumen semanal.
- Cubre más de **20 años de datos históricos** de valores globales.

---

## **Parámetros de la API**

### Obligatorios
- **`function`:** La serie temporal deseada. En este caso: `function=TIME_SERIES_WEEKLY`.  
- **`symbol`:** Nombre del valor. Ejemplo: `symbol=IBM`.  
- **`apikey`:** Tu clave API. [Solicítala aquí](https://www.alphavantage.co/support/#api-key).  

### Opcional
- **`datatype`:**  
  - Predeterminado: `datatype=json` (formato JSON).  
  - Opción CSV: `datatype=csv`.  

---

## **Ejemplos**

1. **Ticket negociado en Estados Unidos:**  
   [JSON](https://www.alphavantage.co/query?function=TIME_SERIES_WEEKLY&symbol=IBM&apikey=demo)  

2. **Ticket negociado en Reino Unido (Bolsa de Londres):**  
   [JSON](https://www.alphavantage.co/query?function=TIME_SERIES_WEEKLY&symbol=TSCO.LON&apikey=demo)  

---

## **Archivo CSV descargable**

[Descargar CSV](https://www.alphavantage.co/query?function=TIME_SERIES_WEEKLY&symbol=IBM&apikey=demo&datatype=csv)

---
# SERIE TEMPORAL AJUSTADA SEMANALMENTE

Esta API devuelve series de tiempo ajustadas semanalmente que incluyen el último día de negociación de cada semana, apertura semanal, máximo semanal, mínimo semanal, cierre semanal, cierre ajustado semanal, volumen semanal y dividendo semanal. Está diseñada para cubrir más de 20 años de datos históricos.

## Parámetros de la API

- **Obligatorio:** `function`
La serie temporal seleccionada.  
En este caso: `function=TIME_SERIES_WEEKLY_ADJUSTED`

- **Obligatorio:** `symbol`
El nombre del valor de su elección.  
Ejemplo: `symbol=IBM`

- **Opcional:** `datatype`
- El formato de salida de los datos. Por defecto, `datatype=json`. Se aceptan las siguientes opciones:
  - `json`: Devuelve la serie temporal semanal en formato JSON.
  - `csv`: Devuelve la serie temporal como un archivo CSV.

---

# API DE DATOS BURSÁTILES DE SERIES TEMPORALES

Este conjunto de API proporciona datos de renta variable globales en cuatro resoluciones temporales:
1. **Diaria**
2. **Semanal**
3. **Mensual**
4. **Intradiaria**

Cuenta con más de 20 años de datos históricos, incluyendo:
- Cotización de tickets.
- Funciones de utilidad como búsqueda de tickets y estado de apertura/cierre del mercado.

## Ejemplo de Uso (Serie Temporal Intradiaria)

### Descripción
Esta API devuelve series intradiarias de OHLCV (Open, High, Low, Close, Volume) de la acción especificada, incluyendo horarios previos y posteriores al mercado (ejemplo: de 4:00 a. m. a 8:00 p. m., hora del Este para EE. UU.).

### Parámetros
- **Obligatorio:** `function=TIME_SERIES_INTRADAY`
- **Obligatorio:** `symbol=IBM`
- **Obligatorio:** `interval=5min` *(Valores: `1min`, `5min`, `15min`, `30min`, `60min`)*
- **Opcional:** `adjusted=true` *(Valores: `true`, `false`)*
- **Opcional:** `extended_hours=true` *(Incluye horario extendido por defecto)*
- **Opcional:** `month=2009-01` *(Historial por mes específico)*
- **Opcional:** `outputsize=compact` *(Compacto por defecto; `full` para más datos)*

### Ejemplo de Llamada
```plaintext
https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=IBM&interval=5min&apikey=demo
```

---
# SERIE_TEMPORAL_MENSUAL

Esta API devuelve series de tiempo mensuales (último día de negociación de cada mes: apertura mensual, máximo mensual, mínimo mensual, cierre mensual, volumen mensual) del capital global especificado, cubriendo más de 20 años de datos históricos.

## Parámetros de la API

- **Obligatorio:** `function`
La serie temporal de su elección. En este caso:  
`function=TIME_SERIES_MONTHLY`

- **Obligatorio:** `symbol`
El nombre del valor de su elección. Por ejemplo:  
`symbol=IBM`

- **Opcional:** `datatype`
- Especifica el formato de los datos devueltos. Los valores posibles son:
  - **`json`** (por defecto): Devuelve la serie temporal en formato JSON.
  - **`csv`**: Devuelve la serie temporal como un archivo CSV (valores separados por comas).  

Ejemplo: `datatype=csv`

- **Obligatorio:** `apikey`
Tu clave API. Solicita tu clave API gratuita [aquí](https://www.alphavantage.co/support/#api-key).

---

## Ejemplo de uso

### Salida JSON:
```plaintext
https://www.alphavantage.co/query?function=TIME_SERIES_MONTHLY&symbol=IBM&apikey=demo
```

---
# SERIE_TEMPORAL_AJUSTADA_MENSUALMENTE

Esta API devuelve series de tiempo ajustadas mensualmente (último día de negociación de cada mes: apertura mensual, máximo mensual, mínimo mensual, cierre mensual, cierre ajustado mensual, volumen mensual, dividendo mensual) del capital especificado, cubriendo más de 20 años de datos históricos.

## Parámetros de la API

- **Obligatorio:** `function`
La serie temporal de su elección. En este caso:  
`function=TIME_SERIES_MONTHLY_ADJUSTED`

- **Obligatorio:** `symbol`
El nombre del valor de su elección. Por ejemplo:  
`symbol=IBM`

- **Opcional:** `datatype`
- Especifica el formato de los datos devueltos. Los valores posibles son:
  - **`json`** (por defecto): Devuelve la serie temporal en formato JSON.
  - **`csv`**: Devuelve la serie temporal como un archivo CSV (valores separados por comas).  

Ejemplo: `datatype=csv`

- **Obligatorio:** `apikey`
Tu clave API. Solicita tu clave API gratuita [aquí](https://www.alphavantage.co/support/#api-key).

---

## Ejemplo de uso

### Salida JSON:
```plaintext
https://www.alphavantage.co/query?function=TIME_SERIES_MONTHLY_ADJUSTED&symbol=IBM&apikey=demo
```

---
# Cotización de puntos finales de tendencia

Este punto de conexión devuelve la información más reciente sobre el precio y el volumen de un ticket de su elección. Puede especificar un ticket por solicitud de API.

## Parámetros de la API

- **Obligatorio:** `function`
La función API de su elección.

- **Obligatorio:** `symbol`
El símbolo del ticket global de su elección. Por ejemplo:  
`symbol=IBM`

- **Opcional:** `datatype`
- Especifica el formato de los datos devueltos. Los valores posibles son:
  - **`json`** (por defecto): Devuelve los datos de cotización en formato JSON.
  - **`csv`**: Devuelve los datos de cotización como un archivo CSV (valores separados por comas).  

Ejemplo: `datatype=csv`

- **Obligatorio:** `apikey`
Tu clave API. Solicita tu clave API gratuita [aquí](https://www.alphavantage.co/support/#api-key).

---

## Ejemplos de uso

### Salida JSON:
```plaintext
https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=IBM&apikey=demo
```

---
# Cotizaciones masivas en tiempo real

Esta API devuelve cotizaciones en tiempo real de símbolos que se comercializan en EE. UU. de forma masiva, aceptando hasta 100 símbolos por solicitud de API y cubriendo tanto el horario de negociación regular como el extendido (previo y posterior a la apertura del mercado). Puede utilizar este punto de conexión como una alternativa de alto rendimiento a la **API de cotización global**, que acepta un símbolo por solicitud de API.

## Parámetros de la API

- **Obligatorio:** `function`
La función API de su elección. En este caso:  
`function=REALTIME_BULK_QUOTES`

- **Obligatorio:** `symbol`
Hasta 100 símbolos separados por coma. Ejemplo:  
`symbol=MSFT,AAPL,IBM`  
Si se proporcionan más de 100 símbolos, solo se tendrán en cuenta los primeros 100 símbolos como parte de la entrada de la API.

- **Obligatorio:** `apikey`
Tu clave API. Solicita tu clave API gratuita [aquí](https://www.alphavantage.co/support/#api-key).

---

## Ejemplo de uso

### Salida JSON:
```plaintext
https://www.alphavantage.co/query?function=REALTIME_BULK_QUOTES&symbol=MSFT,AAPL,IBM&apikey=demo
```

---
# Utilidad de punto final de búsqueda

La **API de búsqueda de símbolos bursátiles** permite una experiencia de búsqueda de tickets con autocompletado.

El punto final de búsqueda devuelve los símbolos y la información de mercado más coincidentes en función de las palabras clave que elija. Los resultados de la búsqueda también contienen puntuaciones de coincidencia que brindan total flexibilidad para desarrollar su propia lógica de búsqueda y filtrado.

## Parámetros de la API

- **Obligatorio:** `function`
La función API que elijas. En este caso:  
`function=SYMBOL_SEARCH`

- **Obligatorio:** `keywords`
Una cadena de texto de su elección. Ejemplo:  
`keywords=microsoft`

- **Opcional:** `datatype`
- De forma predeterminada, se aceptan `datatype=json`. Las cadenas disponibles son:  
  - `json`: Devuelve los resultados de la búsqueda en formato JSON.  
  - `csv`: Devuelve los resultados de la búsqueda como un archivo CSV (valores separados por comas).

- **Obligatorio:** `apikey`
Tu clave API. Solicita tu clave API gratuita [aquí](https://www.alphavantage.co/support/#api-key).

---

## Ejemplos de uso

### Salida JSON:
```plaintext
https://www.alphavantage.co/query?function=SYMBOL_SEARCH&keywords=tesco&apikey=demo
```

---
# Utilidad de estado de apertura y cierre del mercado global

Este punto final devuelve el estado actual del mercado (abierto vs. cerrado) de los principales lugares de negociación de acciones, divisas y criptomonedas en todo el mundo.

## Parámetros de la API

- **Obligatorio:** `function`
La función API que elijas. En este caso:  
`function=MARKET_STATUS`

- **Obligatorio:** `apikey`
Tu clave API. Solicita tu clave API gratuita [aquí](https://www.alphavantage.co/support/#api-key).

---

## Ejemplo de uso

### Salida JSON:
```plaintext
https://www.alphavantage.co/query?function=MARKET_STATUS&apikey=demo
```

