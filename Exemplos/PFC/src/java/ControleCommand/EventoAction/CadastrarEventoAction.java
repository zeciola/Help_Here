/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControleCommand.EventoAction;

import ControleCommand.ICommand;
import DAO.DAOEndereco;
import DAO.DAOEvento;
import Modelo.Endereco;
import Modelo.Evento;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Diego
 */
public class CadastrarEventoAction implements ICommand{

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
                Endereco e = new Endereco();
                e.setLogradouro(request.getParameter("logradouro"));
                e.setNome(request.getParameter("nlogradouro"));
                e.setNumero(Integer.parseInt(request.getParameter("numero")));
                e.setBairro(request.getParameter("bairro"));
                e.setMunicipio(request.getParameter("municipio"));
                e.setUf(request.getParameter("uf"));
                e.setCep(request.getParameter("cep"));
                DAOEndereco edao= new DAOEndereco();
                edao.setEndereco(e);
                edao.Inserir();
                System.out.println("ID DE ENDEREÇO: "+e.getId());
                
                Evento ev = new Evento();
                ev.AddEndereco(e);
                Date datahoje = new Date(System.currentTimeMillis());
                ev.setDataCad(datahoje);
                String data1 = request.getParameter("dataini");
                    DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
                    java.sql.Date data = new java.sql.Date(fmt.parse(data1).getTime());
                ev.setInicio(data);
                String data2 = request.getParameter("datafim");
                     DateFormat fmt2 = new SimpleDateFormat("dd/MM/yyyy");
                     java.sql.Date dataf = new java.sql.Date(fmt2.parse(data2).getTime());
                ev.setDataFim(dataf);
                ev.setNome(request.getParameter("nome"));
                ev.setDescricao(request.getParameter("descricao"));
                DAOEvento daoev = new DAOEvento();
                daoev.setEvento(ev);
                daoev.Inserir();
                daoev.InserirRe(e);
        return "index.jsp";
    }
    
}
