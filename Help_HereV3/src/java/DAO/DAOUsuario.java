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

public class DAOUsuario /*implements iDAO*/ {

    //Variaveis comuns ou tipo defalt
    //private String defalt = "comum";
    //Variaveis de chamada
    public Usuario lo;
    public Pessoa pe;
    public Endereco en;
    //Variable connection
    private final Connection conexao = Conexao.getConexao();

    private static final String INSERT = "INSERT INTO Usuario (IDPessoa ,Tipo , Login, senha, status) VALUES (?,?,?,?,?)";
    private static final String AUTENTICAR_USUARIO = "SELECT * FROM Usuario WHERE status=true and Login=? AND senha=?";
    private static final String SELECT_ALL = "select * from Usuario where status=true";

    public void cadastraNovoUsuario(Usuario login) throws SQLException {
        Connection conexao = null;

    }

    //@Override
    public void Inserir(Usuario lo) {
        try {
            conexao.setAutoCommit(false);

            //PreparedStatement INSERT - RETURN_GENERATED_KEYS por que recebe a id do banco
            PreparedStatement pstmt = conexao.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);

            pstmt.setInt(1, lo.getPe().getId());
            pstmt.setString(2, lo.getPerfil().toString());
            pstmt.setString(3, lo.getNome());
            pstmt.setString(4, lo.getSenha());
            pstmt.setBoolean(5, lo.isStatus());

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
            Logger.getLogger(Usuario.class.getName()).
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

    //@Override
    public void Atualizar(String Email, String Senha, Usuario lo) {
        try {
            conexao.setAutoCommit(false);

            String sqlUsuario = "UPDATE Usuario SET login=?, senha=? where login='" + Email + "' and senha='" + Senha + "';";

            //PreparedStatement INSERT - RETURN_GENERATED_KEYS por que recebe a id do banco
            PreparedStatement pst = conexao.prepareStatement(sqlUsuario, PreparedStatement.RETURN_GENERATED_KEYS);

            pst.setString(1, lo.getNome());
            pst.setString(2, lo.getSenha());

            pst.executeUpdate();

            //Fim do pstmt inserir
            ResultSet rs = pst.getGeneratedKeys();

            rs.next();
            int id = rs.getInt("ID");
            
            lo.setId(id);
            lo.getPe().setId(id);
            lo.getEn().setIdEndereco(id);

            //Endereco
            String sqlEndereco = "UPDATE Endereco SET cep=?, nomelogradouro=?, numero=?, bairro=?, municipio=?, uf=?, pais=? WHERE id=" + id + ";";

            PreparedStatement pstm = conexao.prepareStatement(sqlEndereco, PreparedStatement.RETURN_GENERATED_KEYS);

            pstm.setString(1, en.getCep());

            pstm.setString(2, en.getNomelogradouro());

            pstm.setInt(3, en.getNumeroen());

            pstm.setString(4, en.getBairro());

            pstm.setString(5, en.getMunicipio());

            pstm.setString(6, en.getEstado());

            pstm.setString(7, en.getPais());

            pstm.executeUpdate();
            //Endereco
            
            //Pessoa
            String sqlPessoa = "UPDATE Pessoa SET nome=?, sobrenome=?, cpf=?, rg=?, datanascimento=?, email=?, telefone=?, celular=?, sexo=? where id=" + id + ";";

            PreparedStatement pstmt = conexao.prepareStatement(sqlPessoa, PreparedStatement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, pe.getNome());

            pstmt.setString(2, pe.getSobrenome());

            pstmt.setString(3, pe.getCpf());

            pstmt.setString(4, pe.getRg());

            //pstmt.setBoolean(5, pe.isPenalisado());
            pstmt.setString(5, pe.getDatanascimento());

            pstmt.setString(6, pe.getEmail());

            //Foreign Key
            //pstmt.setInt(8, en.getIdEndereco());
            pstmt.setString(7, pe.getTelefone());

            pstmt.setString(8, pe.getCelular());

            pstmt.setString(9, pe.getSexo());

            pstmt.executeUpdate();

            //Pessoa
            
            conexao.commit();

        } // Verifica se a conexao foi fechada
        catch (SQLException e) {
            try {
                conexao.rollback();

            } catch (SQLException ex) {
                Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            Logger.getLogger(Usuario.class.getName()).
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

    //@Override
    public void Deletar(String Email, String Senha, Usuario lo) {
        try {
            conexao.setAutoCommit(false);

            String sqlUsuario = "UPDATE Usuario SET status = false where login='" + Email + "' and senha='" + Senha + "';";

            //PreparedStatement INSERT - RETURN_GENERATED_KEYS por que recebe a id do banco
            PreparedStatement pst = conexao.prepareStatement(sqlUsuario, PreparedStatement.RETURN_GENERATED_KEYS);

            pst.executeUpdate();

            //Fim do pstmt inserir
            ResultSet rs = pst.getGeneratedKeys();

            rs.next();
            int id = rs.getInt("ID");

            String sqlEndereco = "UPDATE Endereco SET status = false WHERE id=" + id + ";";

            PreparedStatement pstm = conexao.prepareStatement(sqlEndereco, PreparedStatement.RETURN_GENERATED_KEYS);

            pstm.executeUpdate();

            String sqlPessoa = "UPDATE Pessoa SET status = false where id=" + id + ";";

            PreparedStatement pstmt = conexao.prepareStatement(sqlPessoa, PreparedStatement.RETURN_GENERATED_KEYS);

            pstmt.executeUpdate();

            conexao.commit();

        } // Verifica se a conexao foi fechada
        catch (SQLException e) {
            try {
                conexao.rollback();

            } catch (SQLException ex) {
                Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            Logger.getLogger(Usuario.class.getName()).
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

    //@Override
    public ArrayList Consultar(String email, Usuario u) {
        ArrayList<Usuario> result = new ArrayList();

        try {
            String slqConsulta = "select * from Pessoa pes, Endereco ende, Usuario usu where pes.status=true and ende.status=true and usu.status=true and pes.ID = ende.ID and pes.ID = usu.ID and email = '" + email + "';";
            PreparedStatement pstmt = conexao.prepareStatement(slqConsulta);

            ResultSet rs;

            rs = pstmt.executeQuery();

            while (rs.next()) {
                Usuario lo = new Usuario();
                lo.setId(rs.getInt("ID"));
                lo.setNome(rs.getString("Tipo"));

                // Usuario = Nome = Email
                lo.setNome(rs.getString("Login"));
                lo.setSenha(rs.getString("senha"));
                lo.setStatus(rs.getBoolean("status"));

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

    //@Override
    public ArrayList<Usuario> Listar(ArrayList<Usuario> result, Usuario lo) {

        try {
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_ALL);

            ResultSet rs;

            rs = pstmt.executeQuery();

            while (rs.next()) {
                lo.setId(rs.getInt("ID"));
                lo.setNome(rs.getString("Tipo"));

                // Usuario = Nome = Email
                lo.setNome(rs.getString("Login"));
                lo.setSenha(rs.getString("senha"));
                lo.setStatus(rs.getBoolean("status"));

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

    public Usuario ConsultarId(int id) {
        Pessoa pe = new Pessoa();
        Usuario U = new Usuario();
        try {
            PreparedStatement pstmt = conexao.prepareStatement("select p.id, p.nome, p.sobrenome, p.cpf, p.rg, p.datanascimento, p.email, p.telefone, p.celular, p.sexo, p.status, p.penalisado, p.contador from usuario u, pessoa p where u.id=? and p.id = u.idpessoa");
            pstmt.setInt(1, id);
            ResultSet rs;

            rs = pstmt.executeQuery();

            while (rs.next()) {
                pe.setId(rs.getInt("ID"));
                pe.setNome(rs.getString("Nome"));
                pe.setSobrenome(rs.getString("Sobrenome"));
                pe.setCpf(rs.getString("CPF"));
                pe.setRg(rs.getString("RG"));
                pe.setPenalisado(rs.getBoolean("Penalisado"));
                pe.setDatanascimento(rs.getString("Datanascimento"));
                pe.setEmail(rs.getString("email"));
                pe.setTelefone(rs.getString("Telefone"));
                pe.setCelular(rs.getString("celular"));
                pe.setSexo(rs.getString("sexo"));
                pe.setStatus(rs.getBoolean("status"));
                pe.setContador(rs.getInt("contador"));
                U.setPe(pe);
            }
            //Retorno do ArrayList
            return U;

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
    public Usuario autenticaUsuario(Usuario login) {
        Usuario loginAutenticado = null;

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
                loginAutenticado = new Usuario();
                loginAutenticado.setId(rsLogin.getInt("id"));
                loginAutenticado.setNome(rsLogin.getString("login"));
                loginAutenticado.setSenha(rsLogin.getString("senha"));
                loginAutenticado.setPerfil(PerfilDeAcesso.valueOf(rsLogin.getString("tipo")));
                loginAutenticado.setStatus(rsLogin.getBoolean("status"));
                
                Pessoa p = new Pessoa();
                p.setId(rsLogin.getInt("idpessoa"));
                     

                loginAutenticado.setPe(p);
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
    
    
    public Usuario autenticaID(Usuario login) {
        Usuario loginAutenticado = null;

        Connection conexao = null;
        PreparedStatement pstmt = null;
        ResultSet rsLogin = null;
        try {
            conexao = Conexao.getConexao();
            String sqlConsulta = "select * from Usuario where id ="+login.getId();
            pstmt = conexao.prepareStatement(sqlConsulta);
            
            rsLogin = pstmt.executeQuery();

            if (rsLogin.next()) {
                loginAutenticado = new Usuario();
                loginAutenticado.setId(rsLogin.getInt("id"));
                loginAutenticado.setNome(rsLogin.getString("login"));
                loginAutenticado.setSenha(rsLogin.getString("senha"));
                loginAutenticado.setPerfil(PerfilDeAcesso.valueOf(rsLogin.getString("tipo")));
                loginAutenticado.setStatus(rsLogin.getBoolean("status"));
                
                Pessoa p = new Pessoa();
                p.setId(rsLogin.getInt("idpessoa"));
                     

                loginAutenticado.setPe(p);
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
