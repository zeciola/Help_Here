package DAO;

import Model.Contribuicao;
import Model.Evento;
import Model.Pessoa;
import Model.Usuario;
import Util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOContribuir {

    public void DoarValor(Contribuicao c) {
        Connection conexao = Conexao.getConexao();
        try {
            conexao.setAutoCommit(false);
            PreparedStatement pstmt = conexao.prepareStatement("insert into valoresdoados (Valor, dataDoado, idCampanha, IDPessoa, boleto, statusbaixa) values(?, CURRENT_DATE, ?, ?, ?, false)");
            pstmt.setDouble(1, c.getValor());
            pstmt.setInt(2, c.getEv().getIdEvento());
            pstmt.setInt(3, c.getUser().getPe().getId());
            pstmt.setString(4, c.getNumeroBoleto());
            pstmt.execute();
            conexao.commit();

        } catch (SQLException e) {
            try {
                conexao.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(DAOPessoa.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAOPessoa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void Voluntariar(Contribuicao c) {
        Connection conexao = Conexao.getConexao();
        try {
            conexao.setAutoCommit(false);
            PreparedStatement pstmt = conexao.prepareStatement("insert into voluntario (idpessoa, idevento, datavoluntario) values(?,?,CURRENT_DATE)");
            pstmt.setInt(1, c.getUser().getPe().getId());
            pstmt.setInt(2, c.getEv().getIdEvento());
            pstmt.execute();
            conexao.commit();

        } catch (SQLException e) {
            try {
                conexao.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(DAOPessoa.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAOPessoa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public ArrayList<Contribuicao> ListarVoluntarios(Contribuicao c) {
        ArrayList<Contribuicao> retorno = new ArrayList();
        Connection conexao = Conexao.getConexao();
        ResultSet rs;
        try {
            PreparedStatement pstmt = conexao.prepareStatement("select v.id, v.idevento, v.datavoluntario, v.idpessoa from voluntario v, pessoa p, evento e where p.id = v.idpessoa and v.idevento = e.id and p.id = ? and e.id = ?");
            pstmt.setInt(1, c.getUser().getPe().getId());
            pstmt.setInt(2, c.getEv().getIdEvento());
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Contribuicao v = new Contribuicao();
                v.setId(rs.getInt("id"));
                v.setDatacad(rs.getDate("datavoluntario"));

                Evento ev = new Evento();
                ev.setIdEvento(rs.getInt("idevento"));
                v.setEv(ev);

                Pessoa p = new Pessoa();
                p.setId(rs.getInt("idpessoa"));
                Usuario u = new Usuario();
                u.setPe(p);
                v.setUser(u);
                retorno.add(v);
            }
            return retorno;

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

    public String RecuperaUltimoValor() {
        String retorno = null;
        Connection conexao = Conexao.getConexao();
        ResultSet rs;
        try {
            PreparedStatement pstmt = conexao.prepareStatement("select * from ultimoboleto");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                retorno = rs.getString("numeroboleto");
            }
            return retorno;

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

    public void AtualizaUltimoValor(Contribuicao c) {
        Connection conexao = Conexao.getConexao();
        try {
            PreparedStatement pstmt = conexao.prepareStatement("update ultimoboleto set numeroboleto = ? where id = 1");
            pstmt.setString(1, c.getNumeroBoleto());
            pstmt.execute();
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

}
