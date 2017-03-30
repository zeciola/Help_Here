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
    
    
    
    private Endereco endereco;
    private Connection conexao;
    
    //SQL inputs
    private static final String INSERT = "insert into endereco (cep, NomeLogradouro, Numero, Bairro, Municipio, Estado, Pais) values(?,?,?,?,?,?,?)";
    private static final String SELECT_ALL = "select * from endereco";
    private static final String SELECT_ID = "select * from endereco where id=?";

    //Construtor
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    //DAO Metodos
    @Override
    public void Inserir() {
        try {
            
            conexao.setAutoCommit(false);
            
            //PreparedStatement INSERT - RETURN_GENERATED_KEYS por que recebe a id do banco
            
            PreparedStatement pstmt = conexao.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            
            pstmt.setString(1, endereco.getCep());
            
            pstmt.setString(2, endereco.getNomelogradouro());
            
            pstmt.setString(3, endereco.getNumeroen());
            
            pstmt.setString(4, endereco.getBairro());
            
            pstmt.setString(5, endereco.getMunicipio());
            
            pstmt.setString(6, endereco.getEstado());
            
            pstmt.setString(7, endereco.getPais());
            
            pstmt.executeUpdate();
            // Fim da pstmt insert
            
            //Resultset para id
            
            ResultSet rs = pstmt.getGeneratedKeys();
            
            if(rs.next()){
                endereco.setIdEndereco(rs.getInt("id"));
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
