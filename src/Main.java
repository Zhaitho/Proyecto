import java.util.Scanner;
import lexers.Lexer;
import parser.Parser;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Compilador de expresiones matemáticas");
        System.out.println("Funciones soportadas: +, -, *, /, paréntesis, exp(), log(), sin(), cos()");
        System.out.println("Escribe 'salir' para terminar.");

        while (true) {
            System.out.print("\nIngresa una expresión: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("salir")) {
                System.out.println("Finalizando...");
                break;
            }

            try {
                Lexer lexer = new Lexer(input);
                Parser parser = new Parser(lexer);
                double resultado = parser.parse();
                System.out.println("Resultado: " + resultado);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
