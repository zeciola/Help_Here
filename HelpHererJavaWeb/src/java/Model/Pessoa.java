package Model;

import Control.*;
import Model.*;
import DAO.*;
import Util.*;
import java.util.*;

public class Pessoa {
    
    private String nome;
    private Endereco endereco;
    private String email;
    private Date datanas;
    private String celular;
    private String telefone;
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
