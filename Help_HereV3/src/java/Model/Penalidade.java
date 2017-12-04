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
public class Penalidade {
    private Pessoa p ;
    private Date dataPenalidade;

    
    //Sets
    public void setP(Pessoa p) {
        this.p = p;
    }
    public void setDataPenalidade(Date dataPenalidade) {
        this.dataPenalidade = dataPenalidade;
    }
    
    //Gets
    public Pessoa getP() {
        return p;
    }
    public Date getDataPenalidade() {
        return dataPenalidade;
    }

}
