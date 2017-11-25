/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quartz;

import DAO.DAOPenalisado;
import Model.Penalidade;
import Model.Pessoa;
import java.util.ArrayList;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @author Diego
 */
public class RemovePenalidade implements Job{

    @Override
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        DAOPenalisado daopn = new DAOPenalisado();
        
        //Lista pessoa a sair da penalidade
        ArrayList<Pessoa> listp = daopn.ListaPessoasParaLiberar();
        
        for(Pessoa pe: listp){
            Penalidade pn = new Penalidade();
            pn.setP(pe);
            
            daopn.RemoverPena(pn);
        }
    }
}
