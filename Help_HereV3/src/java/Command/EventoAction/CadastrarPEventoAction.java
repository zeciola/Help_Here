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

public class CadastrarPEventoAction implements ICommand{

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
    ArrayList<Pessoa> pe = new ArrayList();
    ArrayList<Endereco> end = new ArrayList();
    Evento ev = new Evento();
    DAOEvento daoevento = new DAOEvento();
    DAOFeeds daof = new DAOFeeds();
    
    
    String[] cepend = request.getParameterValues("cep");
    String[] nomeend = request.getParameterValues("nomeendereco");
    String[] numeroend = request.getParameterValues("numeroendereco");
    String[] bairro = request.getParameterValues("bairro");
    String[] cidade = request.getParameterValues("cidade");
    String[] estado = request.getParameterValues("estado");
    String[] pais = request.getParameterValues("pais");
  
    //instiruicao
    String[] idPessoa = request.getParameterValues("idpessoa");
    String[] nomepessoa = request.getParameterValues("pessoa");
    String[] sobrenome = request.getParameterValues("sobren");
    String[] emailpessoa = request.getParameterValues("email");
    String[] CPF = request.getParameterValues("cpf");
    
    
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
    
    for (int i=0; i < idPessoa.length; i++){
                Pessoa pes = new Pessoa();
                
                pes.setId(Integer.parseInt(idPessoa[i]));
                pes.setNome(nomepessoa[i]);
                pes.setSobrenome(sobrenome[i]);
                pes.setEmail(emailpessoa[i]);
                pes.setCpf(CPF[i]);
                
                pe.add(pes);    
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
        
        
        for(int j = 0; j < pe.size(); j++){
            int idPes =pe.get(j).getId();
            
            DAOEvento Ed = new DAOEvento();
            Ed.InserirAuxPessoaEvento(idPes, ev.getIdEvento());
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
        
        //Feeds
       ArrayList<Pessoa> ps = daof.Interessados(f);
      /*  
        for(int i=0; i< ps.size(); i++){
            Usuario u = new Usuario();
            u.setPe(ps.get(i));
            f.setU(u);
            daof.adicionarFeed(f);
        }
    */
        //Redirecionar para pagina de perfil de usuário com o listar dos valores colocados acima
        return "/acessologado/EventoPessoa.jsp";
    }
}
