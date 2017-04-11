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
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOUsuario implements iDAO {

    //Variaveis comuns ou tipo defalt
    //private String defalt = "comum";
    //Variaveis de chamada
    public Login lo;
    public Pessoa pe;
    //Variable connection
    private final Connection conexao = Conexao.getConexao();

    //Set Ususario
    public void setUsuario(Login lo) {
        this.lo = lo;
    }

    //Set Pessoa
    public void setPessoa(Pessoa pe) {
        this.pe = pe;
    }

    private static final String INSERT = "INSERT INTO Usuario (IDPessoa ,Tipo , Login, senha) VALUES (?,?,?,?)";
    private static final String AUTENTICAR_USUARIO = "SELECT * FROM Usuario WHERE Login=? AND senha=?";
    private static final String SELECT_ALL = "select * from Usuario";

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

            if (rs.next()) {
                lo.setId(rs.getInt("ID"));
                conexao.commit();
            }

        } // Verifica se a conexao foi fechada
        catch (SQLException e) {
            try {
                conexao.rollback();

            } catch (SQLException ex) {
                Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            Logger.getLogger(Login.class.getName()).
                    log(Level.SEVERE, "Erro ao cadastrar: " + e.getMessage());
        } finally {
            //4
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void Atualizar(String OBJ, String OB) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Deletar(String OBJ, String OB) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList Consultar(String email) {
        ArrayList<Login> result = new ArrayList();

        try {
            String slqConsulta = "select * from Pessoa pes, Endereco ende, Usuario usu where pes.ID = ende.ID and pes.ID = usu.ID and email = '"+email+"';";
            PreparedStatement pstmt = conexao.prepareStatement(slqConsulta);

            ResultSet rs;

            rs = pstmt.executeQuery();

            while (rs.next()) {
                Login lo = new Login();
                lo.setId(rs.getInt("ID"));
                lo.setNome(rs.getString("Tipo"));

                // Login = Nome = Email
                lo.setNome(rs.getString("Login"));
                lo.setSenha(rs.getString("senha"));

                result.add(lo);

            }
            //Retorno do ArrayList
            return result;

        } catch (SQLException e) {
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
    public ArrayList<Login> Listar() {
        ArrayList<Login> result = new ArrayList();

        try {
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_ALL);

            ResultSet rs;

            rs = pstmt.executeQuery();

            while (rs.next()) {
                Login lo = new Login();
                lo.setId(rs.getInt("ID"));
                lo.setNome(rs.getString("Tipo"));

                // Login = Nome = Email
                lo.setNome(rs.getString("Login"));
                lo.setSenha(rs.getString("senha"));

                result.add(lo);

            }
            //Retorno do ArrayList
            return result;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

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
