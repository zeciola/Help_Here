/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Evento;
import Model.Notificacao;
import Model.Pessoa;
import Util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAONotificacao {

    public ArrayList ListarParaNotificar() {
        ArrayList<Evento> e = new ArrayList();
        Connection conexao = Conexao.getConexao();
        ResultSet rs;
        try {
            PreparedStatement pstmt = conexao.prepareStatement("select id, nome from evento where tipo = 'Voluntariado' and datainicio between current_date and current_date+5 and status = true");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Evento ev = new Evento();
                ev.setIdEvento(rs.getInt("id"));
                ev.setNome(rs.getString("nome"));
                e.add(ev);
            }
            return e;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        } finally {
            try {
                conexao.close();
            } catch (SQLException erro2) {
                throw new RuntimeException(erro2);
            }
        }
    }

    public ArrayList ListarContatos(Notificacao n2) {
        ArrayList<Pessoa> p = new ArrayList();
        Connection conexao = Conexao.getConexao();
        ResultSet rs;
        try {
            PreparedStatement pstmt = conexao.prepareStatement("select p.email, p.nome from voluntario v, pessoa p, evento e, instituicao i, instituicaoevento instv where v.idpessoa = p.id and v.idevento = e.id and instv.idevento = e.id and instv.idinstituicao = i.id AND e.id = ?");
            pstmt.setInt(1, n2.getE().getIdEvento());
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Pessoa pe = new Pessoa();
                pe.setEmail(rs.getString("email"));
                p.add(pe);

            }
            return p;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        } finally {
            try {
                conexao.close();
            } catch (SQLException erro2) {
                throw new RuntimeException(erro2);
            }
        }
    }

}
