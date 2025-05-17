# Compilador Aritmético en Java

Este proyecto implementa un compilador simple en Java que realiza análisis léxico, sintáctico y semántico de expresiones aritméticas. Soporta operadores básicos, paréntesis, números decimales y funciones matemáticas como `exp()`, `log()`, `sin()` y `cos()`.

---

##  ¿Qué hace este compilador?

El compilador toma una cadena de texto con una expresión matemática como:

```
exp(2.0) + 2.5 + (15 * 2) / 2
```

Y realiza las siguientes etapas:

1. **Análisis léxico**: Convierte la cadena en tokens (números, operadores, funciones, paréntesis).
2. **Análisis sintáctico**: Verifica la estructura correcta de la expresión según precedencia.
3. **Análisis semántico**: Evalúa la expresión y detecta errores como división por cero.
4. **Evaluación**: Calcula y muestra el resultado final (con soporte para decimales).

---

##  Estructura del proyecto

```
Proyecto/
├── src/
│   ├── Main.java              # Punto de entrada del programa
│   ├── lexers/
│   │   ├── Lexer.java         # Analizador léxico
│   │   └── Token.java         # Clase de token
│   └── parser/
│       └── Parser.java        # Analizador sintáctico y evaluador
├── out/                       # Carpeta de salida tras compilación
└── README.md                  # Este archivo
```

---

##  Requisitos

- Java JDK 8 o superior
- Consola de comandos o terminal
- (Opcional) Visual Studio Code con:
  - Java Extension Pack
  - Language Support for Java™ by Red Hat

---

##  Cómo compilar y ejecutar (desde Windows)

### 1. Clonar el repositorio

```bash
git clone https://github.com/Zhaitho/Proyecto.git
cd Proyecto
```

### 2. Compilar

```bash
javac -d out src\Main.java src\lexers\Lexer.java src\lexers\Token.java src\parser\Parser.java
```

### 3. Ejecutar

```bash
java -cp out Main
```

---

## Ejemplo de uso

Cuando ejecutas el programa, podrás ingresar expresiones desde la consola:

```bash
Ingresa una expresión: log(10) + 3 * 2
Resultado: 8.605170185988092

Ingresa una expresión: sin(0)
Resultado: 0.0

Ingresa una expresión: salir
Finalizando...
```

---

##  Características soportadas

- Números enteros y decimales
- Operadores: `+`, `-`, `*`, `/`
- Paréntesis: `( )`
- Funciones matemáticas:
  - `exp(n)` → exponencial `e^n`
  - `log(n)` → logaritmo natural `ln(n)`
  - `sin(n)` → seno (en radianes)
  - `cos(n)` → coseno (en radianes)
- Precedencia de operadores correcta
- Evaluación recursiva con manejo de errores


---

##  Descarga

Si no quieres usar Git, también puedes [descargar el proyecto como ZIP](https://github.com/Zhaitho/Proyecto/archive/refs/heads/main.zip) y extraerlo localmente.

---