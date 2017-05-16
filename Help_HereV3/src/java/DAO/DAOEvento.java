/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Endereco;
import Model.Evento;
import Util.Conexao;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 11141104689
 */
public class DAOEvento implements iDAO{
    
    private Evento ev;

    public void setEvento(Evento ev) {
        this.ev = ev;
    }
    
    private final Connection conexao = Conexao.getConexao();
    
    private static final String INSERT = "insert into Evento (dataInicio, dataFim, nome, tipo, descricao) values(?,?,?,?,?)";

    //DAO Metodos
    @Override
    public void Inserir() {
        try {

            conexao.setAutoCommit(false);

            //PreparedStatement INSERT - RETURN_GENERATED_KEYS por que recebe a id do banco
            PreparedStatement pstmt = conexao.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, ev.getDataInicio());

            pstmt.setString(2, ev.getDataFim());

            pstmt.setString(3, ev.getNome());

            pstmt.setString(4, ev.getTipoEvento());

            pstmt.setString(5, ev.getDescricao());

           

            pstmt.executeUpdate();
            // Fim da pstmt insert

            //Resultset para id
            ResultSet rs = pstmt.getGeneratedKeys();

            //rs.next();
            if (rs.next()) {
                ev.setIdEvento(rs.getInt("ID"));
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
    public void Atualizar(String OBJ, String ob) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Deletar(String OBJ, String ob) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList Consultar(String obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList Listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void InserirAuxEnderecoEvento(int idendereco, int idvento){
        
    }
    
    public void InserirAuxInstituicaoEvento(int idinstituicao, int idvento){
        
    }
    
}
