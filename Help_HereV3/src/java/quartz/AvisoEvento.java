package quartz;

import DAO.DAONotificacao;
import Model.Evento;
import Model.Notificacao;
import Model.Pessoa;
import Util.email;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.mail.EmailException;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class AvisoEvento implements Job {

    @Override
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        //Lista evento 
        DAONotificacao daon = new DAONotificacao();
        ArrayList<Notificacao> ns = new ArrayList();
        ArrayList<Evento> evs = daon.ListarParaNotificar();

        for (Evento e1 : evs) {
            //Lista pessoa
            Notificacao n = new Notificacao();
            n.setE(e1);
            n.setUsersNotificados(daon.ListarContatos(n));
            for (Pessoa pe : n.getUsersNotificados()) {
                email mail = new email();
                try {
                    mail.sendEmail(pe.getEmail(), "Seu Evento Esta proximo", "Atenção " + pe.getNome() + "o Evento " + e1.getNome() + "esta chegando");
                } catch (EmailException ex) {
                    Logger.getLogger(AvisoEvento.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }

    }

}
