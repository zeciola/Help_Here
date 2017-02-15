package Model;

import Control.*;
import Model.*;
import DAO.*;
import Util.*;
import java.util.*;
public class Instituicao {

    private String nome;
    private String razao;
    private String cnpj;
    private ArrayList<Endereco> endereco = new ArrayList();
    private String modalidade;
    
    //Gets

    public String getNome() {
        return nome;
    }

    public String getRazao() {
        return razao;
    }

    public String getCnpj() {
        return cnpj;
    }

    public ArrayList<Endereco> getEndereco() {
        return endereco;
    }

    public String getModalidade() {
        return modalidade;
    }
    
    //Sets

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRazao(String razao) {
        this.razao = razao;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setEndereco(ArrayList<Endereco> endereco) {
        this.endereco = endereco;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }
    
}
