#  Compilador Aritmético en Java

Este proyecto implementa un **compilador simple en Java** que realiza el análisis léxico, sintáctico y semántico de **expresiones aritméticas con soporte para enteros, paréntesis, operadores básicos y funciones matemáticas como `exp()`**.

##  ¿Qué hace este compilador?

El compilador toma una cadena que representa una expresión matemática, como:

exp(2) + 2 + (15 * 2) / 2


Y realiza las siguientes etapas del proceso de compilación:

1. Análisis léxico: Divide la cadena en *tokens* como números, operadores y paréntesis.
2. Análisis sintáctico: Verifica la estructura correcta de la expresión, según reglas de precedencia y jerarquía.
3. Análisis semántico: Evalúa la expresión de forma correcta, verificando errores como división por cero.
4. Evaluación del resultado: Devuelve el resultado final de la expresión (puede incluir decimales si `exp()` lo produce).

##  Estructura del proyecto

compilador/
├── src/
│ ├── Main.java # Punto de entrada del programa
│ ├── lexers/
│ │ ├── Lexer.java # Analizador léxico
│ │ └── Token.java # Definición de tokens
│ └── parser/
│ └── Parser.java # Analizador sintáctico y evaluador
├── out/ # Carpeta de salida generada al compilar
└── README.md # Instrucciones del proyecto


## Requisitos

- Java JDK 8 o superior
- Consola de comandos o terminal
- (Opcional) Visual Studio Code con estas extensiones:
  - Java Extension Pack
  - Language Support for Java(TM) by Red Hat

##  Cómo compilar y ejecutar

### 1. Compilar

Desde la raíz del proyecto(dentro del compilador):

```bash
javac -d out src\Main.java src\lexers\Lexer.java src\lexers\Token.java src\parser\Parser.java


### 2. Ejecutar

java -cp out Main

Si estás usando la expresión de prueba:

String input = "exp(2) + 2 + (15 * 2) / 2";

El resultado será similar a:

Resultado: 24.38905609893065

#Carcacteristicas soportadas

Números enteros (2, 15, etc.)

Operadores: +, -, *, /

Paréntesis: ( )

Función matemática: exp(n) → calcula e^n (Math.exp)

Precedencia correcta de operadores

Evaluación recursiva de expresiones

## Consideraciones

El compilador trabaja internamente con valores tipo double para permitir resultados decimales.

Si deseas que solo devuelva enteros, puedes truncar ((int)) en el Parser.

Puedes agregar más funciones (como sqrt, log, etc.) ampliando el Lexer y Parser.




