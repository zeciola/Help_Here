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
import static jdk.nashorn.internal.objects.NativeMath.log;

public class DAOEndereco /*implements iDAO*/ {

    

    //SQL inputs
    private static final String INSERT = "insert into Endereco (cep, NomeLogradouro, Numero, Bairro, Municipio, UF, pais) values(?,?,?,?,?,?,?)";
    //private static final String UPDATE = "UPDATE Endereco SET cep=2222, nomelogradouro='TesteUp', numero=456, bairro='TesteUpBairro', municipio='Mogi das Cruzes', uf='SP', pais='Brasil' WHERE id=;";
    private static final String SELECT_ALL = "select * from endereco where status=true";
    private static final String SELECT_ID = "select * from endereco where id=?";
    private static final Connection conexao = Conexao.getConexao();

    //DAO Metodos
    //@Override
    public void Inserir(Endereco en) {
        Connection conexao = Conexao.getConexao();
        try {
            
            

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
    
    public void InserirEndInst(Endereco in) {
        Connection conexao = null;
        
        try{
           conexao = Conexao.getConexao();
            //PreparedStatement INSERT - RETURN_GENERATED_KEYS por que recebe a id do banco
            conexao.setAutoCommit(false);
            
           String sqlEndereco = "insert into EnderecoInstituicao (cep, NomeLogradouro, Numero, Bairro, Municipio, UF, pais, status) values(?,?,?,?,?,?,?,true)";
                   
           PreparedStatement pstmt = conexao.prepareStatement(sqlEndereco, PreparedStatement.RETURN_GENERATED_KEYS);
           
            pstmt.setString(1, in.getCep());
            
            pstmt.setString(2, in.getNomelogradouro());
            
            pstmt.setInt(3, in.getNumeroen());
            
            pstmt.setString(4, in.getBairro());
            
            pstmt.setString(5, in.getMunicipio());
            
            pstmt.setString(6, in.getEstado());
            
            pstmt.setString(7, in.getPais());
            
            pstmt.execute();
            
            
           ResultSet rs = pstmt.getGeneratedKeys();

            //rs.next();
            if (rs.next()) {
                in.setIdEndereco(rs.getInt("ID"));
                conexao.commit();
            }
           
            
            
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
    public void Atualizar(Endereco en) throws SQLException {

        try {

            int id = en.getIdEndereco();
            int rsid;

            conexao.setAutoCommit(false);

            String sqlEndereco = "UPDATE Endereco SET cep=?, nomelogradouro=?, numero=?, bairro=?, municipio=?, uf=?, pais=? WHERE id=" + id + ";";

            PreparedStatement pstmt = conexao.prepareStatement(sqlEndereco, PreparedStatement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, en.getCep());
            pstmt.setString(2, en.getNomelogradouro());
            pstmt.setInt(3, en.getNumeroen());
            pstmt.setString(4, en.getBairro());
            pstmt.setString(5, en.getMunicipio());
            pstmt.setString(6, en.getEstado());
            pstmt.setString(7, en.getPais());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();

            rs.next();
            rsid = rs.getInt("ID");

            if (rs.next()) {
                //IF que Verifica a integridade do ID
                if (id == rsid) {
                    en.getPe().setId(id);
                    en.setIdEndereco(rs.getInt("ID"));
                    conexao.commit();
                }
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
    public void AtualizarEnInst(Endereco in) {
        
        int id =0; 
        id = in.getIdEndereco();
        
        try {
            String sqlEndereco = "UPDATE EnderecoInstituicao  SET cep=?, NomeLogradouro=?, Numero=?, Bairro=?, Municipio=?, UF=?, pais=?, Status=? WHERE ID="+id+";"; 
                    
            PreparedStatement pstmt = conexao.prepareStatement(sqlEndereco); 
      
            
            pstmt.setString(1, in.getCep());
            
            pstmt.setString(2, in.getNomelogradouro());
            
            pstmt.setInt(3, in.getNumeroen());
            
            pstmt.setString(4, in.getBairro());
            
            pstmt.setString(5, in.getMunicipio());
            
            pstmt.setString(6, in.getEstado());
            
            pstmt.setString(7, in.getPais());
            
            pstmt.setBoolean(8, in.isStatus());
            
            
            
            pstmt.executeUpdate();
           
            conexao.commit();
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

//@Override
    public void Deletar(Endereco en) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    public ArrayList Consultar(Endereco en) {
        ArrayList<Endereco> result = new ArrayList();

        try {
            String slqConsulta = "select * from Pessoa pes, Endereco ende, Usuario usu where pes.status=true and ende.status=true and usu.status=true and pes.ID = ende.ID and pes.ID = usu.ID and email = '" +en.getPe().getEmail()+ "';";
            PreparedStatement pstmt = conexao.prepareStatement(slqConsulta);

            ResultSet rs;

            rs = pstmt.executeQuery();

            while (rs.next()) {
                en.setIdEndereco(rs.getInt("id"));
                en.setCep(rs.getString("cep"));
                en.setNomelogradouro(rs.getString("nomelogradouro"));
                en.setNumeroen(rs.getInt("numero"));
                en.setBairro(rs.getString("bairro"));
                en.setMunicipio(rs.getString("municipio"));
                en.setEstado(rs.getString("uf"));
                en.setPais(rs.getString("pais"));
                en.setStatus(rs.getBoolean("status"));

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

    //@Override
    public ArrayList<Endereco> Listar() {
        ArrayList<Endereco> result = new ArrayList();
        Endereco en = new Endereco();
        try {
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_ALL);

            ResultSet rs;

            rs = pstmt.executeQuery();

            while (rs.next()) {
                en.setIdEndereco(rs.getInt("id"));
                en.setCep(rs.getString("cep"));
                en.setNomelogradouro(rs.getString("nomelogradouro"));
                en.setNumeroen(rs.getInt("numero"));
                en.setBairro(rs.getString("bairro"));
                en.setMunicipio(rs.getString("municipio"));
                en.setEstado(rs.getString("uf"));
                en.setPais(rs.getString("pais"));
                en.setStatus(rs.getBoolean("status"));

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
