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

    
    
    public String getNumeroBoleto() {
        return NumeroBoleto;
    }

    public void setNumeroBoleto(String NumeroBoleto) {
        this.NumeroBoleto = NumeroBoleto;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatacad() {
        return datacad;
    }

    public void setDatacad(Date datacad) {
        this.datacad = datacad;
    }

    public Evento getEv() {
        return ev;
    }

    public void setEv(Evento ev) {
        this.ev = ev;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    } 
}
