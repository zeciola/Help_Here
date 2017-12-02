package Command.EventoAction;

import Command.ICommand;
import DAO.DAOEndereco;
import DAO.DAOEvento;
import DAO.DAOFeeds;
import DAO.DAOPessoa;
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

public class CadastrarPEventoAction implements ICommand {

    private ArrayList<Pessoa> pe = new ArrayList();
    private ArrayList<Endereco> end = new ArrayList();

    private Evento ev = new Evento();
    private Endereco e = new Endereco();
    private Pessoa p =new Pessoa();
    
    private DAOEvento daoevento = new DAOEvento();
    private DAOFeeds daof = new DAOFeeds();
    private DAOEndereco daoe = new DAOEndereco();
    private DAOPessoa daop = new DAOPessoa();

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String[] cepend = request.getParameterValues("cep");
        String[] nomeend = request.getParameterValues("nomeendereco");
        String[] numeroend = request.getParameterValues("numeroendereco");
        String[] bairro = request.getParameterValues("bairro");
        String[] cidade = request.getParameterValues("cidade");
        String[] estado = request.getParameterValues("estado");
        String[] pais = request.getParameterValues("pais");

        
        String[] idPessoa = request.getParameterValues("idpessoa");
        String[] nomepessoa = request.getParameterValues("pessoa");
        String[] sobrenome = request.getParameterValues("sobren");
        String[] emailpessoa = request.getParameterValues("email");
        String[] CPF = request.getParameterValues("cpf");
        String[] contadorP = request.getParameterValues("contadorEv"); 


        for (int i = 0; i < cepend.length; i++) {
            Endereco e = new Endereco();
            e.setCep(cepend[i]);
            e.setNomelogradouro(nomeend[i]);
            e.setNumeroen(Integer.parseInt(numeroend[i]));
            e.setBairro(bairro[i]);
            e.setMunicipio(cidade[i]);
            e.setEstado(estado[i]);
            e.setPais(pais[i]);
            daoe.Inserir(e);

            end.add(e);

        }

        for (int i = 0; i < idPessoa.length; i++) {
            Pessoa pes = new Pessoa();

            pes.setId(Integer.parseInt(idPessoa[i]));
            pes.setNome(nomepessoa[i]);
            pes.setSobrenome(sobrenome[i]);
            pes.setEmail(emailpessoa[i]);
            pes.setCpf(CPF[i]);
            pes.setContador(Integer.parseInt(contadorP[i])); 
            pes.setContador(pes.getContador()+1); 
            daop.AtualizarContadorP(pes);

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
        ev.setMetaValor(Double.parseDouble(request.getParameter("valordoar")));

        
        daoevento.InserirDoacao(ev); 

        for (int j = 0; j < pe.size(); j++) {
            int idPes = pe.get(j).getId();
            p.setId(idPes);
            DAOEvento Ed = new DAOEvento();
            Ed.InserirAuxPessoaEvento(p, ev);  
        }
        
        for (int j = 0; j < end.size(); j++) {
            int idEnd = end.get(j).getIdEndereco();
            e.setIdEndereco(idEnd);
            DAOEvento Ed = new DAOEvento();
            Ed.InserirAuxEnderecoEvento(e, ev);
        }
        /*
        for(int j = 0; j < end.size(); j++){
            int idEnd =end.get(j).getIdEndereco();
            
            DAOEvento Ed = new DAOEvento();
            Ed.InserirAuxEnderecoEvento(idEnd, ev.getIdEvento()); 
        }
        */
        
        String tipo = request.getParameter("tipoEven");
        int idev = ev.getIdEvento();
        Evento evento = new Evento();
        evento.setIdEvento(idev);
        evento.setTipoEvento(tipo);

        Feeds f = new Feeds();
        f.setE(evento);

        //Feeds
        ArrayList<Usuario> ps = daof.Interessados(f);

        for (int i = 0; i < ps.size(); i++) {
            f.setU(ps.get(i));
            daof.adicionarFeed(f);
        }
        //Redirecionar para pagina de perfil de usuário com o listar dos valores colocados acima
        return "/acessologado/EventoPessoa.jsp";
    }
}
