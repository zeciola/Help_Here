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

public class DAOPessoa implements iDAO {

    private Pessoa pe;
    private Endereco en;
    private Connection conexao;

    // defalt variabel Penalisado = false
    private boolean defalt;

    //Construtor Pessoa
    public void setPessoa(Pessoa pe) {
        this.pe = pe;
    }

    //SQL
    private static final String INSERT = "insert into Pessoa (Nome, Sobrenome, CPF, RG, Penalisado, Datanascimento, email, IDEndereco, Telefone, celular, sexo) "
            + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String DELETE = "update pessoa set";

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

            rs.next();
            
            if(rs.next()){
                pe.setId(rs.getInt("ID"));
                conexao.commit();
            }

            //conexao.commit();


        } // Verifica se a conexao foi fechada
        catch (SQLException sqlErro) {
            throw new RuntimeException(sqlErro);
        } 
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
