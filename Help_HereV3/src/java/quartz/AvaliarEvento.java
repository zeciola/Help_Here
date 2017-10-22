package quartz;

import DAO.DAOEvento;
import Model.Evento;
import java.sql.Date;
import java.util.ArrayList;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class AvaliarEvento implements Job {
    DAOEvento edao = new DAOEvento();
    ArrayList<Evento> evlist = edao.Listar();
    Date datahoje = new Date(System.currentTimeMillis());
    
    @Override
    public void execute(JobExecutionContext jec) throws JobExecutionException {    
            for (Evento e : evlist) {
            if (e.getDataFim().before(datahoje)) {
                edao.Desativar(e);
                edao.AtualizarContador(e);
                edao.AtualizarContadorP(e);
                System.out.println("Atualizado um registro.");
            }
        }
    }
}
