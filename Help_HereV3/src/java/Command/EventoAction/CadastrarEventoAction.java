package Command.EventoAction;

import Command.ICommand;
import DAO.DAOEndereco;
import DAO.DAOEvento;
import DAO.DAOFeeds;
import Model.Endereco;
import Model.Evento;
import Model.Feeds;
import Model.Instituicao;
import Model.Pessoa;
import Model.Usuario;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CadastrarEventoAction implements ICommand{

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
    ArrayList<Instituicao> inst = new ArrayList();
    ArrayList<Pessoa> pe = new ArrayList();
    ArrayList<Endereco> end = new ArrayList();
    Evento ev = new Evento();
    DAOEvento daoevento = new DAOEvento();
    DAOFeeds daof = new DAOFeeds();
    
    // endereco do evento
    String[] cepend = request.getParameterValues("cep");
    String[] nomeend = request.getParameterValues("nomeendereco");
    String[] numeroend = request.getParameterValues("numeroendereco");
    String[] bairro = request.getParameterValues("bairro");
    String[] cidade = request.getParameterValues("cidade");
    String[] estado = request.getParameterValues("estado");
    String[] pais = request.getParameterValues("pais");
  
    //instiruicao
    String[] idinst = request.getParameterValues("idInst");
    String[] nomeinst = request.getParameterValues("inst");
    String[] razaosocial = request.getParameterValues("razao");
    String[] tipoinst = request.getParameterValues("tipo");
    String[] cnpjinst = request.getParameterValues("cnpj");
    String[] modalidadeinst = request.getParameterValues("modalidade");
    String[] emailinst = request.getParameterValues("email");
    
          
        for (int i=0; i < cepend.length; i++){
                Endereco e = new Endereco();
                
                    e.setCep(cepend[i]);
                    e.setNomelogradouro(nomeend[i]);
                    e.setNumeroen(Integer.parseInt(numeroend[i]));
                    e.setBairro(bairro[i]);
                    e.setMunicipio(cidade[i]);
                    e.setEstado(estado[i]);
                    e.setPais(pais[i]);
                    DAOEndereco daoe = new DAOEndereco();
                    daoe.setEndereco(e);
                    daoe.Inserir();
     
                 end.add(e);
                 
             }
       
        for (int i=0; i < idinst.length; i++){
                Instituicao in = new Instituicao();
                
                in.setIdInstituicao(Integer.parseInt(idinst[i]));
                in.setNome(nomeinst[i]);
                in.setRazao(razaosocial[i]);
                in.setTipo(tipoinst[i]);
                in.setCnpj(cnpjinst[i]);
                in.setModalidade(modalidadeinst[i]);
                in.setEmail(emailinst[i]);
                
                inst.add(in);    
        }
        
        Date datahoje = new Date(System.currentTimeMillis());
                
                String data1 = request.getParameter("inicio");
                     DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
                     java.sql.Date data = new java.sql.Date(fmt.parse(data1).getTime());
                    
                    
                ev.setDataInicio(data);
                String data2 = request.getParameter("fim");
                    
                     DateFormat fmt2 = new SimpleDateFormat("dd/MM/yyyy");
                     java.sql.Date dataf = new java.sql.Date(fmt2.parse(data2).getTime());
                ev.setDataFim(dataf);
                
    
        ev.setNome(request.getParameter("nome"));
        ev.setTipoEvento(request.getParameter("tipoEven"));
        ev.setDescricao(request.getParameter("descricao"));
                
        daoevento.setEvento(ev);
        daoevento.Inserir();
    
        for(int j = 0; j < inst.size(); j++){
            int idInst =inst.get(j).getIdInstituicao();
            
            DAOEvento Ed = new DAOEvento();
            Ed.InserirAuxInstituicaoEvento(idInst, ev.getIdEvento());
        }
        
        for(int j = 0; j < end.size(); j++){
            int idEnd =end.get(j).getIdEndereco();
            
            DAOEvento Ed = new DAOEvento();
            Ed.InserirAuxEnderecoEvento(idEnd, ev.getIdEvento());
        }
        String tipo = request.getParameter("tipoEven");
        int idev = ev.getIdEvento();
        
        Evento evento = new Evento();
        evento.setIdEvento(idev);
        evento.setTipoEvento(tipo);
        
        Feeds f = new Feeds();
        f.setE(evento);
       
        //feeds
        ArrayList<Usuario> ids = daof.Interessados(f);
        
        for(int i=0; i< ids.size(); i++){
            f.setU(ids.get(i));
            daof.adicionarFeed(f);
        }        
        
      
   
     
     
     return "/acessologado/Evento.jsp";
    }
}
