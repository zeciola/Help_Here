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


public class DAOInstituicao implements iDAO {
    
    
    private Connection conexao;
    public Instituicao in;
    public Endereco en;
    
    public void setEndereco (Endereco en){
        this.en = en;
    }
    
    //Set Instituicao
    public void setInstituicao (Instituicao in){
        this.in = in;
    }
    
    //SQL
    
    private static final String INSERT = "INSERT INTO Instituicao(ID, Nome, razaoSocial, tipo, CNPJ, modalidade, email, idEnderecoInstituicao, senha) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
    private static final String DELETE = "DELETE from Instituicao where id=?;";
    
    
    private static final String LISTAR = "select * from Instituicao inst, EnderecoInstituicao Ende where inst.ID = Ende.ID";
    
    @Override
    public void Inserir() {
        Connection conexao = null;
        
        try{
           conexao = Conexao.getConexao();
            //PreparedStatement INSERT - RETURN_GENERATED_KEYS por que recebe a id do banco
            conexao.setAutoCommit(false);
            
           String sqlEndereco = "insert into EnderecoInstituicao (cep, NomeLogradouro, Numero, Bairro, Municipio, UF, pais) values(?,?,?,?,?,?,?)";
                   
           PreparedStatement pstmt = conexao.prepareStatement(sqlEndereco, PreparedStatement.RETURN_GENERATED_KEYS);
           
            pstmt.setString(1, in.getEndereco().getCep());
            
            pstmt.setString(2, in.getEndereco().getNomelogradouro());
            
            pstmt.setInt(3, in.getEndereco().getNumeroen());
            
            pstmt.setString(4, in.getEndereco().getBairro());
            
            pstmt.setString(5, in.getEndereco().getMunicipio());
            
            pstmt.setString(6, in.getEndereco().getEstado());
            
            pstmt.setString(7, in.getEndereco().getPais());
            
            pstmt.execute();
           
            
            ResultSet rs = pstmt.getGeneratedKeys();
            rs.next();
            int id = rs.getInt("ID");
            
            
            
            PreparedStatement  pst = conexao.prepareStatement(INSERT);

            pst.setInt(1, id);
            
            pst.setString(2, in.getNome());
            
            pst.setString(3, in.getRazao());
            
            pst.setString(4, in.getTipo());
            
            pst.setString(5, in.getCnpj());
            
            pst.setString(6, in.getModalidade());
            
            pst.setString(7, in.getEmail());
            
            pst.setInt(8, id);
            
            pst.setString(9, in.getSenha());
            

            pst.execute();

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

        ArrayList<Instituicao> resul = new ArrayList();
        try{
            conexao = Conexao.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(LISTAR);
            ResultSet rs;
            rs=pstmt.executeQuery();
            while (rs.next()){
                Instituicao in = new Instituicao();
                Endereco en = new Endereco();
                 in.setIdInstituicao(rs.getInt("ID"));
                 in.setNome(rs.getString("Nome"));
                 in.setRazao(rs.getString("razaoSocial"));
                 in.setTipo(rs.getString("tipo"));
                 in.setCnpj(rs.getString("CNPJ"));
                 in.setModalidade(rs.getString("modalidade"));
                 in.setEmail(rs.getString("email"));
                 en.setIdEndereco(rs.getInt("ID"));
                 en.setCep(rs.getString("cep"));
                 en.setNomelogradouro(rs.getString("NomeLogradouro"));
                 en.setNumeroen(Integer.parseInt(rs.getString("Numero")));
                 en.setBairro(rs.getString("Bairro"));
                 en.setMunicipio(rs.getString("Municipio"));
                 en.setEstado(rs.getString("UF"));
                 en.setPais(rs.getString("pais"));
                 in.setEndereco(en);
                 resul.add(in);
                 
             }
             return resul;
          
        }catch(SQLException e){
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
    public void Atualizar(String OBJ) {
        
        Connection conexao = null;
        
        try{
        conexao = Conexao.getConexao();
        
        conexao.setAutoCommit(false);
            
            //PreparedStatement INSERT - RETURN_GENERATED_KEYS por que recebe a id do banco
            
           String sqlEndereco = "UPDATE EnderecoInstituicao  SET cep=?, NomeLogradouro=?, Numero=?, Bairro=?, Municipio=?, UF=?, pais=? WHERE CNPJ="+in.getEndereco().getIdEndereco()+";";
                   
            PreparedStatement pstmt = conexao.prepareStatement(sqlEndereco, PreparedStatement.RETURN_GENERATED_KEYS);
      
            pstmt.setString(1, in.getEndereco().getCep());
            
            pstmt.setString(2, in.getEndereco().getNomelogradouro());
            
            pstmt.setInt(3, in.getEndereco().getNumeroen());
            
            pstmt.setString(4, in.getEndereco().getBairro());
            
            pstmt.setString(5, in.getEndereco().getMunicipio());
            
            pstmt.setString(6, in.getEndereco().getEstado());
            
            pstmt.setString(7, in.getEndereco().getPais());
            
            pstmt.executeUpdate();
           
            ResultSet rs = pstmt.getGeneratedKeys();
            rs.next();
            int id = rs.getInt("ID");
            
            
           
            String sqlInstituicao = "UPDATE Instituicao SET nome=?, razaoSocial=?, tipo=?, CNPJ=?, modalidade=?, email=?, idEnderecoInstituicao=?  WHERE CNPJ="+in.getCnpj()+";";
            
            PreparedStatement  pst = conexao.prepareStatement(sqlInstituicao);

            pst.setInt(1, id);
            
            pst.setString(2, in.getNome());
            
            pst.setString(3, in.getRazao());
            
            pst.setString(4, in.getTipo());
            
            pst.setString(5, in.getCnpj());
            
            pst.setString(6, in.getModalidade());
            
            pst.setString(7, in.getEmail());
            
            pst.setInt(8, id);
            

            pst.executeUpdate();
            conexao.commit();
           
            
            
        }catch(SQLException e){
            try{
                conexao.rollback();
            }   catch (SQLException ex){
                Logger.getLogger(DAOInstituicao.class.getName()).log(Level.SEVERE,null,ex);
            }
            Logger.getLogger(DAOInstituicao.class.getName());
                log(Level.SEVERE, "Erro ao Alterar: "+ e.getMessage());
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
    public void Deletar(String CNP) {
        Instituicao in = new Instituicao();
        String SEN = "1";
        try{
            conexao = Conexao.getConexao();
            String sqlDel = "delete from Instituicao where CNPJ ='"+CNP+"' and senha ='"+SEN+"';";
            PreparedStatement pstmt = conexao.prepareStatement(sqlDel);
            
            
            
            
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    @Override
    public ArrayList Consultar(String CNP) {
        ArrayList<Instituicao> resul = new ArrayList();
        return resul;
     
    }

    

}
