package Model;

import Control.*;
import Model.*;
import DAO.*;
import Util.*;
import java.util.*;


public class Endereco {
    
    private int idEndereco;
    private String nomelogradouro;
    private int numeroen;
    private String municipio;
    private String estado;
    private String bairro;
    private String cep;
    private String pais;


    //Gets

    public int getIdEndereco() {
        return idEndereco;
    }

    public String getNomelogradouro() {
        return nomelogradouro;
    }

    public int getNumeroen() {
        return numeroen;
    }

    public String getMunicipio() {
        return municipio;
    }

    public String getEstado() {
        return estado;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCep() {
        return cep;
    }

    public String getPais() {
        return pais;
    }
    
    //Sets

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public void setNomelogradouro(String nomelogradouro) {
        this.nomelogradouro = nomelogradouro;
    }

    public void setNumeroen(int numeroen) {
        this.numeroen = numeroen;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
    
    
}
