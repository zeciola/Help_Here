/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Penalidade;
import Model.Pessoa;
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
public class DAOPenalisado {

    public void Penalisar(Penalidade p) {
        Connection conexao = Conexao.getConexao();
        try {
            conexao.setAutoCommit(false);
            PreparedStatement pstmt = conexao.prepareStatement("");
            pstmt.setInt(1, p.getP().getId());
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

    public void RemoverPena(Penalidade p) {
        Connection conexao = Conexao.getConexao();
        try {
            conexao.setAutoCommit(false);
            PreparedStatement pstmt = conexao.prepareStatement("update pessoa set penalisado = false where id = ?");
            pstmt.setInt(1, p.getP().getId());
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
    
    public ArrayList ListaPessoasParaLiberar(){
        ArrayList<Pessoa> p = new ArrayList();
    Connection conexao = Conexao.getConexao();
        ResultSet rs;
        try {
            PreparedStatement pstmt = conexao.prepareStatement("select id from pessoa where penalisado = true and datapenalisado+30 <= current_date");
            rs = pstmt.executeQuery();

            while (rs.next()) {
               Pessoa pe = new Pessoa();
               pe.setId(rs.getInt("id"));
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
