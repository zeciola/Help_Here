/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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
            String stm = "INSERT INTO Instituicao(nome, razaoSocial, tipo, cnpj, modalidade) VALUES(?, ?, ?)";
            pst = con.prepareStatement(stm);

            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getRazao());
            pst.setString(3, obj.getTipo());
            pst.setString(3, obj.getCnpj());
            pst.setString(3, obj.getModalidade());

            pst.executeUpdate();

            String stm_valor_idInstituicao = "SELECT currval('tblcliente_idcliente_seq')"; //prepara para recuperar o valor atual da sequence

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

            String stm = "select * from Instituicao i, Endereco E WHERE i.id = E.id AND I.id = " + obj.getIdInstituicao() + ";";

            st = con.createStatement();
            rsUsuario = st.executeQuery(stm);

            while (rsUsuario.next()) {

                instituicao.setIdInstituicao(rsUsuario.getInt("id"));
                instituicao.setNome(rsUsuario.getString("nome"));
                instituicao.setRazao(rsUsuario.getString("razaoSocial"));
                instituicao.setTipo(rsUsuario.getString("tipo"));
                instituicao.setCnpj(rsUsuario.getString("cnpj"));
                instituicao.setModalidade(rsUsuario.getString("modalidade"));
            }

        } catch (Exception e) {
            //nada para fazer
            con.close();
        }
        con.close();
        return instituicao;
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
