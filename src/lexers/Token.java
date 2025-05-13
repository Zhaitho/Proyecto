package lexers;


public class Token {

    private String tipoToken;
    private String valor;

    public Token (String tipoToken, String valor) {

        this.tipoToken = tipoToken;
        this.valor = valor;

    }

    public String getTipoToken () {
        

        return tipoToken;
    }

    public String getValor () {

        return valor;
    }

}
