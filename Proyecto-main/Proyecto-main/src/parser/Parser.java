package parser;

import lexers.Lexer;
import lexers.Token;

public class Parser {

    private Lexer lexer;
    private Token currentToken;

    public Parser(Lexer lexer) {
        this.lexer = lexer;
        this.currentToken = lexer.nextToken(); // Obtenemos el primer token
    }

    public double parse() {
        return expression();
    }

    private double expression() {
        double result = term();

        while (currentToken.getTipoToken().equals("PLUS") || currentToken.getTipoToken().equals("MINUS")) {
            if (currentToken.getTipoToken().equals("PLUS")) {
                consume("PLUS");
                result += term();
            } else if (currentToken.getTipoToken().equals("MINUS")) {
                consume("MINUS");
                result -= term();
            }
        }

        return result;
    }

    private double term() {
        double result = factor();

        while (currentToken.getTipoToken().equals("MULT") || currentToken.getTipoToken().equals("DIV")) {
            if (currentToken.getTipoToken().equals("MULT")) {
                consume("MULT");
                result *= factor();
            } else if (currentToken.getTipoToken().equals("DIV")) {
                consume("DIV");
                double divisor = factor();
                if (divisor == 0) {
                    throw new ArithmeticException("División por cero");
                }
                result /= divisor;
            }
        }

        return result;
    }

    private double factor() {
        double result = 0;

        if (currentToken.getTipoToken().equals("NUMBER")) {
            result = Double.parseDouble(currentToken.getValor());
            consume("NUMBER");
        } else if (currentToken.getTipoToken().equals("LPAREN")) {
            consume("LPAREN");
            result = expression();
            consume("RPAREN");
        } else if (currentToken.getTipoToken().equals("EXP")) {
            consume("EXP");
            consume("LPAREN");
            double argumento = expression();
            consume("RPAREN");
            result = Math.exp(argumento);
        } else if (currentToken.getTipoToken().equals("LOG")) {
            consume("LOG");
            consume("LPAREN");
            double argumento = expression();
            consume("RPAREN");
            if (argumento <= 0) {
                throw new ArithmeticException("Logaritmo de número no positivo");
            }
            result = Math.log(argumento);
        } else {
            throw new RuntimeException("Token inesperado: " + currentToken.getTipoToken());
        }

        return result;
    }

    private void consume(String tipoToken) {
        if (currentToken.getTipoToken().equals(tipoToken)) {
            currentToken = lexer.nextToken();
        } else {
            throw new RuntimeException("Se esperaba " + tipoToken + ", pero se encontró " + currentToken.getTipoToken());
        }
    }
}
