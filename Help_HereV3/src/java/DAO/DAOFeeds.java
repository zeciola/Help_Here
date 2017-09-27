package DAO;

import Model.Evento;
import Model.Feeds;
import Model.Pessoa;
import Model.Usuario;
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

<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
public class DAOFeeds {

    private Connection conexao;
    private static final String LISTAR = "select e.id, e.nome, e.datainicio, e.datafim, e.descricao, u.login, u.tipo from evento e, feeds f, usuario u\n" +
" where e.id = f.idevento and u.id = f.idusuario and f.idusuario = ? and CURRENT_DATE >= e.datainicio and CURRENT_DATE <= e.datafim and e.status = true limit 5";
    private static final String INTERESSADOS = "select u.id from usuario u, Interesses i where i.idusuario = u.id and i.interesse = ?";
    private static final String INSER = "insert into feeds (IDUsuario, IDEvento)values(?, ?)";
    
    public ArrayList<Feeds> Listar(Feeds u) {
        Date a = new Date();
        ArrayList<Feeds> f = new ArrayList();
        try {
            conexao = Conexao.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(LISTAR);
            pstmt.setInt(1, u.getU().getId());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                //RETORNO MAXIO SERA 5 PELO PARAMETRO LIMIT NA CONSULTA TRAZFEED
                Feeds feed = new Feeds();
                Evento e = new Evento();
                e.setIdEvento(Integer.parseInt(rs.getString("id")));
                e.setDataInicio(rs.getDate("datainicio"));
                e.setDataFim(rs.getDate("datafim"));
                e.setNome(rs.getString("nome"));
                feed.setE(e);
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

    public ArrayList<Pessoa> Interessados(Feeds tipo) {
        ArrayList<Pessoa> ids = new ArrayList();
        try {
            conexao = Conexao.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(INTERESSADOS);
            pstmt.setString(1, tipo.getE().getTipoEvento());
            ResultSet rs;
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Pessoa pe = new Pessoa();
                pe.setId(rs.getInt("id"));
                ids.add(pe);
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

    public void adicionarFeed(Feeds f) {
        try {
            conexao = Conexao.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(INSER);
            pstmt.setInt(1, f.getU().getId());
            pstmt.setInt(2, f.getE().getIdEvento());
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
