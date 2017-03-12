package Util;

import Control.*;
import Model.*;
import DAO.*;
import Util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexao {
    
    //Nome do banco
    static String banco = "bankHH";
    //URL de conexão
    static String url = "jdbc:postgresql://127.0.0.1:5432/"+banco;
    //login do banco
    static String login = "postgres";
    //senha do banco
    static String password = "lucas";
    //driver que será utilizado
    static String driver = "org.postgresql.Driver";

    public static Connection getConexao() {
        Connection conexao = null;
        try {
            //driver
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, login, password);
        } catch (ClassNotFoundException erro1) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar carregar o driver: " + erro1);
        } catch (SQLException erro2) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar se conetar com o banco de dados: " + erro2);
        }
        return conexao;
    }
}
