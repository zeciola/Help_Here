package MODELO;

public class Baixa {
    private String numeroBoleto;
    private double valor1;
    private double valor2;
    private String senha;
    private String usuario;
    private String codtoken;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String login) {
        this.usuario = login;
    }

    public String getCodtoken() {
        return codtoken;
    }

    public void setCodtoken(String codtoken) {
        this.codtoken = codtoken;
    }
    
    
    
    public String getNumeroBoleto() {
        return numeroBoleto;
    }

    public void setNumeroBoleto(String numeroBoleto) {
        this.numeroBoleto = numeroBoleto;
    }

    public double getValor1() {
        return valor1;
    }

    public void setValor1(double valor1) {
        this.valor1 = valor1;
    }

    public double getValor2() {
        return valor2;
    }

    public void setValor2(double valor2) {
        this.valor2 = valor2;
    }
}
