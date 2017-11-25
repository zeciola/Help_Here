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
    private static String banco = "Helphere";
    //URL de conexão
    private static String url = "jdbc:postgresql://localhost:5432/" + banco;
    //login do banco
    private static String login = "postgres";
    //senha do banco
    private static String password = "postgres";
    //driver que será utilizado
    private static String driver = "org.postgresql.Driver";

    public static Connection getConexao() {
        Connection conexao = null;
        try {            
            //driver
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, login, password);
             /*
            //driver que será utilizado
            Class.forName("org.postgresql.Driver");
            //cria um objeto de conexao com um banco especificado no caminho...
            conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Helphere", "postgres", "postgres");
            */
             System.out.println("Conexão OK");
        } catch (ClassNotFoundException erro1) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar carregar o driver: " + erro1);
            System.err.print(erro1.getMessage());
        } catch (SQLException erro2) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar se conetar com o banco de dados: " + erro2);
            System.err.print(erro2.getMessage());
        }
        return conexao;
    }
}
