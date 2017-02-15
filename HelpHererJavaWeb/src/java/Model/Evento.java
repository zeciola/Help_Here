package Model;

import Control.*;
import Model.*;
import DAO.*;
import Util.*;
import java.util.*;

public class Evento {

    private Date dataInicio;
    private Date dataFim;
    private Date dataCad;
    private String nome;
    private String descricao;
    private ArrayList<Pessoa> responsavel = new ArrayList();
    private Endereco endereco;

    //Gets
    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public Date getDataCad() {
        return dataCad;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public ArrayList<Pessoa> getResponsavel() {
        return responsavel;
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

    public void setDataCad(Date dataCad) {
        this.dataCad = dataCad;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setResponsavel(ArrayList<Pessoa> responsavel) {
        this.responsavel = responsavel;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}
