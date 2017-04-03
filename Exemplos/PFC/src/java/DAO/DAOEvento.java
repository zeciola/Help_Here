/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Endereco;
import Modelo.Evento;
import Modelo.Pessoa;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.Conecta;
/**
 *
 * @author Diego
 */
public class DAOEvento implements InterfaceDAO{
    private Evento evento;
    private Connection conexao;
    private static final String INSERIR_END ="insert into evenendereco values(?,?)";
    private static final String INSERIR_RESP ="insert into evenpessoa values (?,?)";
    private static final String LISTAR ="select * from evento where status = true";
    private static final String LISTAR2 ="select * from evento";
    private static final String LISTAR_ID ="select * from evento where status = true and id=?";
    private static final String UPDATE ="update evento set nome=?, descricao=?, datacadastro=?, datainicio=?, datafim=?, tipo=? where id=?";
    private static final String DELETE ="update evento set status = false where id=?";
    private static final String INSERIR ="insert into evento(nome, descricao, datacadastro, datainicio, datafim, tipo)values(?,?,?,?,?,?)";
    private static final String ATIVAR ="update evento set status = true where id=?";
    private static final String DESATIVAR ="update evento set status = false where id=?";
    
    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    @Override
    public void Inserir() {
       try{
        conexao = Conecta.getConexao();
        conexao.setAutoCommit(false);
        PreparedStatement pstmt = conexao.prepareStatement(INSERIR, PreparedStatement.RETURN_GENERATED_KEYS);
        pstmt.setString(1, evento.getNome());
        pstmt.setString(2, evento.getDescricao());
        pstmt.setDate(3, (Date) evento.getDataCad());
        pstmt.setDate(4, (Date) evento.getInicio());
        pstmt.setDate(5, (Date) evento.getDataFim());
        pstmt.setString(6, "doação");
        pstmt.execute();
        ResultSet rsId = pstmt.getGeneratedKeys();
            if(rsId.next()){
                evento.setId(rsId.getInt("id"));
                conexao.commit();
            }
       }catch (SQLException e) {
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
    public void Atualizar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void Deletar() {
       conexao = Conecta.getConexao();
       try{ 
       PreparedStatement pstmt = conexao.prepareStatement(DELETE);
        pstmt.setInt(1, evento.getId());
        pstmt.execute();
       }catch (SQLException e) {
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
    public ArrayList Consultar() {
        ArrayList<Evento> resul = new ArrayList();
        try{
            conexao = Conecta.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(LISTAR_ID);
            pstmt.setInt(1, evento.getId());
            ResultSet rs;
            rs=pstmt.executeQuery();
            while (rs.next()){
                 Evento e = new Evento();
                 e.setId(rs.getInt("id"));
                 e.setNome(rs.getString("nome"));
                 e.setDescricao(rs.getString("descricao"));
                 e.setDataCad(rs.getDate("datacadastro"));
                 e.setInicio(rs.getDate("datainicio"));
                 e.setDataFim(rs.getDate("datafim"));
                 resul.add(e);
             }
             return resul;
        }catch(SQLException e){
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
    public ArrayList Listar() {
        ArrayList<Evento> resul = new ArrayList();
        try{
            conexao = Conecta.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(LISTAR);
            ResultSet rs;
            rs = pstmt.executeQuery();
             while (rs.next()){
                 Evento e = new Evento();
                 e.setId(rs.getInt("id"));
                 e.setNome(rs.getString("nome"));
                 e.setDescricao(rs.getString("descricao"));
                 e.setDataCad(rs.getDate("datacadastro"));
                 e.setInicio(rs.getDate("datainicio"));
                 e.setDataFim(rs.getDate("datafim"));
                 resul.add(e);
             }
             return resul;
        }catch(SQLException e){
            throw new RuntimeException(e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void InserirRP(Pessoa p){
       try{
        conexao = Conecta.getConexao();
        conexao.setAutoCommit(false);
        PreparedStatement pstmt = conexao.prepareStatement(INSERIR_RESP);
        pstmt.setInt(1, p.getId());
        pstmt.setInt(2, evento.getId());
        pstmt.execute();
       }catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void InserirRe(Endereco p){
       try{
        conexao = Conecta.getConexao();
        conexao.setAutoCommit(false);
        PreparedStatement pstmt = conexao.prepareStatement(INSERIR_END);
        pstmt.setInt(1, evento.getId());
        pstmt.setInt(2, p.getId());
        pstmt.execute();
       }catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
       public void Ativar() {
       conexao = Conecta.getConexao();
       try{ 
       PreparedStatement pstmt = conexao.prepareStatement(ATIVAR);
        pstmt.setInt(1, evento.getId());
        pstmt.execute();
       }catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void Desativar() {
       conexao = Conecta.getConexao();
       try{ 
       PreparedStatement pstmt = conexao.prepareStatement(DESATIVAR);
        pstmt.setInt(1, evento.getId());
        pstmt.execute();
       }catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    
        public ArrayList Listar2() {
        ArrayList<Evento> resul = new ArrayList();
        try{
            conexao = Conecta.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(LISTAR2);
            ResultSet rs;
            rs = pstmt.executeQuery();
             while (rs.next()){
                 Evento e = new Evento();
                 e.setId(rs.getInt("id"));
                 e.setNome(rs.getString("nome"));
                 e.setDescricao(rs.getString("descricao"));
                 e.setDataCad(rs.getDate("datacadastro"));
                 e.setInicio(rs.getDate("datainicio"));
                 e.setDataFim(rs.getDate("datafim"));
                 resul.add(e);
             }
             return resul;
        }catch(SQLException e){
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
