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


public class DAOUsuario {
 
    private Login login;
    private final Connection conexao = Conexao.getConexao();
    
    
    private static final String INSERT = "INSERT INTO Usuario (Login, senha, Tipo) VALUES (?,?,?)";
    private static final String AUTENTICAR_USUARIO = "SELECT * FROM Usuario WHERE Login=? AND senha=?";

    //Construtor
    public void setUsuario(Login login) {
        this.login = login;
    }
    
     public void cadastraNovoUsuario(Login login) throws SQLException {
    Connection conexao = null;
    PreparedStatement pstmt = conexao.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
    try {
        
        
        conexao = Conexao.getConexao();
        pstmt = conexao.prepareStatement(INSERT);
        pstmt.setString(1, login.getNome());
        pstmt.setString(2, login.getSenha());
        pstmt.setString(3, login.getPerfil().toString());
        pstmt.execute();
        
        } catch (SQLException sqlErro) {
            throw new RuntimeException(sqlErro);
            } finally {
            if (conexao != null) {
            try {
            conexao.close();
            } 
            catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }
     
     
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
    