package Model;

import Control.*;
import Model.*;
import DAO.*;
import Util.*;
import java.util.*;

public class Evento {

    private String dataInicio;
    private String dataFim;
    private String nome;
    private String tipoEvento;
    private String descricao;
    private ArrayList<Pessoa> responsavel = new ArrayList();
    private ArrayList<Instituicao> instResponsavel = new ArrayList();
    private ArrayList<Endereco> endereco = new ArrayList();

    
    
    
    
    
    
    
    public ArrayList<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(ArrayList<Endereco> endereco) {
        this.endereco = endereco;
    }
    
    public ArrayList<Pessoa> getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(ArrayList<Pessoa> responsavel) {
        this.responsavel = responsavel;
    }

    public ArrayList<Instituicao> getInstResponsavel() {
        return instResponsavel;
    }

    public void setInstResponsavel(ArrayList<Instituicao> instResponsavel) {
        this.instResponsavel = instResponsavel;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    
    

    //Gets
    public String getDataInicio() {
        return dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }


    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }




    //Sets
    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }




}
