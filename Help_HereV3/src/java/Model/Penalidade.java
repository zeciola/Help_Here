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
    private Pessoa p = new Pessoa();
    private Date dataPenalidade;

    public Pessoa getP() {
        return p;
    }

    public void setP(Pessoa p) {
        this.p = p;
    }

    public Date getDataPenalidade() {
        return dataPenalidade;
    }

    public void setDataPenalidade(Date dataPenalidade) {
        this.dataPenalidade = dataPenalidade;
    }
    
    
}
