# Estándares de Commits

## **Objetivo**

Este documento tiene como propósito definir las convenciones de commit que deben seguir todos los miembros del equipo para asegurar que el historial de cambios sea claro, comprensible y fácilmente rastreable. Se utilizará el estándar Conventional Commits como base, con algunas adaptaciones específicas para el proyecto.

---

## **1. Formato de los Commits**

Los commits deben seguir el siguiente formato:

    <tipo>(<alcance>): <mensaje>
    <opcional> <cuerpo del mensaje>
    <opcional> <pie de página>

### **1.1 Componentes del Commit**

- **tipo**: Indica el propósito del commit. Puede ser uno de los siguientes:
    - **feat**: Para la adición de nuevas funcionalidades.
    - **fix**: Para corrección de errores.
    - **docs**: Cambios en la documentación.
    - **style**: Cambios en el estilo del código (formato, espacios, etc.), sin modificar la lógica.
    - **comment**: Inclusión de documentación de código que no afecta la lógica.
    - **refactor**: Refactorización del código (cambios en el código que no afectan su funcionalidad externa).
    - **test**: Añadir o modificar pruebas.
    - **chore**: Otras tareas menores que no afectan la lógica o los tests, como actualizaciones de dependencias.
    - **perf**: Cambios que mejoran el rendimiento de la aplicación.
- **alcance** (opcional): Se refiere a la parte del sistema o módulo afectado por el commit. Se escribe entre paréntesis y proporciona más contexto sobre el área afectada.
- **mensaje**: Descripción breve del cambio realizado. Debe ser claro y conciso.
- **cuerpo** (opcional): Explicación detallada sobre el commit. Puede incluir justificaciones de por qué se realizó el cambio y cómo afecta al proyecto.
- **pie de página** (opcional): Se utiliza para incluir información adicional, como referencias a issues, tareas o enlaces relevantes.

---

## **2. Tipos de Commits Permitidos**

### **2.1 Commit para Nuevas Funcionalidades**

Los commits que introducen nuevas funcionalidades deben utilizar el tipo feat:

    feat(interfaz-usuario): añadir página de inicio

### **2.2 Commit para Corrección de Errores**

Los commits que corrigen errores deben utilizar el tipo fix.

    fix(api): solucionar error al obtener precios de acciones

### **2.3 Commit para Refactorización de Código**

Los commits que realizan una refactorización del código deben usar el tipo refactor.

    refactor(backend): mejorar estructura de clases de servicios

### **2.4 Commit para Cambios en la Documentación**

Cualquier cambio relacionado con la documentación debe usar el tipo docs.

    docs: actualizar README con instrucciones de configuración  

### **2.5 Commit para Cambios en el Estilo del Código**

Si un commit afecta solo al estilo del código, como la corrección de sangrías o la eliminación de espacios innecesarios, se utilizará el tipo style.

    style(frontend): corregir formato de código en los componentes de UI    

### **2.6 Commit para documentar el código**

Para commits que mejoran la legibilidad y entendimiento del código sin modificar su lógica. Se coloca entre parentesis el nombre de la clase involucrada.

    comment(AlphaVantageAPI): añadir comentarios a los métodos utilizando el formato Javadoc.

### **2.7 Commit para Mejoras de Rendimiento**

Para commits que mejoran el rendimiento de la aplicación, se utilizará el tipo perf.

    perf(backend): optimizar consulta de precios de acciones    

### **2.8 Commit para Añadir o Modificar Pruebas**

Si el commit añade nuevas pruebas o modifica las existentes, debe usar el tipo test.

    test(api): añadir pruebas para la obtención de precios de acciones  

### **2.9 Commit para Tareas Generales**

Las tareas generales que no encajan en ninguna de las categorías anteriores (como actualizaciones de dependencias o cambios en los scripts de construcción) deben utilizar el tipo chore.

    chore: actualizar dependencias de Maven

---

## 3. Reglas mensaje de commit

- El mensaje del commit debe comenzar con una letra minúscula, excepto por los nombres de archivos o clases que estén en mayúsculas.
- El mensaje debe ser claro y explicar el cambio realizado de manera que otros miembros del equipo puedan comprenderlo rápidamente.
- El mensaje del commit debe ser breve, con un máximo de 100 caracteres en la línea principal.