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
import java.sql.Statement;
import java.util.ArrayList;

public class DAOInstituicao implements iDAO{
    
    private Instituicao instituicao;
    private Endereco en;
    private Connection conexao;
    
    
    
    //Construtor Instituicao
    public void setInstituicao() {
        this.instituicao = instituicao;
    }
    
    //SQL
    
    private static final String INSERT = "INSERT INTO Instituicao(nome, razaoSocial, tipo, CNPJ, modalidade) VALUES(?, ?, ?, ?, ?)";
    
    private static final String DELETE = "DELETE from Instituicao where id=?;";
    
    private static final String UPDATE = "UPDATE Instituicao SET nome=?, razaoSocial=?, tipo=?, CNPJ=?, modalidade=? WHERE id=?";
 
    private static final String CONSULTA = "SELECT * from Instituicao WHERE id = ?" ;
    
    private static final String LISTAR = "SELECT * FROM Instituicao";
    
    @Override
    public void Inserir() {
        try{
            conexao.setAutoCommit(false);
            
            //PreparedStatement INSERT - RETURN_GENERATED_KEYS por que recebe a id do banco
            
            PreparedStatement pst = conexao.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);

            pst.setString(1, instituicao.getNome());
            
            pst.setString(2, instituicao.getRazao());
            
            pst.setString(3, instituicao.getTipo());
            
            pst.setString(3, instituicao.getCnpj());
            
            pst.setString(3, instituicao.getModalidade());

            pst.executeUpdate();

            
            ResultSet rs = pst.getGeneratedKeys();
            
            if(rs.next()){
                instituicao.setIdInstituicao(rs.getInt("id"));
                conexao.commit();
            }
            
            
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public ArrayList<Instituicao> Listar() {

        PreparedStatement pstmt = null;
        ResultSet rsUsuario;

        try 
        {
            conexao.setAutoCommit(false);
            pstmt = conexao.prepareStatement(LISTAR); // prepara a instrução em sql para os parâmetros informados (?)
            // atribui os valores nos parâmetros (?) 
            ArrayList<Instituicao> retorno = new ArrayList<>();
           
            rsUsuario = pstmt.executeQuery();
            
            while (rsUsuario.next())
            {
                instituicao.setIdInstituicao(rsUsuario.getInt("id"));
                
                instituicao.setNome(rsUsuario.getString("nome"));
                
                instituicao.setRazao(rsUsuario.getString("razaoSocial"));
                
                instituicao.setTipo(rsUsuario.getString("tipo"));
                
                instituicao.setCnpj(rsUsuario.getString("CNPJ"));
                
                instituicao.setModalidade(rsUsuario.getString("modalidade"));
                
                retorno.add(instituicao);

            }
            return retorno;

        } catch (SQLException e)
            {
                throw new RuntimeException(e);
            }

        
    }

       
    @Override
    public void Atualizar() {
        try{
            conexao.setAutoCommit(false);
            
            //PreparedStatement INSERT - RETURN_GENERATED_KEYS por que recebe a id do banco
            
            PreparedStatement pst = conexao.prepareStatement(UPDATE, PreparedStatement.RETURN_GENERATED_KEYS);

            pst.setString(1, instituicao.getNome());
            
            pst.setString(2, instituicao.getRazao());
            
            pst.setString(3, instituicao.getTipo());
            
            pst.setString(3, instituicao.getCnpj());
            
            pst.setString(3, instituicao.getModalidade());

            pst.executeUpdate();

            
            ResultSet rs = pst.getGeneratedKeys();
            
            if(rs.next()){
                instituicao.setIdInstituicao(rs.getInt("id"));
                conexao.commit();
            }
            
            
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
        
    
@Override
    public void Deletar() {
        try{
            conexao.setAutoCommit(false);
            
            //PreparedStatement INSERT - RETURN_GENERATED_KEYS por que recebe a id do banco
            
            PreparedStatement pst = conexao.prepareStatement(DELETE, PreparedStatement.RETURN_GENERATED_KEYS);

            

            pst.setInt(1, instituicao.getIdInstituicao());

             pst.executeUpdate();

            
            ResultSet rs = pst.getGeneratedKeys();
            
            if(rs.next()){
                instituicao.setIdInstituicao(rs.getInt("id"));
                conexao.commit();
            }
            
            
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    

  
    @Override
    public ArrayList Consultar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
