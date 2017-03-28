
package DAO;

import Command.*;
import Control.*;
import Model.*;
import DAO.*;
import Util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOPessoa implements iDAO{
    
    private Pessoa pessoa;
    private Endereco en;
    private Connection conexao;
    
    // defalt variabel Penalisado = false
    
    private boolean defalt;
    
    
    //Construtor Pessoa
    public void setPessoa() {
        this.pessoa = pessoa;
    }
    
    //SQL
    
    private static final String INSERT = "insert into Pessoa (Nome, Sobrenome, CPF, RG, Penalisado, Datanascimento, email, IDEndereco, Telefone, celular, sexo) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
    private static final String DELETE = "update pessoa set";
    
    private static final String UPDATE = "";
    
    //DAOs
    @Override
    public void Inserir() {
        try{
            conexao.setAutoCommit(false);
            
            //PreparedStatement INSERT - RETURN_GENERATED_KEYS por que recebe a id do banco
            
            PreparedStatement pstmt = conexao.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            
            pstmt.setString(1, pessoa.getNome());
            
            pstmt.setString(2, pessoa.getSobrenome());
            
            pstmt.setString(3, pessoa.getCpf());
            
            pstmt.setString(4, pessoa.getRg());
            
            pstmt.setBoolean(5, pessoa.isPenalisado());
            
            pstmt.setString(6, pessoa.getDatanascimento());
            
            pstmt.setString(7, pessoa.getEmail());
            
            pstmt.setInt(8, en.getIdEndereco());;
            
            pstmt.setString(9, pessoa.getTelefone());
            
            pstmt.setString(10, pessoa.getCelular());
            
            pstmt.setString(11, pessoa.getSexo());
            
            pstmt.executeUpdate();
            
            //Fim do pstmt inserir
            
            ResultSet rs = pstmt.getGeneratedKeys();
            
            if(rs.next()){
                pessoa.setId(rs.getInt("id"));
                conexao.commit();
            }
            
            
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
