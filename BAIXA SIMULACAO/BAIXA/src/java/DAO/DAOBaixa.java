/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODELO.Baixa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Conexao;

/**
 *
 * @author Diego
 */
public class DAOBaixa {

    private Connection conexao;

    public void RealizarPagamento(Baixa b) {

        conexao = Conexao.getConexao();
        try {
            conexao.setAutoCommit(false);
            PreparedStatement pstmt = conexao.prepareStatement("update valoresdoados set databaixa=current_date, statusbaixa=true where boleto=?");
            pstmt.setString(1, b.getNumeroBoleto());
            pstmt.execute();
            conexao.commit();

        } catch (SQLException e) {
            try {
                conexao.rollback();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
        }
    }

    public double BuscaValorAPagar(Baixa b) {
        double valor = 0;
        conexao = Conexao.getConexao();
        try {
            conexao = Conexao.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement("select * from valoresdoados where boleto=?");
            pstmt.setString(1, b.getNumeroBoleto());
            ResultSet rs;
            rs = pstmt.executeQuery();
            while (rs.next()) {
                valor = rs.getDouble("valor");
            }
            return valor;
        } catch (SQLException e) {
            System.out.println(e);
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
