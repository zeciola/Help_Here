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
    private Endereco en;
    //Variable connection
    private final Connection conexao = Conexao.getConexao();


    //SQL inputs
    private static final String INSERT = "insert into endereco (cep, NomeLogradouro, Numero, Bairro, Municipio, UF, pais) values(?,?,?,?,?,?,?)";
    private static final String SELECT_ALL = "select * from endereco";
    private static final String SELECT_ID = "select * from endereco where id=?";

    //Construtor
    public void setEndereco(Endereco endereco) {
        this.en = en;
    }

    //DAO Metodos
    @Override
    public void Inserir() {
        try {
            
            conexao.setAutoCommit(false);
            
            //PreparedStatement INSERT - RETURN_GENERATED_KEYS por que recebe a id do banco
            
            PreparedStatement pstmt = conexao.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            
            pstmt.setString(1, en.getCep());
            
            pstmt.setString(2, en.getNomelogradouro());
            
            pstmt.setInt(3, en.getNumeroen());
            
            pstmt.setString(4, en.getBairro());
            
            pstmt.setString(5, en.getMunicipio());
            
            pstmt.setString(6, en.getEstado());
            
            pstmt.setString(7, en.getPais());
            
            pstmt.execute();
            // Fim da pstmt insert
            
            //Resultset para id
            
            ResultSet rs = pstmt.getGeneratedKeys();
            
            rs.next();
            
            en.setIdEndereco(rs.getInt("ID"));
            
            conexao.commit();
            
            //Fim da busca
            
        } // Verifica se a conexao foi fechada
        catch (SQLException sqlErro) {
            throw new RuntimeException(sqlErro);
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
