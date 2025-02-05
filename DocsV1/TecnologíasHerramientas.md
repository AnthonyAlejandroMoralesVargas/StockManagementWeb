# Especificación de Tecnologías y Herramientas

## Objetivo:

Este documento tiene como objetivo especificar las tecnologías y herramientas que se utilizarán en el desarrollo de la aplicación de escritorio para gestionar acciones.

---

## 1. Lenguaje de Programación

El lenguaje de programación elegido para el desarrollo de esta aplicación es Java, debido a su amplia documentación, su activa comunidad y la gran cantidad de librerías y frameworks disponibles. Tal como Java Swing que es una de las librerías que más utilizadas para crear interfaces gráficas de usuario. Además, Java ofrece diversas bibliotecas para interactuar con APIs RESTful, lo que, sumado a su flexibilidad para gestionar solicitudes HTTP y analizar respuestas en formato JSON, facilita la integración con servicios externos de manera eficiente.

## 2. Desarrollo del Frontend y Backend

El entorno de desarrollo integrado (IDE) utilizado para desarrollar el frontend y backend de la aplicación "Stock Management" es Apache NetBeans, puesto que es ideal para trabajar con Java y proporciona soporte completo para el desarrollo de interfaces gráficas de usuario (GUI) mediante la librería Java Swing.

## 3. Librería respuestas JSON

Para analizar las respuestas en formato JSON obtenidas desde la API de Alpha Vantage, se utilizará la biblioteca org.json. Esta librería proporciona métodos eficientes para parsear, manipular y extraer datos desde estructuras JSON, permitiendo una integración entre la API y la lógica de negocio de la aplicación.

## 4. Control de Versiones

Git será el sistema de control de versiones que se utilizará para llevar un registro de todos los cambios en el código fuente, gestionar ramas para nuevas funcionalidades y facilitar la colaboración entre los miembros del equipo. Esto en compañia de GitHub que servirá como el repositorio principal para almacenar el código fuente.

## 5. API de Alpha Vantage

La API de Alpha Vantage proporcionará los precios de las acciones en tiempo real. Utilizando esta API, el backend de la aplicación podrá obtener información actualizada sobre los precios de las acciones.

