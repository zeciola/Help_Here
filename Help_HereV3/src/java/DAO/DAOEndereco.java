package DAO;

import Command.*;
import Control.*;
import Model.*;
import DAO.*;
import Util.*;
import java.sql.Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOEndereco implements iDAO {

    //Variavel tipo de metodo
    private String classTipo;
    //Endereço
    public Endereco en;
    //Variable connection
    private final Connection conexao = Conexao.getConexao();

    //SQL inputs
    private static final String INSERT = "insert into endereco (cep, NomeLogradouro, Numero, Bairro, Municipio, UF, pais) values(?,?,?,?,?,?,?)";
    //private static final String UPDATE = "UPDATE Endereco SET cep=2222, nomelogradouro='TesteUp', numero=456, bairro='TesteUpBairro', municipio='Mogi das Cruzes', uf='SP', pais='Brasil' WHERE id=;";
    private static final String SELECT_ALL = "select * from endereco";
    private static final String SELECT_ID = "select * from endereco where id=?";

    //set model
    public void setEndereco(Endereco en) {
        this.en = en;
    }

    //DAO Metodos
    @Override
    public void Inserir() {
        try {

            conexao.setAutoCommit(false);

            //PreparedStatement INSERT - RETURN_GENERATED_KEYS por que recebe a id do banco
            PreparedStatement pstmt = conexao.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, en.getCep());

            pstmt.setString(2, en.getNomelogradouro());

            pstmt.setInt(3, en.getNumeroen());

            pstmt.setString(4, en.getBairro());

            pstmt.setString(5, en.getMunicipio());

            pstmt.setString(6, en.getEstado());

            pstmt.setString(7, en.getPais());

            pstmt.executeUpdate();
            // Fim da pstmt insert

            //Resultset para id
            ResultSet rs = pstmt.getGeneratedKeys();

            //rs.next();
            if (rs.next()) {
                en.setIdEndereco(rs.getInt("ID"));
                conexao.commit();
            }

            //Fim da busca
        } // Verifica se a conexao foi fechada
        catch (SQLException e) {
            try {
                conexao.rollback();

            } catch (SQLException ex) {
                Logger.getLogger(DAOEndereco.class.getName()).log(Level.SEVERE, null, ex);
            }
            Logger.getLogger(Endereco.class.getName()).
                    log(Level.SEVERE, "Erro ao cadastrar: " + e.getMessage());
        } finally {
            //4
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAOEndereco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void Atualizar(String Antemail) {
        try {

            conexao.setAutoCommit(false);
            
            String sqlUpdate = "UPDATE Endereco SET cep=?, nomelogradouro=?, numero=?, bairro=?, municipio=?, uf=?, pais=? WHERE email="+Antemail+";";
            //PreparedStatement INSERT - RETURN_GENERATED_KEYS por que recebe a id do banco
            PreparedStatement pstmt = conexao.prepareStatement(sqlUpdate, PreparedStatement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, en.getCep());

            pstmt.setString(2, en.getNomelogradouro());

            pstmt.setInt(3, en.getNumeroen());

            pstmt.setString(4, en.getBairro());

            pstmt.setString(5, en.getMunicipio());

            pstmt.setString(6, en.getEstado());

            pstmt.setString(7, en.getPais());

            pstmt.executeUpdate();
            // Fim da pstmt insert

            //Resultset para id
            ResultSet rs = pstmt.getGeneratedKeys();

            if (rs.next()) {
                en.setIdEndereco(rs.getInt("ID"));
                conexao.commit();
            }

            //Fim da busca
        } // Verifica se a conexao foi fechada
        catch (SQLException e) {
            try {
                conexao.rollback();

            } catch (SQLException ex) {
                Logger.getLogger(DAOEndereco.class.getName()).log(Level.SEVERE, null, ex);
            }
            Logger.getLogger(Endereco.class.getName()).
                    log(Level.SEVERE, "Erro ao cadastrar: " + e.getMessage());
        } finally {
            //4
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAOEndereco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void Deletar(String OBJ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList Consultar(String email) {
        ArrayList<Endereco> result = new ArrayList();
        
        try {
            String slqConsulta = "select * from Pessoa pes, Endereco ende, Usuario usu where pes.ID = ende.ID and pes.ID = usu.ID and email = '"+email+"';";
            PreparedStatement pstmt = conexao.prepareStatement(slqConsulta);

            ResultSet rs;

            rs = pstmt.executeQuery();

                while (rs.next()) {
                Endereco en = new Endereco();
                en.setIdEndereco(rs.getInt("id"));
                en.setCep(rs.getString("cep"));
                en.setNomelogradouro(rs.getString("nomelogradouro"));
                en.setNumeroen(rs.getInt("numero"));
                en.setBairro(rs.getString("bairro"));
                en.setMunicipio(rs.getString("municipio"));
                en.setEstado(rs.getString("uf"));
                en.setPais(rs.getString("pais"));

                result.add(en);

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
    public ArrayList<Endereco> Listar() {
        ArrayList<Endereco> result = new ArrayList();

        try {
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_ALL);

            ResultSet rs;

            rs = pstmt.executeQuery();

                while (rs.next()) {
                Endereco en = new Endereco();
                en.setIdEndereco(rs.getInt("id"));
                en.setCep(rs.getString("cep"));
                en.setNomelogradouro(rs.getString("nomelogradouro"));
                en.setNumeroen(rs.getInt("numero"));
                en.setBairro(rs.getString("bairro"));
                en.setMunicipio(rs.getString("municipio"));
                en.setEstado(rs.getString("uf"));
                en.setPais(rs.getString("pais"));

                result.add(en);

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
