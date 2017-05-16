package Model;

import Control.*;
import Model.*;
import DAO.*;
import Util.*;
import java.util.*;

public class Evento {
    
    private int idEvento;
    private String dataInicio;
    private String dataFim;
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
