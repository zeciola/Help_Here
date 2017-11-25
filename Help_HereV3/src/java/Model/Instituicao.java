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
    private Endereco endereco;
    private String senha;
    private int contadorEv;

    
    
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
   public void setTipo(String tipo) {
        this.tipo = tipo;
    }
   public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }
    public void setEmail(String Email) {
        this.Email = Email;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
   public void setSenha(String senha) {
        this.senha = senha;
    }
   public void setContadorEv(int contadorEv) {
        this.contadorEv = contadorEv;
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
    public String getTipo() {
        return tipo;
    }
    public String getCnpj() {
        return cnpj;
    }
    public String getModalidade() {
        return modalidade;
    }
    public String getEmail() {
        return Email;
    }
    public Endereco getEndereco() {
        return endereco;
    }
    public String getSenha() {
        return senha;
    }
    public int getContadorEv() {
        return contadorEv;
    }
 
}
