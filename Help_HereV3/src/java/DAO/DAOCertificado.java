/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Certificado;
import Model.Evento;
import Model.Instituicao;
import Model.Pessoa;
import Model.Usuario;
import Util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego
 */
public class DAOCertificado {

    public Certificado ListarPendentes(Certificado c) {
        Certificado r = new Certificado();
        ArrayList<Evento> eventos = new ArrayList();
        Connection conexao = Conexao.getConexao();
        ResultSet rs;
        try {
            PreparedStatement pstmt = conexao.prepareStatement("select e.*from Voluntario v, Instituicao i, evento e, instituicaoevento instv where v.idevento = e.id and e.analisado = false and i.id = instv.idinstituicao and instv.idevento = e.id  and e.tipo = 'Voluntariado' and i.id = ?");
            pstmt.setInt(1, c.getInstituicao().getIdInstituicao());
            rs = pstmt.executeQuery();

            while (rs.next()) {
                //Certificado c1 = new Certificado();
                Evento ev = new Evento();
                ev.setIdEvento(rs.getInt("id"));
                ev.setNome(rs.getString("nome"));
                ev.setNome(rs.getString("nome"));
                ev.setDataInicio(rs.getDate("dataInicio"));
                ev.setDataFim(rs.getDate("dataFim"));
                ev.setDescricao(rs.getString("descricao"));
                //c1.setEvento(ev);

                //Instituicao i = new Instituicao();
                //i.setIdInstituicao(rs.getInt("instid"));
                //i.setNome(rs.getString("instnome"));
                //c1.setInstituicao(i);
                eventos.add(ev);
            }
            r.setPendentes(eventos);
            return r;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public ArrayList ListarCertificadosProntos(Certificado c) {
        ArrayList<Certificado> r = new ArrayList();
        Connection conexao = Conexao.getConexao();
        ResultSet rs;
        try {
            PreparedStatement pstmt = conexao.prepareStatement("select p.id idpessoa, p.email, p.nome nomepessoa, e.id idevento, e.nome nomeevento, e.datainicio, e.datafim, i.nome nomeinst, i.id idinst from Usuario u, voluntario v, pessoa p, evento e, instituicao i, instituicaoevento instv where p.id = u.idpessoa and v.idpessoa = p.id and v.idevento = e.id and v.certificado = true and instv.idevento = e.id and instv.idinstituicao = i.id and u.id = ?");
            pstmt.setInt(1, c.getInstituicao().getIdInstituicao());
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Certificado c1 = new Certificado();

                Evento ev = new Evento();
                ev.setIdEvento(rs.getInt("idevento"));
                ev.setNome(rs.getString("nomeevento"));
                ev.setDataInicio(rs.getDate("dataInicio"));
                ev.setDataFim(rs.getDate("dataFim"));
                c1.setEvento(ev);

                Instituicao i = new Instituicao();
                i.setIdInstituicao(rs.getInt("instid"));
                i.setNome(rs.getString("instnome"));
                c1.setInstituicao(i);

                Pessoa p = new Pessoa();
                p.setId(rs.getInt("idpessoa"));
                p.setNome(rs.getString("pessoanome"));
                p.setCpf(rs.getString("cpf"));
                p.setEmail(rs.getString("email"));
                c1.setPessoa(p);

                r.add(c1);
            }
            return r;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void AnalisaCertificado(Certificado c) {
        Connection conexao = Conexao.getConexao();
        try {
            conexao.setAutoCommit(false);
            PreparedStatement pstmt = conexao.prepareStatement("update voluntario set certificado = ?, analisado = true where idpessoa = ? and idevento = ?");
            pstmt.setBoolean(1, c.isValido());
            pstmt.setInt(2, c.getPessoa().getId());
            pstmt.setInt(3, c.getEvento().getIdEvento());            
            pstmt.executeUpdate();
            conexao.commit();

        } catch (SQLException e) {
            try {
                conexao.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(DAOPessoa.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAOPessoa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public ArrayList ListarVoluntariosP(Certificado c) {

        ArrayList<Pessoa> pessoasp = new ArrayList();
        Connection conexao = Conexao.getConexao();
        ResultSet rs;
        try {
            PreparedStatement pstmt = conexao.prepareStatement("select p.* from voluntario v, pessoa p, evento e, instituicao i, instituicaoevento instv where v.idpessoa = p.id and v.idevento = e.id and v.certificado = FALSE and instv.idevento = e.id and instv.idinstituicao = i.id AND e.id = ?");
            pstmt.setInt(1, c.getEvento().getIdEvento());
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Pessoa p = new Pessoa();
                p.setNome(rs.getString("nome"));
                p.setSobrenome(rs.getString("sobrenome"));
                p.setId(rs.getInt("id"));
                p.setEmail(rs.getString("email"));
                pessoasp.add(p);
            }
            return pessoasp;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {

                conexao.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void UpAnalisadoev(Certificado c) {
        Connection conexao = Conexao.getConexao();
        try {
            conexao.setAutoCommit(false);
            PreparedStatement pstmt = conexao.prepareStatement("update evento set analisado = true where id = ?");
            pstmt.setInt(1, c.getEvento().getIdEvento());
            pstmt.executeUpdate();
            conexao.commit();

        } catch (SQLException e) {
            try {
                conexao.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(DAOPessoa.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAOPessoa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public ArrayList ListaCertificadosLiberadosPorUser(Certificado c) {
        ArrayList<Certificado> retorno = new ArrayList();
        Connection conexao = Conexao.getConexao();
        ResultSet rs;
        try {
            PreparedStatement pstmt = conexao.prepareStatement("select u.id iduser, p.id idpessoa, p.nome nomepessoa, p.email, e.id idevento, e.nome nomeevento, e.datafim, e.datainicio, i.nome nomeinst, i.id idinst from Usuario u, voluntario v, pessoa p, evento e, instituicao i, instituicaoevento instv where p.id = u.idpessoa and v.idpessoa = p.id and v.idevento = e.id and v.certificado = true and instv.idevento = e.id and instv.idinstituicao = i.id and u.id = ?");
            pstmt.setInt(1, c.getUsuario().getId());
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Certificado c1 = new Certificado();
                c1.setEmissor("HelpHere");

                Instituicao i = new Instituicao();
                i.setIdInstituicao(rs.getInt("idinst"));
                i.setNome(rs.getString("nomeinst"));
                c1.setInstituicao(i);

                Evento e = new Evento();
                e.setNome(rs.getString("nomeevento"));
                e.setIdEvento(rs.getInt("idevento"));
                e.setDataInicio(rs.getDate("dataInicio"));
                e.setDataFim(rs.getDate("dataFim"));
                c1.setEvento(e);

                Pessoa p = new Pessoa();
                p.setId(rs.getInt("idpessoa"));
                p.setNome(rs.getString("nomepessoa"));
                p.setEmail(rs.getString("email"));
                c1.setPessoa(p);
                retorno.add(c1);
            }

            return retorno;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
