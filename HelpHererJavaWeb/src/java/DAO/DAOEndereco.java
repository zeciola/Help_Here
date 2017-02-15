package DAO;

import Command.*;
import Control.*;
import Model.*;
import DAO.*;
import Util.*;
import java.sql.Connection;
import java.util.ArrayList;

public class DAOEndereco implements iDAO{
    
    //Endereço
    private Endereco endereco;
    //Variable connection
    private Connection conexao;
    
    //SQL inputs
    
    private static final String INSERT = "insert into endereco (endereco, numeroen, cidade, estado, cep) values(?,?,?,?,?)";
    private static final String SELECT_ALL = "select * from endereco";
    private static final String SELECT_ID = "select * from endereco where id=? status=true";
    

    
    public void setEndereco(Endereco endereco){
        this.endereco = endereco;
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
