package Model;

import java.util.ArrayList;
import java.util.Date;

public class Evento {
    private Date dataInicio;
    private Date dataFim;
    private Date dataCad;
    private String nome;
    private String descricao;
    private ArrayList<Pessoa> responsavel = new ArrayList();
    private Endereco endereco;

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
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

    public ArrayList<Pessoa> getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(ArrayList<Pessoa> responsavel) {
        this.responsavel = responsavel;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    public void AddResp(Pessoa pessoa){
        responsavel.add(pessoa);
    }
}
