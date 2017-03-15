package DAO;

import Command.*;
import Control.*;
import Model.*;
import DAO.*;
import Util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOPessoa implements iDAO{
    
    private Pessoa pessoa;
    private Endereco en;
    private Connection conexao;
    
    public void setPessoa() {
        this.pessoa = pessoa;
    }
    
    //SQL
    private static final String INSERT = "insert into pessoa (nome, email, datanas, ceular, rg, cpf, sexo, status) values(?,?,?,?,?,?,?,?)";
    
    private static final String DELETE = "update pessoa set";
    
    //DAOs
    @Override
    public void Inserir() {
        try{
            conexao.setAutoCommit(false);
            
            //
            
            PreparedStatement pstmt = conexao.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            
        }catch(SQLException e){
            throw new RuntimeException(e);
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
