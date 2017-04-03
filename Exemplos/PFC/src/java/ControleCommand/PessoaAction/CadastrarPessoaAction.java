/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControleCommand.PessoaAction;

import ControleCommand.ICommand;
import DAO.DAOEndereco;
import DAO.DAOPessoa;
import Modelo.Endereco;
import Modelo.Pessoa;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Diego
 */
public class CadastrarPessoaAction implements ICommand{

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
                System.out.println("ID DE ENDEREÇOOOOOOOOOO: "+e.getId());
                Pessoa p = new Pessoa();
                p.setNome(request.getParameter("nome"));
                p.setCpf(request.getParameter("cpf"));
                p.setRg(request.getParameter("rg"));
                    String dataString = request.getParameter("datanasc");
                    DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
                    java.sql.Date data = new java.sql.Date(fmt.parse(dataString).getTime());
                p.setDatanasci(data);
                p.setEmail(request.getParameter("email"));
                p.setEndereco(e);
                
                DAOPessoa pdao = new DAOPessoa();
                pdao.setPessoa(p);
                pdao.setE(e);
                pdao.Inserir();
                pdao.aux();
                
                return "sucesso.jsp";
    }
}
