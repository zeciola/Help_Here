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


public class DAOInstituicao /*implements iDAO*/ {
    
    
    
    //SQL
    
    private static final String INSERT = "INSERT INTO Instituicao(ID, Nome, razaoSocial, tipo, CNPJ, modalidade, email, idEnderecoInstituicao, senha, status, contador) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, true, ?)";
    
    
    
    private static final String AUTENTICAR_INSTITUICAO = "select * from Instituicao inst, EnderecoInstituicao Ende where inst.ID = Ende.ID and inst.CNPJ = ? and inst.senha = ?";
    
    private static final String LISTAR2 = "select * from Instituicao WHERE STATUS = TRUE";
    
    private static final String LISTAR = "select * from Instituicao inst, EnderecoInstituicao Ende where inst.ID = Ende.ID and inst.status = true";
    
    //@Override
    public void Inserir(Instituicao in) {
        Connection conexao = null;
        
        try{
           conexao = Conexao.getConexao();
            //PreparedStatement INSERT - RETURN_GENERATED_KEYS por que recebe a id do banco
            conexao.setAutoCommit(false);
            
            int id = 0;
            id = in.getEndereco().getIdEndereco();
            
            
            
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
            
            pst.setInt(10, in.getContadorEv());
            

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
    
    
    //@Override
    public ArrayList<Instituicao> Listar() {
        Connection conexao = null;
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

   public void AtualizarContador(Instituicao obj) {
   Connection conexao = null;
        
        try{
        conexao = Conexao.getConexao();
        
        conexao.setAutoCommit(false);
            
            //PreparedStatement INSERT - RETURN_GENERATED_KEYS por que recebe a id do banco
            
           
            
            
           
            String sqlInstituicao = "UPDATE Instituicao SET  contador="+obj.getContadorEv()+"  WHERE ID="+obj.getIdInstituicao()+" ";
            
            PreparedStatement  pst = conexao.prepareStatement(sqlInstituicao, PreparedStatement.RETURN_GENERATED_KEYS);
            
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
    
       
        
    //@Override
    public void Atualizar(Instituicao in) {
        
        Connection conexao = null;
        
        try{
        conexao = Conexao.getConexao();
        
        conexao.setAutoCommit(false);
            
            //PreparedStatement INSERT - RETURN_GENERATED_KEYS por que recebe a id do banco
            
           
            
            
           
            String sqlInstituicao = "UPDATE Instituicao SET  nome=?, razaoSocial=?, tipo=?, CNPJ=?, modalidade=?, email=?, senha=?  WHERE ID="+in.getEndereco().getIdEndereco()+" ";
            
            PreparedStatement  pst = conexao.prepareStatement(sqlInstituicao, PreparedStatement.RETURN_GENERATED_KEYS);

           
            
            pst.setString(1, in.getNome());
            
            pst.setString(2, in.getRazao());
            
            pst.setString(3, in.getTipo());
            
            pst.setString(4, in.getCnpj());
            
            pst.setString(5, in.getModalidade());
            
            pst.setString(6, in.getEmail());
           
            pst.setString(7, in.getSenha());
            

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
    
        

    public void Deletar(Instituicao inst) {
        Connection conexao = null;
        try{
            conexao = Conexao.getConexao();
            
            String sqlDel = "update EnderecoInstituicao set status = false where ID in (select Ende.ID from Instituicao inst, EnderecoInstituicao Ende where inst.ID = Ende.ID and CNPJ = '"+inst.getCnpj()+"' and senha = '"+inst.getSenha()+"');";
            
            PreparedStatement pstmt = conexao.prepareStatement(sqlDel);
            pstmt.execute();
            
            String sqlDelInst = "update Instituicao set status = false WHERE CNPJ = '"+inst.getCnpj()+"' and senha = '"+inst.getSenha()+"';";
            
            pstmt = conexao.prepareStatement(sqlDelInst);
            pstmt.execute();
           
           
    
            
            
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
   
    //@Override
    public ArrayList Consultar(Instituicao inst) {
        Connection conexao = null;
        ArrayList<Instituicao> resul = new ArrayList();
        ArrayList<Endereco> re = new ArrayList();
        try{
            conexao = Conexao.getConexao();
            String sqlConsulta = "select * from Instituicao inst, EnderecoInstituicao Ende where inst.ID = Ende.ID and CNPJ ='"+inst.getCnpj()+"' and inst.status = true;";
            PreparedStatement pstmt = conexao.prepareStatement(sqlConsulta);
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
                 in.setContadorEv(Integer.parseInt(rs.getString("contador")));
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
    
    public Instituicao autenticaInstituicao(Instituicao instituicao) {
        Instituicao loginAutenticado = null;

        Connection conexao = null;
        PreparedStatement pstmt = null;
        ResultSet rsLogin = null;
        try {
            conexao = Conexao.getConexao();
            pstmt = conexao.prepareStatement(AUTENTICAR_INSTITUICAO);
            pstmt.setString(1, instituicao.getCnpj());
            pstmt.setString(2, instituicao.getSenha());
            rsLogin = pstmt.executeQuery();

            if (rsLogin.next()) {
                loginAutenticado = new Instituicao();
                Endereco en = new Endereco();
                loginAutenticado.setIdInstituicao(rsLogin.getInt("ID"));
                loginAutenticado.setCnpj(rsLogin.getString("CNPJ"));
                loginAutenticado.setSenha(rsLogin.getString("senha"));
                loginAutenticado.setNome(rsLogin.getString("nome"));
                loginAutenticado.setRazao(rsLogin.getString("razaoSocial"));
                loginAutenticado.setTipo(rsLogin.getString("tipo"));
                loginAutenticado.setModalidade(rsLogin.getString("modalidade"));
                loginAutenticado.setEmail(rsLogin.getString("email"));
                loginAutenticado.setModalidade(rsLogin.getString("modalidade"));
                loginAutenticado.setContadorEv(rsLogin.getInt("contador"));
                
                en.setCep(rsLogin.getString("cep"));
                en.setNomelogradouro(rsLogin.getString("NomeLogradouro"));
                en.setNumeroen(rsLogin.getInt("Numero"));
                en.setCep(rsLogin.getString("cep"));
                en.setBairro(rsLogin.getString("Bairro"));
                en.setMunicipio(rsLogin.getString("Municipio"));
                en.setPais(rsLogin.getString("Pais"));
                
                loginAutenticado.setEndereco(en);
            }

        } catch (SQLException sqlErro) {
            throw new RuntimeException(sqlErro);
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        return loginAutenticado;
    }     
    
    public ArrayList<Instituicao> Listar2() {
        Connection conexao = null;
        ArrayList<Instituicao> resul = new ArrayList();
        try{
            conexao = Conexao.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(LISTAR2);
            ResultSet rs;
            rs=pstmt.executeQuery();
            while (rs.next()){
                Instituicao in = new Instituicao();
                 in.setIdInstituicao(rs.getInt("ID"));
                 in.setNome(rs.getString("Nome"));
                 in.setRazao(rs.getString("razaoSocial"));
                 in.setTipo(rs.getString("tipo"));
                 in.setCnpj(rs.getString("CNPJ"));
                 in.setModalidade(rs.getString("modalidade"));
                 in.setEmail(rs.getString("email"));
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
}
