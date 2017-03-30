package DAO;

import Command.*;
import Control.*;
import Model.*;
import DAO.*;
import Util.*;
import java.sql.Connection;
import Model.PerfilDeAcesso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Util.Conexao;
import java.util.ArrayList;


public class DAOUsuario implements iDAO{
 
    //Variaveis comuns ou tipo defalt
    private String defalt = "comum";
    
    //Variaveis de chamada
    private Login lo;
    private Pessoa pe;
    private Connection conexao;
    
    
    private static final String INSERT = "INSERT INTO Usuario (IDPessoa ,Tipo , Login, senha) VALUES (?,?,?,?)";
    private static final String AUTENTICAR_USUARIO = "SELECT * FROM Usuario WHERE Login=? AND senha=?";

    //Construtor
    public void setUsuario(Login lo) {
        this.lo = lo;
    }
    
     public void cadastraNovoUsuario(Login login) throws SQLException {
    Connection conexao = null;

    
    }
     
    @Override
    public void Inserir() {
        try {
        conexao.setAutoCommit(false);

        
        //PreparedStatement INSERT - RETURN_GENERATED_KEYS por que recebe a id do banco
        
        PreparedStatement pstmt = conexao.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
        
        pstmt.setInt(1, pe.getId());
        pstmt.setString(2, lo.getPerfil().toString());
        pstmt.setString(3, lo.getNome());
        pstmt.setString(4, lo.getSenha());
        
        pstmt.executeUpdate();
        
        //Fim do pstmt inserir
        
        
        ResultSet rs = pstmt.getGeneratedKeys();
            
            rs.next();
            
            lo.setId(rs.getInt("ID"));
            
            conexao.commit();
        
        } 
        // Verifica se a conexao foi fechada
        catch (SQLException sqlErro) {
            throw new RuntimeException(sqlErro);
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
    
    //Autenticação metodo unido não necessita estar na interface!
    
    public Login autenticaUsuario(Login login) {
        Login loginAutenticado = null;

        Connection conexao = null;
        PreparedStatement pstmt = null;
        ResultSet rsLogin = null;
        try {
            conexao = Conexao.getConexao();
            pstmt = conexao.prepareStatement(AUTENTICAR_USUARIO);
            pstmt.setString(1, login.getNome());
            pstmt.setString(2, login.getSenha());
            rsLogin = pstmt.executeQuery();
        

        if (rsLogin.next()) {
            loginAutenticado = new Login();
            loginAutenticado.setNome(rsLogin.getString("login"));
            loginAutenticado.setSenha(rsLogin.getString("senha"));
            loginAutenticado.setPerfil(PerfilDeAcesso.valueOf(rsLogin.getString("tipo")));
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
}
    