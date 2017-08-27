package DAO;

import Model.Contribuicao;

import Util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOContribuir {

    public void DoarValor(Contribuicao c) {
        Connection conexao = Conexao.getConexao();
        try {
            conexao.setAutoCommit(false);
            PreparedStatement pstmt = conexao.prepareStatement("insert into valoresdoados (Valor, dataDoado, idCampanha, IDPessoa) values(?, CURRENT_DATE, ?, ?)");
            pstmt.setDouble(1, c.getValor());
            pstmt.setInt(2, c.getEv().getIdEvento());
            pstmt.setInt(3, c.getUser().getId());
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

    public void Voluntariar(Contribuicao c) {
        Connection conexao = Conexao.getConexao();
        try {
            conexao.setAutoCommit(false);
            PreparedStatement pstmt = conexao.prepareStatement("insert into voluntario (idpessoa, idevento, datavoluntario) values(?,?,CURRENT_DATE)");
            pstmt.setInt(1, c.getUser().getId());
            pstmt.setInt(2, c.getEv().getIdEvento());
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
}
