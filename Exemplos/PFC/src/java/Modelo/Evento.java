/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.sql.Date;
import java.util.ArrayList;
/**
 *
 * @author Diego
 */
public class Evento {
    private int id;
    private Date inicio;
    private Date dataFim;
    private Date dataCad;
    private String nome;
    private String descricao;
    private ArrayList<Endereco> endereco = new ArrayList();
    private ArrayList<Pessoa> responsavel = new ArrayList();

    public ArrayList<Endereco> getEndereco() {
        return endereco;
    }

    public ArrayList<Pessoa> getResponsavel() {
        return responsavel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Date getDataCad() {
        return dataCad;
    }

    public void setDataCad(Date dataCad) {
        this.dataCad = dataCad;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public void AddEndereco(Endereco e){
        endereco.add(e);
    }
    
    public void AddResponsavel(Pessoa p){
        responsavel.add(p);
    }
}
