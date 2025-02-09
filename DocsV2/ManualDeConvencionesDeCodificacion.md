# MANUAL DE CONVENCIONES DE CODIFICACIÓN

## Nombres de Clases

- **Paquetes:** 
  - Los nombres deben estar en minúsculas. 
  - El nombre raíz del paquete debe ser el nombre del grupo/proyecto, seguido de nombres lógicos.
    ```java
    com.company.application.ui;
    ```

- **Clases/Enumeraciones:** 
  - Los nombres deben ser sustantivos y escritos en `PascalCase`.
    ```java
    class Line { }
    enum AudioSystem { }
    ```

- **Variables:** 
  - Los nombres deben estar en `camelCase`.
    ```java
    int line;
    String audioSystem;
    ```

- **Constantes:** 
  - Los nombres deben escribirse en `SCREAMING_SNAKE_CASE`.
    ```java
    static final int MAX_ITERATIONS = 100;
    static final int COLOR_RED = 1;
    ```

- **Métodos:** 
  - Los nombres deben ser verbos, en `camelCase`.
    ```java
    public void getName() { }
    public void computeTotalWidth() { }
    ```

- **Métodos de prueba:** 
  - Deben seguir el formato `featureUnderTest_testScenario_expectedBehavior()`.
    ```java
    public void sortList_emptyList_exceptionThrown() { }
    public void getMember_memberNotFound_nullReturned() { }
    ```

- **Variables booleanas:** 
  - Nombres que suenen booleanos, usando prefijos como `is`, `has`, `can`, `should`.
    ```java
    boolean isSet = true;
    boolean isVisible = false;
    boolean hasData = true;

    boolean hasLicense() { return true; }
    boolean canEvaluate() { return false; }
    ```

## Formato de Código

- **Indentación:** 
  - Debe ser de 4 espacios.
    ```java
    public void someMethod() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
    ```

- **Longitud de línea:** 
  - No exceder los 120 caracteres. Dividir líneas largas.
    ```java
    String longString = "This is a very long string that will exceed the 120 character limit, so it should be wrapped.";

    longString = "This is a very long string "
                 + "that will exceed the 120 character limit.";
    ```

- **Llaves de bloques:** 
  - Usar el estilo K&R (estilo egipcio).
    ```java
    while (!done) {
        doSomething();
        done = moreToDo();
    }
    ```

- **Espacios:**
  - Alrededor de operadores y después de palabras reservadas.
    ```java
    int sum = (a + b) * c;
    while (true) {
        // Do something
    }
    ```

- **Separación de bloques lógicos:**
    ```java
    // Create a new matrix
    Matrix4x4 matrix = new Matrix4x4();

    // Precompute angles
    double cosAngle = Math.cos(angle);
    double sinAngle = Math.sin(angle);

    // Apply rotation
    transformation.multiply(matrix);
    ```

## Declaración de Variables

- **Inicialización:** 
  - Deben inicializarse donde se declaran.
    ```java
    int sum = 0;
    for (int i = 0; i < 10; i++) {
        sum += i;
    }
    ```

- **Variables de Clase:** 
  - Deben ser privadas.
    ```java
    public class Foo {
        private int bar;
    }
    ```

## Estructuras de Control

- **Condicionales:** 
  - Siempre rodeados por llaves.
    ```java
    if (isDone) {
        doCleanup();
    } else {
        doSomethingElse();
    }
    ```

- **Bucles:** 
  - Siempre rodeados de llaves.
    ```java
    for (int i = 0; i < 100; i++) {
        sum += value[i];
    }
    ```

- **Switch:** 
  - Formato específico sin indentación en los casos.
    ```java
    switch (condition) {
        case ABC:
            statements;
        case DEF:
            statements;
            break;
        default:
            statements;
    }
    ```

- **Excepciones:** 
  - Usar `finally` si es necesario.
    ```java
    try {
        // Try something
    } catch (IOException e) {
        // Handle exception
    } finally {
        // Cleanup
    }
    ```

## Código

- **Comentarios generales:** 
  - En inglés, evitando jerga local.

- **Comentarios de cabecera:**
    ```java
    /**
     * Computes the location.
     * @param x X coordinate.
     * @param y Y coordinate.
     * @throws IllegalArgumentException If zone <= 0.
     */
    public double computeLocation(double x, double y, int zone) {
        // Implementation
    }
    ```

- **Comentarios de una sola línea:** 
  - Concisos y al inicio de la línea.
    ```java
    // Sum two numbers
    int sum = a + b;
    ```

## Importación de Clases

- **Importaciones explícitas:** 
  - No usar comodines.
    ```java
    import java.util.List;
    import java.util.ArrayList;
    ```

- **Orden de importaciones:** 
  - Consistente: estáticas, estándar y de terceros.

## Buenas Prácticas

- **Evitar variables públicas:** 
  - Excepto en clases simples de datos.
    ```java
    public class Foo {
        private int bar;
    }
    ```

- **Uso adecuado de arrays:** 
  - Declarar especificando el tipo.
    ```java
    int[] a = new int[20];
    ```
