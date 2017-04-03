/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Endereco;
import Modelo.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.Conecta;

/**
 *
 * @author Diego
 */
public class DAOPessoa implements InterfaceDAO{
    
    private Pessoa pessoa;
    private Endereco e;
    private Connection conexao;
    private static final String DELETE = "update pessoa set status = false where id = ?";
    private static final String INSERT = "insert into pessoa(nome, rg, cpf, datanasci, email) values(?,?,?,?,?)";
    private static final String UPDATE = "insert into pessoa(nome, rg, cpf, datanasci) values(?,?,?,?)";
    private static final String SELECT_ALL = "SELECT * FROM pessoa where status = true";
    private static final String SELECT = "SELECT * FROM pessoa where id = ?";
    private static final String AUX ="insert into auxiliar_e_p (idendereco, idpessoa) values(?,?)";
 
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void setE(Endereco e) {
        this.e = e;
    }

    @Override
    public void Atualizar() {
        try {
            conexao = Conecta.getConexao();
            conexao.setAutoCommit(false);
            PreparedStatement pstmt = conexao.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, pessoa.getNome());
            pstmt.setString(2, pessoa.getRg());
            pstmt.setString(3, pessoa.getCpf());
            pstmt.setDate(4, pessoa.getDatanasci());
            pstmt.setString(5, pessoa.getEmail());
            pstmt.execute();
            ResultSet rsId = pstmt.getGeneratedKeys();
            if(rsId.next()){
                pessoa.setId(rsId.getInt("id"));
                conexao.commit();
            }            
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
    public void Deletar() {   
        try {
            conexao = Conecta.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(DELETE);
            pstmt.setInt(1, pessoa.getId());
            pstmt.execute();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
        try {
            conexao.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }        
    }

    @Override
    public ArrayList Consultar() {
        ArrayList<Pessoa> arrayp = new ArrayList();
        try{
            conexao = Conecta.getConexao();
             PreparedStatement pstmt = conexao.prepareStatement(SELECT);
             pstmt.setInt(1, pessoa.getId());
             ResultSet rs;
             rs = pstmt.executeQuery();
             while (rs.next()){
                 Pessoa novapessoa = new Pessoa();
                 novapessoa.setCpf(rs.getString("cpf"));
                 novapessoa.setDatanasci(rs.getDate("datanasci"));
                 novapessoa.setNome(rs.getString("nome"));
                 novapessoa.setRg(rs.getString("rg"));
                 novapessoa.setId(rs.getInt("id"));
                 novapessoa.setEmail(rs.getString("email"));
                 arrayp.add(novapessoa);
             }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return arrayp;
    }

    @Override
    public ArrayList Listar() {
        ArrayList<Pessoa> arrayp = new ArrayList();
        try{
            conexao = Conecta.getConexao();
             PreparedStatement pstmt = conexao.prepareStatement(SELECT_ALL);
             ResultSet rs;
             rs = pstmt.executeQuery();
             while (rs.next()){
                 Pessoa novapessoa = new Pessoa();
                 novapessoa.setCpf(rs.getString("cpf"));
                 novapessoa.setDatanasci(rs.getDate("datanasci"));
                 novapessoa.setNome(rs.getString("nome"));
                 novapessoa.setRg(rs.getString("rg"));
                 novapessoa.setId(rs.getInt("id"));
                 novapessoa.setEmail(rs.getString("email"));
                 arrayp.add(novapessoa);
             }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return arrayp;
    }

    @Override
    public void Inserir() {
        try {
            conexao = Conecta.getConexao();
            conexao.setAutoCommit(false);
            PreparedStatement pstmt = conexao.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, pessoa.getNome());
            pstmt.setString(2, pessoa.getRg());
            pstmt.setString(3, pessoa.getCpf());
            pstmt.setDate(4, pessoa.getDatanasci()); 
            pstmt.setString(5, pessoa.getEmail());
            pstmt.execute();
            ResultSet rsId = pstmt.getGeneratedKeys();
            if(rsId.next()){
                pessoa.setId(rsId.getInt("id"));
                conexao.commit();
            }            
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
    
   public void aux () {
    try {
            conexao = Conecta.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(AUX);
            pstmt.setInt(1, e.getId());
            pstmt.setInt(2, pessoa.getId());
            pstmt.execute();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
        try {
            conexao.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
