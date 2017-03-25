package DAO;

import Model.Login;
import Model.PerfilDeAcesso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Util.Conexao;


public class DAOUsuario {
 
    private Login login;
    
    private static final String CADASTRAR_USUARIO = "INSERT INTO Usuario (Login, senha, Tipo) VALUES (?,?,?)";
    private static final String AUTENTICAR_USUARIO = "SELECT * FROM Usuario WHERE Login=? AND senha=?";

    //Construtor
    public void setUsuario(Login login) {
        this.login = login;
    }
    
     public void cadastraNovoUsuario(Login login) {
    Connection conexao = null;
    PreparedStatement pstmt = null;
    
    try {
        conexao = Conexao.getConexao();
        pstmt = conexao.prepareStatement(CADASTRAR_USUARIO);
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
            } catch (SQLException ex) {
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
    