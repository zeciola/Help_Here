package Command.EventoAction;

import Command.ICommand;
import DAO.DAOEndereco;
import DAO.DAOEvento;
import DAO.DAOFeeds;
import DAO.DAOInstituicao;
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

public class CadastrarEventoAction implements ICommand {

    private ArrayList<Instituicao> inst = new ArrayList();
   
    private ArrayList<Endereco> end = new ArrayList();

    
    private Endereco e = new Endereco();
    private Evento ev = new Evento();
    
    //private Evento evento = new Evento();
    private Instituicao in = new Instituicao();
    private Feeds f = new Feeds();
    int contador;
    
    
    private DAOEvento daoev = new DAOEvento();
    private DAOEndereco daoe = new DAOEndereco();
    private DAOFeeds daof = new DAOFeeds();
    private DAOInstituicao daoin = new DAOInstituicao();
    

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        /*String UR = request.getParameter("UR");
        if (UR != null){
            response.sendRedirect("ContadorEvento.jsp");
        }
        */
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
        String[] contadorinst = request.getParameterValues("contadorEv");
        
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

        for (int i = 0; i < idinst.length; i++) {
            
            in.setIdInstituicao(Integer.parseInt(idinst[i]));
            in.setContadorEv(Integer.parseInt(contadorinst[i]));
            /*in.setNome(nomeinst[i]);
            in.setRazao(razaosocial[i]);
            in.setTipo(tipoinst[i]);
            in.setCnpj(cnpjinst[i]);
            in.setModalidade(modalidadeinst[i]);
            in.setEmail(emailinst[i]);*/
            in.setContadorEv(in.getContadorEv()+1);
            daoin.AtualizarContador(in);
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
        
        String valor = null;
        
        valor = (request.getParameter("valordoar"));
        
        if (valor.isEmpty()){
            ev.setMetaVoluntario(Integer.parseInt(request.getParameter("volunquant")));
            daoev.InserirVoluntario(ev);
        }else{
            ev.setMetaValor(Double.parseDouble(request.getParameter("valordoar")));
            daoev.InserirDoacao(ev);
        }
        
         

        for (int j = 0; j < inst.size(); j++) {
            int idInst = inst.get(j).getIdInstituicao();
            in.setIdInstituicao(idInst);
            daoev.InserirAuxInstituicaoEvento(in, ev); 
        }
        
        
        /*for(int j = 0; j < end.size(); j++){
            int idEnd =end.get(j).getIdEndereco();
            
            DAOEvento Ed = new DAOEvento();
            Ed.InserirAuxEnderecoEvento(idEnd, ev.getIdEvento()); 
        }*/

        for (int j = 0; j < end.size(); j++) {
            int idEnd =end.get(j).getIdEndereco();
            
            DAOEvento Ed = new DAOEvento();
            e.setIdEndereco(idEnd);
            Ed.InserirAuxEnderecoEvento(e, ev);  
        }
        String tipo = request.getParameter("tipoEven");
        int idev = ev.getIdEvento();

        ev.setIdEvento(idev);
        ev.setTipoEvento(tipo);

        f.setE(ev);

        //feeds
        ArrayList<Usuario> ids = daof.Interessados(f);

        for (int i = 0; i < ids.size(); i++) {
            f.setU(ids.get(i));
            daof.adicionarFeed(f);
        }

        return "/acessologado/Evento.jsp";
    }
}
