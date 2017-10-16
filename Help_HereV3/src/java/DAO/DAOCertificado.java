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
            PreparedStatement pstmt = conexao.prepareStatement("select p.id idpessoa, p.nome nomepessoa, e.id idevento, e.nome nomeevento, i.nome nomeinst, i.id idinst from Usuario u, voluntario v, pessoa p, evento e, instituicao i, instituicaoevento instv where p.id = u.idpessoa and v.idpessoa = p.id and v.idevento = e.id and v.certificado = true and instv.idevento = e.id and instv.idinstituicao = i.id and u.id = ?");
            pstmt.setInt(1, c.getInstituicao().getIdInstituicao());
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Certificado c1 = new Certificado();

                Evento ev = new Evento();
                ev.setIdEvento(rs.getInt("idevento"));
                ev.setNome(rs.getString("nomeevento"));
                c1.setEvento(ev);

                Instituicao i = new Instituicao();
                i.setIdInstituicao(rs.getInt("instid"));
                i.setNome(rs.getString("instnome"));
                c1.setInstituicao(i);

                Pessoa p = new Pessoa();
                p.setId(rs.getInt("idpessoa"));
                p.setNome(rs.getString("pessoanome"));
                p.setCpf(rs.getString("cpf"));
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
            PreparedStatement pstmt = conexao.prepareStatement("update voluntario set certificado = ?, analisado = ? where idpessoa = ?");
            pstmt.setBoolean(1, c.isValido());
            pstmt.setBoolean(2, c.isAnalisado() );
            pstmt.setInt(3, c.getPessoa().getId());
            pstmt.execute();
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
    
    public ArrayList ListarVoluntariosP (Certificado c){
        
        
        return null;
    }
}
