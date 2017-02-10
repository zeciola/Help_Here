package Model;

import Control.*;
import Model.*;
import DAO.*;
import Util.*;
import java.util.*;

public class Pessoa {
    
    private String nome;
    private String email;
    private Date datanas;
    private String celular;
    private String telefone;
    private String endereco;
    private String cidade;
    private String estado;
    private String cep;
    private String rg;
    private String cpf;
    private String sexo;
    
    //Gets

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public Date getDatanas() {
        return datanas;
    }

    public String getCelular() {
        return celular;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
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

    public String getRg() {
        return rg;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSexo() {
        return sexo;
    }
    
    //Sets

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDatanas(Date datanas) {
        this.datanas = datanas;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    
}
