package DAO;

import Control.*;
import Model.*;
import DAO.*;
import Util.*;
import java.sql.Connection;
import java.util.ArrayList;

public class DAOPessoa implements iDAO{
    
    private Pessoa pe;
    private Endereco en;
    private Connection conexao;
    
    //SQL
    
    private static final String DELETE = "update pessoa set";
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
