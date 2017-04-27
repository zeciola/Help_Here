package Model;

import Control.*;
import Model.*;
import DAO.*;
import Util.*;
import java.util.*;

public class Evento {

    private Date dataInicio;
    private Date dataFim;
    private String nome;
    private String descricao;
    private String tipoEvento;
    private Pessoa responsavel;
    private Instituicao instResponsavel;
    private Endereco endereco;

    
    
    
    public Pessoa getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Pessoa responsavel) {
        this.responsavel = responsavel;
    }

    public Instituicao getInstResponsavel() {
        return instResponsavel;
    }

    public void setInstResponsavel(Instituicao instResponsavel) {
        this.instResponsavel = instResponsavel;
    }

    //Gets
    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }


    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }


    public Endereco getEndereco() {
        return endereco;
    }

    //Sets
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}
