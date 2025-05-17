package lexers;

public class Lexer {

    private String input;
    private int posicion = 0;

    public Lexer(String input) {
        this.input = input;
    }

    public Token nextToken() {
        if (posicion >= input.length()) {
            return new Token("EOF", "");
        }

        char currentChar = input.charAt(posicion);

        // Ignorar espacios
        if (Character.isWhitespace(currentChar)) {
            posicion++;
            return nextToken();
        }

        // Números (permite decimales)
        if (Character.isDigit(currentChar)) {
            StringBuilder numero = new StringBuilder();
            while (posicion < input.length() &&
                   (Character.isDigit(input.charAt(posicion)) || input.charAt(posicion) == '.')) {
                numero.append(input.charAt(posicion));
                posicion++;
            }
            return new Token("NUMBER", numero.toString());
        }

        // Identificadores (funciones: exp, log, sin, cos)
        if (Character.isLetter(currentChar)) {
            StringBuilder id = new StringBuilder();
            while (posicion < input.length() && Character.isLetter(input.charAt(posicion))) {
                id.append(input.charAt(posicion));
                posicion++;
            }
            String palabra = id.toString();
            switch (palabra) {
                case "exp":
                    return new Token("EXP", palabra);
                case "log":
                    return new Token("LOG", palabra);
                case "sin":
                    return new Token("SIN", palabra);
                case "cos":
                    return new Token("COS", palabra);
                default:
                    throw new RuntimeException("Identificador desconocido: " + palabra);
            }
        }

        // Operadores y paréntesis
        switch (currentChar) {
            case '+': posicion++; return new Token("PLUS", "+");
            case '-': posicion++; return new Token("MINUS", "-");
            case '*': posicion++; return new Token("MULT", "*");
            case '/': posicion++; return new Token("DIV", "/");
            case '(': posicion++; return new Token("LPAREN", "(");
            case ')': posicion++; return new Token("RPAREN", ")");
            default:
                throw new RuntimeException("Carácter no esperado: " + currentChar);
        }
    }
}
