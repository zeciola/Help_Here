package Model;

import java.util.Date;
import Control.*;
import Model.*;
import DAO.*;
import Util.*;
import java.util.*;

public class Item {
    private String nome;
    private String tipo;
    private double peso;
    private Date validade;
    private String marca;
    private String descricao;
    
    //Gets

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPeso() {
        return peso;
    }

    public Date getValidade() {
        return validade;
    }

    public String getMarca() {
        return marca;
    }

    public String getDescricao() {
        return descricao;
    }
    
    //Sets

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
