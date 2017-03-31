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
import java.util.logging.Level;
import java.util.logging.Logger;
import static jdk.nashorn.internal.objects.NativeMath.log;


public class DAOInstituicao implements iDAO{
    
    private Endereco en;
    private Connection conexao;
    
    Instituicao instituicao = new Instituicao();
    
    //Construtor Instituicao
    public void setInstituicao (){}
    
    //SQL
    
    private static final String INSERT = "INSERT INTO Instituicao(Nome, razaoSocial, tipo, CNPJ, modalidade, email) VALUES(?, ?, ?, ?, ?, ?)";
    
    private static final String DELETE = "DELETE from Instituicao where id=?;";
    
    private static final String UPDATE = "UPDATE Instituicao SET nome=?, razaoSocial=?, tipo=?, CNPJ=?, modalidade=?, email=? WHERE id=?";
 
    private static final String CONSULTA = "SELECT * from Instituicao WHERE id = ?" ;
    
    private static final String LISTAR = "SELECT * FROM Instituicao";
    
    @Override
    public void Inserir() {
        Connection conexao = null;
        
        try{
           conexao = Conexao.getConexao();
            //PreparedStatement INSERT - RETURN_GENERATED_KEYS por que recebe a id do banco
            conexao.setAutoCommit(false);
            
          PreparedStatement  pst = conexao.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);

            
            pst.setString(1, instituicao.getNome());
            
            pst.setString(2, instituicao.getRazao());
            
            pst.setString(3, instituicao.getTipo());
            
            pst.setString(4, instituicao.getCnpj());
            
            pst.setString(5, instituicao.getModalidade());
            
            pst.setString(6, instituicao.getEmail());
            

            pst.execute();
            
            
            ResultSet rs = pst.getGeneratedKeys();
            
            rs.next();
            
           int idInstituicao = rs.getInt("ID");
           
           String sqlEndereco = "insert into Endereco (cep, NomeLogradouro, Numero, Bairro, Municipio, UF, pais) values(?,?,?,?,?,?,?)";
                   
           PreparedStatement pstmt = conexao.prepareStatement(sqlEndereco);
           
            pstmt.setString(1, instituicao.getEndereco().getCep());
            
            pstmt.setString(2, instituicao.getEndereco().getNomelogradouro());
            
            pstmt.setInt(3, instituicao.getEndereco().getNumeroen());
            
            pstmt.setString(4, instituicao.getEndereco().getBairro());
            
            pstmt.setString(5, instituicao.getEndereco().getMunicipio());
            
            pstmt.setString(6, instituicao.getEndereco().getEstado());
            
            pstmt.setString(7, instituicao.getEndereco().getPais());
            
            pstmt.execute();
      
            conexao.commit();
           
            
            
        }catch(SQLException e){
            try{
                conexao.rollback();
            }   catch (SQLException ex){
                Logger.getLogger(DAOInstituicao.class.getName()).log(Level.SEVERE,null,ex);
            }
            Logger.getLogger(DAOInstituicao.class.getName());
                log(Level.SEVERE, "Erro ao Cadastrar: "+ e.getMessage());
        }finally{
            if(conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex){
                    Logger.getLogger(DAOInstituicao.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
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
                
                instituicao.setModalidade(rsUsuario.getString("email"));
                
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
            
            pst.setString(4, instituicao.getCnpj());
            
            pst.setString(5, instituicao.getModalidade());

            pst.setString(6, instituicao.getEmail());
            
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
