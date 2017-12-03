/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author Diego
 */
public class Contribuicao {
    private int id;
    private Evento ev;
    private Date datacad;
    private Usuario user;
    private Double valor;
    private String NumeroBoleto;

    
    
    //Sets
    public void setId(int id) {
        this.id = id;
    }
    public void setEv(Evento ev) {
        this.ev = ev;
    }
    public void setDatacad(Date datacad) {
        this.datacad = datacad;
    }
    public void setUser(Usuario user) {
        this.user = user;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    } 
    public void setNumeroBoleto(String NumeroBoleto) {
        this.NumeroBoleto = NumeroBoleto;
    }
    
    
    //Gets
    public int getId() {
        return id;
    }
    public Evento getEv() {
        return ev;
    }
    public Date getDatacad() {
        return datacad;
    }
    public Usuario getUser() {
        return user;
    }
    public Double getValor() {
        return valor;
    }
    public String getNumeroBoleto() {
        return NumeroBoleto;
    }

}
