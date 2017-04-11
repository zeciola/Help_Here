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

public class DAOPessoa implements iDAO {

    public Pessoa pe;
    public Endereco en;
    
    public String emailpes;

    //Variable connection
    private final Connection conexao = Conexao.getConexao();

    // defalt variabel Penalisado = false
    private boolean defalt;

    //SET Pessoa
    public void setPessoa(Pessoa pe) {
        this.pe = pe;
    }

    // SET Endereco
    public void setEndereco(Endereco en) {
        this.en = en;
    }

    //SQL
    private static final String INSERT = "insert into Pessoa (Nome, Sobrenome, CPF, RG, Penalisado, Datanascimento, email, IDEndereco, Telefone, celular, sexo) "
            + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String DELETE = "update pessoa set";

    private static final String SELECT_ALL = "select * from Pessoa";

    private static final String UPDATE = "";

    //DAOs
    @Override
    public void Inserir() {
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
            pstmt.setInt(8, en.getIdEndereco());

            pstmt.setString(9, pe.getTelefone());

            pstmt.setString(10, pe.getCelular());

            pstmt.setString(11, pe.getSexo());

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
        ArrayList<Pessoa> result = new ArrayList();
        
        try {
            String slqConsulta = "select * from Pessoa pes, Endereco ende, Usuario usu where pes.ID = ende.ID and pes.ID = usu.ID and email = '"+email+"';";
            PreparedStatement pstmt = conexao.prepareStatement(slqConsulta);

            ResultSet rs;

            rs = pstmt.executeQuery();

            while (rs.next()) {
                Pessoa pe = new Pessoa();
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

    @Override
    public ArrayList<Pessoa> Listar() {

        ArrayList<Pessoa> result = new ArrayList();

        try {
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_ALL);

            ResultSet rs;

            rs = pstmt.executeQuery();

            while (rs.next()) {
                Pessoa pe = new Pessoa();
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

}
