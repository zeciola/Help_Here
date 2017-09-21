package DAO;

import Model.Feeds;
import Util.Conexao;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class DAOFeeds {

    private Connection conexao;
    private static final String LISTAR = "select e.id, e.nome, e.datainicio, e.datafim, e.descricao, u.login, u.tipo from evento e, feeds f, usuario u\n" +
" where e.id = f.idevento and u.id = f.idusuario and f.idusuario = ? and CURRENT_DATE >= e.datainicio and CURRENT_DATE <= e.datafim and e.status = true limit 5";
    private static final String INTERESSADOS = "select u.id from usuario u, Interesses i where i.idusuario = u.id and i.interesse = ?";
    private static final String INSER = "insert into feeds (IDUsuario, IDEvento)values(?, ?)";
    
    public ArrayList<Feeds> Listar(int iduser) {
        Date a = new Date();
        ArrayList<Feeds> f = new ArrayList();

        try {
           
            conexao = Conexao.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(LISTAR);
            pstmt.setInt(1, iduser);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                //RETORNO MAXIO SERA 5 PELO PARAMETRO LIMIT NA CONSULTA TRAZFEED
                Feeds feed = new Feeds();
                feed.setIdEV(Integer.parseInt(rs.getString("id")));
                feed.setDatainiev(rs.getDate("datainicio"));
                feed.setDatafimev(rs.getDate("datafim"));
                feed.setNomeEvento(rs.getString("nome"));
                f.add(feed);
            }
            return f;
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public ArrayList<Integer> Interessados(String tipo) {
        ArrayList ids = new ArrayList();
        try {
            conexao = Conexao.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(INTERESSADOS);
            pstmt.setString(1, tipo);
            ResultSet rs;
            rs = pstmt.executeQuery();
            while (rs.next()) {
                ids.add( rs.getInt("id"));
            }
            return ids;
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void adicionarFeed(int iduser, int idev) {
        try {
            conexao = Conexao.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(INSER);
            pstmt.setInt(1, iduser);
            pstmt.setInt(2, idev);
            pstmt.execute();
            
        } catch (SQLException e) {
            System.out.println(e);
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
