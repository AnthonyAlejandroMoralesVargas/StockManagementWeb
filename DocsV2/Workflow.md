# **Git Workflow - Aplicación Gestión de Acciones**

## **Objetivo**

El objetivo de este documento es especificar el flujo de trabajo para garantizar un desarrollo colaborativo eficiente utilizando Git y GitHub. Mediante una estructura clara de ramas, cada miembro del equipo podrá trabajar en su parte asignada del proyecto sin conflictos, asegurando la integración exitosa tanto de la interfaz gráfica como de la lógica de negocio.

---

## **1. Estructura de Ramas**

### **1.1 Ramas Principales**

- **main**: Esta es la rama principal del proyecto y debe contener siempre el código listo para producción. Solo debe integrar código que haya sido completamente probado y aprobado.

- **dev**: Esta es la rama de integración donde se combinan los trabajos en progreso. Los desarrolladores fusionarán sus cambios en esta rama después de haber probado y validado sus funcionalidades en las ramas locales. Aquí se integrarán tanto los cambios de la lógica de negocio como los de la interfaz gráfica.

- **release**: Esta rama se utiliza para preparar una nueva versión del proyecto para producción. Se crea a partir de dev cuando se está listo para hacer un lanzamiento y se utiliza para realizar pruebas finales y correcciones menores antes de fusionarse con main. Las ramas release permiten estabilizar el código y corregir errores detectados sin agregar nuevas funcionalidades.

- **docs**: Esta es la rama donde se encuentra toda la documentación relacionada al proyecto (estándares, manual de usuario, documentación API, historias de usuario, diagramas de diseño, etc.)

### **1.2 Ramas de Funcionalidades**

Estas ramas se crean a partir de la rama dev y se utilizan exclusivamente para el desarrollo de nuevas características.

- **Formato de nombre**: feature/nombre-de-la-funcionalidad

- **Ejemplos**:
  - feature/consultar-precios
  - feature/interfaz-usuario

### **1.3 Ramas de Corrección de Errores**

Estas ramas se crean a partir de dev o main, dependiendo de si el error se encuentra en desarrollo o en producción. Se utilizan para corregir errores o problemas detectados. Una vez solucionado el problema, se fusionan de nuevo en la rama correspondiente (dev o main).

- **Formato de nombre**: bugfix/nombre-del-error

- **Ejemplos**:
  - bugfix/error-api-precios
  - bugfix/corrigiendo-interfaz-login

### **1.4 Ramas de Hotfix**

Estas ramas se crean a partir de la rama main en situaciones de emergencia para corregir problemas críticos que afectan la producción. Una vez solucionado el error, la rama se fusiona directamente en main.

- **Formato de nombre**: hotfix/nombre-del-error

- **Ejemplo**:
  - hotfix/corrigiendo-error-precios

---

## 2. Roles en el Equipo

### 2.1 Desarrolladores Full Stack

#### Responsabilidades:

##### Capa de Presentación (Vista):
- Implementar las interfaces de usuario utilizando **JSP y CSS**.
- Usar **JSTL y Expression Language (EL)** en JSP para evitar scriptlets y mejorar la mantenibilidad.
- Integrar **Chart.js** para la visualización gráfica de datos financieros.
- Garantizar la correcta recepción y envío de datos entre la vista y los controladores.

##### Capa de Controladores (Controller):
- Implementar la lógica de control utilizando **servlets** para gestionar las solicitudes HTTP.
- Manejar la comunicación entre la vista y el servicio, asegurando la correcta redirección de datos.
- Gestionar errores y excepciones para mejorar la experiencia del usuario.

##### Capa de Modelo (Model):
- Diseñar y gestionar la persistencia de datos utilizando **JPA/Hibernate con DAO**.
- Implementar las operaciones de negocio en **StockService** y otros servicios relacionados.
- Integrar la API de **Alpha Vantage** para obtener precios actualizados de acciones.
- Optimizar el acceso a la base de datos **Derby**, asegurando un rendimiento eficiente.

#### Flujo de trabajo:
1. Crear ramas de funcionalidad (`feature/nombre-de-la-funcionalidad`) basadas en `dev`.
2. Implementar la funcionalidad completa, incluyendo **vista, controlador y modelo**.
3. Probar la funcionalidad en local antes de enviar un **Pull Request (PR)** a `dev`.
4. Solicitar revisión del código y realizar mejoras antes de fusionarlo con `dev`.
5. Coordinar con el equipo para evitar conflictos en la integración del sistema.

---

## **3. Proceso de Integración y Revisión de Código**

### **3.1 Creación de Pull Requests (PR)**

- Los desarrolladores deberán integrar sus cambios de ramas de funcionalidades o corrección de errores en la rama dev.
- Cuando se complete una tarea en una rama de funcionalidad, el desarrollador debe crear un Pull Request desde su rama hacia dev.
- El PR debe ser revisado por un miembro del equipo para garantizar que el código esté correctamente implementado, sin errores y alineado con los estándares de programación del proyecto.

### **3.2 Revisión y Aprobación de Pull Requests**

- Durante la revisión, se debe asegurar que los cambios propuestos no afecten negativamente al funcionamiento del proyecto.
- Un miembro del equipo revisará el código, proporcionando comentarios y sugerencias de mejora en caso de ser necesario.
- El Pull Request solo será fusionado a la rama dev después de recibir la aprobación del miembro responsable de la revisión.

---

## **4. Gestión de Versiones**

Cuando las funcionalidades y correcciones en la rama dev están completas y listas para ser probadas como parte de una nueva versión:

### **4.1 Creación de la Rama release**

- Crear una nueva rama release a partir de dev con el nombre release/x.x.x (las letras x representan el número de versión).
- Los errores o cambios encontrados durante esta etapa se deben corregir en la rama release.

### **4.2 Fusión de la Rama release**

- Se fusiona la rama release a main.
- Se fusiona la rama release de nuevo a dev para asegurar que los cambios realizados en la preparación de la versión estén disponibles para el futuro desarrollo.
