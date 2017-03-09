package Model;

import Control.*;
import Model.*;
import DAO.*;
import Util.*;
import java.util.*;


public class Endereco {
    
    private int id;
    private String endereco;
    private String numeroen;
    private String cidade;
    private String estado;
    private String bairro;
    private String cep;
    private String municipio;
    //Gets

    public String getBairro() {
        return bairro;
    }


    public int getId(){
        return id;
    }
    
    public String getEndereco() {
        return endereco;
    }

    public String getNumeroen() {
        return numeroen;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getCep() {
        return cep;
    }

    public String getMunicipio() {
        return municipio;
    }

    
    
    
    
    //Sets

    public void setId(int id){
        this.id = id;
    }
    
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setNumeroen(String numeroen) {
        this.numeroen = numeroen;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
    
}
