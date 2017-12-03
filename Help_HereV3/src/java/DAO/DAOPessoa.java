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
import java.util.logging.Level;
import java.util.logging.Logger;
import static jdk.nashorn.internal.objects.NativeMath.log;

public class DAOPessoa /*implements iDAO*/ {

    

    //Variable connection
    private final Connection conexao = Conexao.getConexao();

    // defalt variabel Penalisado = false
    

    //SQL
    private static final String INSERT = "insert into Pessoa (Nome, Sobrenome, CPF, RG, Penalisado, Datanascimento, email, IDEndereco, Telefone, celular, sexo, status, contador) "
            + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String INSERT_INTERESSE = "insert into Interesses (IDUsuario, Interesse)values(? , ?)";

    private static final String DELETE = "update pessoa set";

    private static final String SELECT_ALL = "select * from Pessoa where status=true";

    private static final String AUTENTICAR_PESSOA = "SELECT * FROM Usuario WHERE Login=? AND senha=?;";

    private static final String UPDATE = "";

    //DAOs
    //@Override
    public void Inserir(Pessoa pe) {
        try {

            conexao.setAutoCommit(false);

            //PreparedStatement INSERT - RETURN_GENERATED_KEYS por que recebe a id do banco
            PreparedStatement pstmt = conexao.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, pe.getNome());

            pstmt.setString(2, pe.getSobrenome());

            pstmt.setString(3, pe.getCpf());

            pstmt.setString(4, pe.getRg());

            pstmt.setBoolean(5, pe.isPenalisado());

            pstmt.setString(6, pe.getDatanascimento());

            pstmt.setString(7, pe.getEmail());

            //Foreign Key
            pstmt.setInt(8, pe.getEn().getIdEndereco());

            pstmt.setString(9, pe.getTelefone());

            pstmt.setString(10, pe.getCelular());

            pstmt.setString(11, pe.getSexo());

            //status
            pstmt.setBoolean(12, pe.isStatus());

            pstmt.setInt(13, pe.getContador());

            pstmt.executeUpdate();

            //Fim do pstmt inserir
            ResultSet rs = pstmt.getGeneratedKeys();

            if (rs.next()) {
                pe.setId(rs.getInt("ID"));
                conexao.commit();
            }

            //conexao.commit();
        } // Verifica se a conexao foi fechada
        catch (SQLException e) {
            try {
                conexao.rollback();

            } catch (SQLException ex) {
                Logger.getLogger(DAOPessoa.class.getName()).log(Level.SEVERE, null, ex);
            }
            Logger.getLogger(Pessoa.class.getName()).
                    log(Level.SEVERE, "Erro ao cadastrar: " + e.getMessage());
        } finally {
            //4
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAOPessoa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

   
    //@Override
    public void Atualizar(Pessoa pe) {
        try {

            int id = pe.getId();
            int rsid;

            conexao.setAutoCommit(false);

            //PreparedStatement INSERT - RETURN_GENERATED_KEYS por que recebe a id do banco
            String sqlConsultar = "UPDATE Pessoa SET nome=?, sobrenome=?, cpf=?, rg=?, datanascimento=?, email=?, telefone=?, celular=?, sexo=? where id=" + id + ";";

            PreparedStatement pstmt = conexao.prepareStatement(sqlConsultar, PreparedStatement.RETURN_GENERATED_KEYS);

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

            //Fim do pstmt inserir
            ResultSet rs = pstmt.getGeneratedKeys();

            rsid = rs.getInt("ID");

            if (rs.next()) {
                if (id == rsid) {
                    pe.getEn().setIdEndereco(id);
                    pe.setId(rs.getInt("ID"));
                    conexao.commit();
                }
            }

            //conexao.commit();
        } // Verifica se a conexao foi fechada
        catch (SQLException e) {
            try {
                conexao.rollback();

            } catch (SQLException ex) {
                Logger.getLogger(DAOPessoa.class.getName()).log(Level.SEVERE, null, ex);
            }
            Logger.getLogger(Pessoa.class.getName()).
                    log(Level.SEVERE, "Erro ao cadastrar: " + e.getMessage());
        } finally {
            //4
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAOPessoa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    //@Override
    public void Deletar(Pessoa pe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    public ArrayList Consultar(Pessoa pe) {
        ArrayList<Pessoa> result = new ArrayList();

        try {
            String slqConsulta = "select * from Pessoa pes, Endereco ende, Usuario usu where pes.status=true and ende.status=true and usu.status=true and pes.ID = ende.ID and pes.ID = usu.ID and email = '" + pe.getEmail() + "';";
            PreparedStatement pstmt = conexao.prepareStatement(slqConsulta);

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

                result.add(pe);

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

    public void AtualizarContadorP(Pessoa obj) {
        Connection conexao = null;

        try {
            conexao = Conexao.getConexao();

            conexao.setAutoCommit(false);

            String sqlInstituicao = "UPDATE Pessoa SET  contador=" + obj.getContador() + " WHERE ID=" + obj.getId() + " ";

            PreparedStatement pst = conexao.prepareStatement(sqlInstituicao, PreparedStatement.RETURN_GENERATED_KEYS);

            pst.executeUpdate();

            conexao.commit();

        } catch (SQLException e) {
            try {
                conexao.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(DAOInstituicao.class.getName()).log(Level.SEVERE, null, ex);
            }
            Logger.getLogger(DAOInstituicao.class.getName());
            log(Level.SEVERE, "Erro ao Alterar: " + e.getMessage());
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAOInstituicao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    //@Override
    public ArrayList<Pessoa> Listar() {
        ArrayList<Pessoa> result = new ArrayList();
        Pessoa pe = new Pessoa();
        try {
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_ALL);

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

                result.add(pe); 

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

    public Pessoa ConsultarId(Usuario u) {
        Pessoa pe = new Pessoa();
        try {
            PreparedStatement pstmt = conexao.prepareStatement("select p.id, p.nome, p.sobrenome, p.cpf, p.rg, p.datanascimento, p.email, p.telefone, p.celular, p.sexo, p.status, p.penalisado, p.contador from usuario u, pessoa p where u.id="+u.getId()+" and p.id = u.idpessoa");
            pstmt.setInt(1, u.getId());
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
            }
            //Retorno do ArrayList
            return pe;

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

    public Endereco ConsultarEndPessoa(Pessoa p) {
        Endereco end = new Endereco();
        try {
            Connection conexao2 = Conexao.getConexao();
            PreparedStatement pstmt = conexao2.prepareStatement("select * from pessoa p, endereco e where p.id=? and e.id = p.idendereco");
            pstmt.setInt(1, p.getId());
            ResultSet rs;
            rs = pstmt.executeQuery();

            while (rs.next()) {
                end.setBairro(rs.getString("bairro"));
                end.setCep(rs.getString("cep"));
                end.setEstado(rs.getString("uf"));
                end.setIdEndereco(Integer.parseInt(rs.getString("id")));
                end.setMunicipio(rs.getString("municipio"));
                end.setNomelogradouro(rs.getString("nomelogradouro"));
                end.setNumeroen(rs.getInt("numero"));
                end.setPais(rs.getString("pais"));
                end.setStatus(rs.getBoolean("status"));

            }
            //Retorno do ArrayList
            return end;

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
}
