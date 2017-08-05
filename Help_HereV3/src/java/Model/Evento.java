package Model;

import Control.*;
import Model.*;
import DAO.*;
import Util.*;
import java.util.*;
import java.sql.Date;

public class Evento {
    
    private int idEvento;
    private Date dataInicio;
    private Date dataFim;
    private String nome;
    private String tipoEvento;
    private String descricao;
    private boolean status;
   

    
    
    
    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    
    
    
    
    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    
  
    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
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




}
