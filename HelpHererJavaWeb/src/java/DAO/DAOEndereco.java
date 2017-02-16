package DAO;

import Command.*;
import Control.*;
import Model.*;
import DAO.*;
import Util.*;
import java.sql.Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOEndereco implements iDAO {
    
    //Variavel tipo de metodo
    private String classTipo;
    //Endereço
    private Endereco endereco;
    //Variable connection
    private final Connection conexao = Conexao.getConexao();

    //SQL inputs
    private static final String INSERT = "insert into endereco (endereco, numeroen, cidade, estado, cep) values(?,?,?,?,?)";
    private static final String SELECT_ALL = "select * from endereco";
    private static final String SELECT_ID = "select * from endereco where id=? status=true";

    //Construtor
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    //DAO Metodos
    @Override
    public void Inserir() {
        try {
            
            conexao.setAutoCommit(false);
            
            //PreparedStatement INSERT
            PreparedStatement pstmt = conexao.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            
            pstmt.setString(1, endereco.getEndereco());
            
            pstmt.setString(2, endereco.getNumeroen());
            
            pstmt.setString(3, endereco.getCidade());
            
            pstmt.setString(4, endereco.getEstado());
            
            pstmt.setString(5, endereco.getCep());
            
            pstmt.executeUpdate();
            // Fim da pstmt insert
            
            //Resultset para id
            
            ResultSet rs = pstmt.getGeneratedKeys();
            
            if(rs.next()){
                endereco.setId(rs.getInt("id"));
                conexao.commit();
            }
            //Fim da busca
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void Atualizar() {

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
