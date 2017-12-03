package Model;

import Control.*;
import Model.*;
import DAO.*;
import Util.*;
import java.util.*;
import java.sql.Date;

public class Evento {
    
    private int idEvento;
    Endereco end;
    ArrayList<Endereco> ends;
    private Date dataInicio;
    private Date dataFim;
    private String nome;
    private String tipoEvento;
    private String descricao;
    private boolean status;
    private String img;
    private ArrayList<String> galeria;
    private double metaValor;
    private int metaVoluntario;
    private double valorAlcancado; 

 
        
    //Sets
    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }
    public void setEnd(Endereco end) {
        this.end = end;
    }
    public void setEnds(ArrayList<Endereco> ends) {
        this.ends = ends;
    }
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }
    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public void setImg(String img) {
        this.img = img;
    }
    public void setGaleria(ArrayList<String> galeria) {
        this.galeria = galeria;
    }
    public void setMetaValor(double metaValor) {
        this.metaValor = metaValor;
    }
    public void setMetaVoluntario(int metaVoluntario) {
        this.metaVoluntario = metaVoluntario;
    }
    public void setValorAlcancado(double valorAlcancado) {
        this.valorAlcancado = valorAlcancado;
    }
    
    
    //Gets
    public int getIdEvento() {
        return idEvento;
    }
    public Endereco getEnd() {
        return end;
    }
    public ArrayList<Endereco> getEnds() {
        return ends;
    }
    public Date getDataInicio() {
        return dataInicio;
    }
    public Date getDataFim() {
        return dataFim;
    }
    public String getNome() {
        return nome;
    }
    public String getTipoEvento() {
        return tipoEvento;
    }
    public String getDescricao() {
        return descricao;
    }
    public boolean getStatus() {
        return status;
    }
    public String getImg() {
        return img;
    }
    public ArrayList<String> getGaleria() {
        return galeria;
    }
    public double getMetaValor() {
        return metaValor;
    }
    public int getMetaVoluntario() {
        return metaVoluntario;
    }
    public double getValorAlcancado() {
        return valorAlcancado;
    }
 
}
