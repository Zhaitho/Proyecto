

import lexers.Lexer;
import parser.Parser;

public class Main {
    public static void main(String[] args) {
        String input = "  log(1) + exp(2.0) + 2.5 + (15*2)/2";  // Expresión con decimales

        Lexer lexer = new Lexer(input);
        Parser parser = new Parser(lexer);

        double result = parser.parse();  // El resultado será un decimal

        System.out.println("Resultado: " + result);  // Muestra el resultado decimal
    }
}


