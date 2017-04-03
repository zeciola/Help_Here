/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class Conecta {
    public static Connection getConexao(){
        Connection conexao = null;
        try{
             //driver que será utilizado
             Class.forName("org.postgresql.Driver");
             conexao = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/pfc", "postgres", "lucas");
            }
        catch(ClassNotFoundException erro1){
            JOptionPane.showMessageDialog(null, "Erro ao tentar carregar o driver: "+erro1);
        }catch (SQLException erro2) {
             JOptionPane.showMessageDialog(null, "Erro ao tentar se conetar com o banco de dados: "+erro2); 
        }
        return conexao;
    }
}
