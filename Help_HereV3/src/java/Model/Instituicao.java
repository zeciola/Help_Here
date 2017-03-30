package Model;

import Control.*;
import Model.*;
import DAO.*;
import Util.*;
import java.util.*;
public class Instituicao {
    private int idInstituicao;
    private String nome;
    private String razaoSocial;
    private String tipo;
    private String cnpj;
    private String modalidade;
    private String Email;
    

    public Instituicao() {
        
    }

    
    //Gets

    public int getIdInstituicao() {
        return idInstituicao;
    }
    

    public String getNome() {
        return nome;
    }

    public String getRazao() {
        return razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }


    public String getModalidade() {
        return modalidade;
    }


    public String getTipo() {
        return tipo;
    }

    public String getEmail() {
        return Email;
    }
    
    
    
    
    
    //Sets

    
    public void setIdInstituicao(int idInstituicao) {
        this.idInstituicao = idInstituicao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRazao(String razao) {
        this.razaoSocial = razao;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }


    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }


    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
        

    
}
