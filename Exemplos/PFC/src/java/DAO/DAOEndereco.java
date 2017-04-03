/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.Conecta;

/**
 *
 * @author Diego
 */
public class DAOEndereco implements InterfaceDAO{
    private Endereco endereco;
    private Connection conexao;
    private static final String INSERT = "insert into endereco(logradouro, nomelogradouro, numero, bairro, cidade, estado, pais, cep )values(?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM endereco";
    private static final String SELECT_BY_ID = "SELECT * FROM endereco WHERE id=? and status = true";
     
     
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    @Override
    public void Inserir() {
        try {
            conexao = Conecta.getConexao();
            conexao.setAutoCommit(false);
            PreparedStatement pstmt = conexao.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, endereco.getLogradouro());
            pstmt.setString(2, endereco.getNome());
            pstmt.setInt(3, endereco.getNumero());
            pstmt.setString(4, endereco.getBairro());
            pstmt.setString(5, endereco.getMunicipio());
            pstmt.setString(6, endereco.getUf());
            pstmt.setString(7, endereco.getPais());
            pstmt.setString(8, endereco.getCep());
            pstmt.execute();
            ResultSet rsId = pstmt.getGeneratedKeys();
            if(rsId.next()){
                endereco.setId(rsId.getInt("id"));
                conexao.commit();
            }
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

    @Override
    public void Atualizar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Deletar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList Consultar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList Listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
