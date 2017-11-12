package quartz;

import DAO.DAONotificacao;
import Model.Evento;
import Model.Notificacao;
import java.util.ArrayList;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class AvisoEvento implements Job{
    Notificacao n = new Notificacao();
    DAONotificacao daon = new DAONotificacao();
    ArrayList<Notificacao> ns = new ArrayList();
   
    @Override
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        ArrayList<Evento> evs = daon.ListarParaNotificar();
        
        for(Evento e1 : evs){
            n.setE(e1);
            n.setUsersNotificados(daon.ListarContatos(n));
        }
        
    }

    
}
