/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Endereco;
import Model.Instituicao;
import Util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author 11141104689
 */
public class DAOInstituicao implements iDAO{
    
     public boolean inserir(Instituicao obj) throws SQLException {
        //os dados estão atribuidos aos atributos do objeto que foi passado para o método em questão
        // desta forma devemos criar um preparação para o comando SQL
        Connection con = null;
        PreparedStatement pst = null;
        Statement st_valor = null;
        ResultSet valor_idCliente = null;

        con = Conexao.getConexao();

        try {

            con.setAutoCommit(false);
            String stm = "INSERT INTO Instituicao(nome, razaoSocial, tipo, CNPJ, modalidade) VALUES(?, ?, ?, ?, ?)";
            pst = con.prepareStatement(stm);

            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getRazao());
            pst.setString(3, obj.getTipo());
            pst.setString(3, obj.getCnpj());
            pst.setString(3, obj.getModalidade());

            pst.executeUpdate();

            String stm_valor_idInstituicao = "SELECT currval('Instituicao_id_seq')"; //prepara para recuperar o valor atual da sequence

            st_valor = con.createStatement();
            valor_idCliente = st_valor.executeQuery(stm_valor_idInstituicao);

            if (valor_idCliente.next()) {
                obj.setIdInstituicao(valor_idCliente.getInt(1)); //recupera o valor atual da sequence
            }

            con.commit();
            con.close();
            return true;

        } catch (Exception e) {

            con.rollback();
            con.close();
            return false;
        }
    }
    
    public Instituicao consultar(Instituicao obj) throws SQLException {

        Connection con = null;

        Statement st = null;
        ResultSet rsUsuario = null;

        Instituicao instituicao = new Instituicao();
        

        con = Conexao.getConexao();

        try {

            String stm = "select * from Instituicao I, Endereco E WHERE i.id = E.id AND I.id = " + obj.getIdInstituicao() + ";";

            st = con.createStatement();
            rsUsuario = st.executeQuery(stm);

            while (rsUsuario.next()) {

                instituicao.setIdInstituicao(rsUsuario.getInt("id"));
                instituicao.setNome(rsUsuario.getString("nome"));
                instituicao.setRazao(rsUsuario.getString("razaoSocial"));
                instituicao.setTipo(rsUsuario.getString("tipo"));
                instituicao.setCnpj(rsUsuario.getString("CNPJ"));
                instituicao.setModalidade(rsUsuario.getString("modalidade"));
                instituicao.setEndereco((ArrayList<Endereco>) rsUsuario.getArray("Cep, NomeLogradouro, Numero, Bairro, Municipio, Estado, Pais"));
            }

        } catch (Exception e) {
            //nada para fazer
            con.close();
        }
        con.close();
        return instituicao;
    }
    
    
    public ArrayList<Instituicao> listar() throws SQLException {

        Connection con = null;

        Statement st = null;
        ResultSet rsUsuario = null;

        ArrayList<Instituicao> arrayInstituicao = new ArrayList<Instituicao>();

        con = Conexao.getConexao();

        try {

            String stm = "select * from Instituicao i, Endereco e where i.id = e.id;";

            st = con.createStatement();
            rsUsuario = st.executeQuery(stm);

            while (rsUsuario.next()) {

                arrayInstituicao.add(new Instituicao(rsUsuario.getInt("id"), rsUsuario.getString("nome"), rsUsuario.getString("razaoSocial"), rsUsuario.getString("tipo"), rsUsuario.getString("CNPJ"), rsUsuario.getString("Modalidade"), rsUsuario.getString("Cep"), rsUsuario.getString("NomeLogradouro"), rsUsuario.getString("Numero"), rsUsuario.getString("Bairro"), rsUsuario.getString("Municipio"), rsUsuario.getString("Rstado"), rsUsuario.getString("Pais")));

            }

        } catch (Exception e) {

            //nada para fazer
            con.close();
        }
        con.close();
        return arrayInstituicao;
        
    }
    

        public boolean alterar(Instituicao obj) throws SQLException {
        //os dados estão atribuidos aos atributos do objeto que foi passado para o método em questão
        // desta forma devemos criar um preparação para o comando SQL
        Connection con = null;
        PreparedStatement pst = null;
        Statement st_valor = null;
        ResultSet valor_idInstituicao = null;

        con = Conexao.getConexao();

        try {

            con.setAutoCommit(false);

            String stm = "UPDATE Instituicao SET nome=?, razaoSocial=?, tipo=?, CNPJ=?, modalidade=? WHERE id=" + obj.getIdInstituicao() + ";";

            pst = con.prepareStatement(stm);

            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getRazao());
            pst.setString(2, obj.getTipo());
            pst.setString(2, obj.getCnpj());
            pst.setString(2, obj.getModalidade());

            pst.executeUpdate();

            String stm_valor_idInst = "SELECT id FROM Instituicao WHERE id=" + obj.getIdInstituicao() + ";"; //prepara para recuperar o valor atual da sequence

            st_valor = con.createStatement();
            valor_idInstituicao = st_valor.executeQuery(stm_valor_idInst);

            if (valor_idInstituicao.next()) {
                obj.setIdInstituicao(valor_idInstituicao.getInt(1)); //recupera
            }

            con.commit();
            con.close();
            return true;

        } catch (Exception e) {

            con.rollback();
            con.close();
            return false;
        }
    }
    
        
    
    public boolean excluir(Instituicao obj) throws SQLException {

        //os dados estão atribuidos aos atributos do objeto que foi passado para o método em questão
        // desta forma devemos criar um preparação para o comando SQL
        Connection con = null;
        PreparedStatement pst = null;

        con = Conexao.getConexao();

        try {

            con.setAutoCommit(false);
            String stm = "delete from Instituicao where id=?;";

            pst = con.prepareStatement(stm);

            pst.setInt(1, obj.getIdInstituicao());

            pst.executeUpdate();

            con.commit();
            con.close();
            return true;

        } catch (Exception e) {

            con.rollback();
            con.close();
            return false;
        }
    }

    
    
    @Override
    public void Inserir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
}
