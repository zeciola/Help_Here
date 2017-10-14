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

/**
 *
 * @author Diego
 */
public class DAOCertificado {

    public ArrayList ListarPendentes(Certificado c) {
        ArrayList<Certificado> r = new ArrayList();
        Connection conexao = Conexao.getConexao();
        ResultSet rs;
        try {
            PreparedStatement pstmt = conexao.prepareStatement("select p.id idpessoa, p.nome PessoaNome, p.cpf, i.id instid, i.nome InstNome,e.id idevento, e.tipo, e.nome NomeEvento, v.analisado from Voluntario v, Instituicao i, Pessoa p, evento e, instituicaoevento instv where v.idevento = e.id and v.idpessoa = p.id and i.id = instv.idinstituicao and instv.idevento = e.id and e.tipo = 'Voluntariado' and v.analisado = false and i.id = ?");
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

    public ArrayList ListarCertificadosProntos(Certificado c) {
        ArrayList<Certificado> r = new ArrayList();
        Connection conexao = Conexao.getConexao();
        ResultSet rs;
        try {
            PreparedStatement pstmt = conexao.prepareStatement("select p.id idpessoa, p.nome PessoaNome, p.cpf, i.id instid, i.nome InstNome,e.id idevento, e.tipo, e.nome NomeEvento, v.analisado from Voluntario v, Instituicao i, Pessoa p, evento e, instituicaoevento instv where v.idevento = e.id and v.idpessoa = p.id and i.id = instv.idinstituicao and instv.idevento = e.id and e.tipo = 'Voluntariado' and v.analisado = false and i.id = ?");
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

}
