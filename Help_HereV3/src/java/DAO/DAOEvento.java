package DAO;

import Model.Endereco;
import Model.Evento;
import Model.Instituicao;
import Model.Mensagem;
import Util.Conexao;
import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jdk.nashorn.internal.objects.NativeMath.log;

public class DAOEvento implements iDAO {

    private Evento ev;
    private Mensagem ms;
    private Endereco en;

    public void setEndereco(Endereco en) {
        this.en = en;
    }

    public void setEvento(Evento ev) {
        this.ev = ev;
    }

    public Mensagem getMs() {
        return ms;
    }

    public void setMs(Mensagem ms) {
        this.ms = ms;
    }

    private final Connection conexao = Conexao.getConexao();

    private static final String INSERT = "insert into Evento (dataInicio, dataFim, nome, tipo, descricao) values(?,?,?,?,?)";

    private static final String LISTAR = "select * from Evento where status = true";

    private static final String LISTAR2 = "select * from Evento";

    private static final String ATIVAR = "update evento set status = true where id = ?";

    private static final String DESATIVAR = "update evento set status = false where id = ?";

    private static final String LISTAevATIVO = "select * from Evento where current_date between  datainicio and   datafim and status = true";

    //DAO Metodos
    @Override
    public void Inserir() {
        try {

            conexao.setAutoCommit(false);

            //PreparedStatement INSERT - RETURN_GENERATED_KEYS por que recebe a id do banco
            PreparedStatement pstmt = conexao.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);

            pstmt.setDate(1, (Date) ev.getDataInicio());

            pstmt.setDate(2, (Date) ev.getDataFim());

            pstmt.setString(3, ev.getNome());

            pstmt.setString(4, ev.getTipoEvento());

            pstmt.setString(5, ev.getDescricao());

            pstmt.executeUpdate();
            // Fim da pstmt insert

            //Resultset para id
            ResultSet rs = pstmt.getGeneratedKeys();

            //rs.next();
            if (rs.next()) {
                ev.setIdEvento(rs.getInt("ID"));
                conexao.commit();
            }

            //Fim da busca
        } // Verifica se a conexao foi fechada
        catch (SQLException e) {
            try {
                conexao.rollback();

            } catch (SQLException ex) {
                Logger.getLogger(DAOEndereco.class.getName()).log(Level.SEVERE, null, ex);
            }
            Logger.getLogger(Endereco.class.getName()).
                    log(Level.SEVERE, "Erro ao cadastrar: " + e.getMessage());
        } finally {
            //4
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAOEndereco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void inserirMensagem() {
        Connection conexao = null;

        try {
            conexao = Conexao.getConexao();
            //PreparedStatement INSERT - RETURN_GENERATED_KEYS por que recebe a id do banco
            conexao.setAutoCommit(false);

            String sqlEndereco = "insert into Mensagem ( mensagem1, mensagem2) values(?,?)";

            PreparedStatement pstmt = conexao.prepareStatement(sqlEndereco, PreparedStatement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, ms.getMensagem1());

            pstmt.setString(2, ms.getMensagem2());

            pstmt.execute();

            conexao.commit();

        } catch (SQLException e) {
            try {
                conexao.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(DAOInstituicao.class.getName()).log(Level.SEVERE, null, ex);
            }
            Logger.getLogger(DAOInstituicao.class.getName());
            log(Level.SEVERE, "Erro ao Cadastrar: " + e.getMessage());
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAOInstituicao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public Mensagem recuperarMensagem(String M) {
        Connection conexao = null;
        try {
            conexao = Conexao.getConexao();
            String sqlConsulta = "select * from Mensagem where mensagem1 =  '" + M + "'";
            PreparedStatement pstmt = conexao.prepareStatement(sqlConsulta);
            ResultSet rs;
            rs = pstmt.executeQuery();

            ms.setIdmensagem(rs.getInt("ID"));
            ms.setMensagem1(rs.getString("mensagem1"));
            ms.setMensagem2(rs.getString("mensagem2"));

            return ms;

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

    public void AtualizarEvento(int idvento) {
        try {

            String sqlAltera = "update Evento set (datainicio, datafim, nome, tipo, descricao) = (?,?,?,?,?) where id =  '" + idvento + "'";

            PreparedStatement pstmt = conexao.prepareStatement(sqlAltera, PreparedStatement.RETURN_GENERATED_KEYS);

            pstmt.setDate(1, (Date) ev.getDataInicio());

            pstmt.setDate(2, (Date) ev.getDataFim());

            pstmt.setString(3, ev.getNome());

            pstmt.setString(4, ev.getTipoEvento());

            pstmt.setString(5, ev.getDescricao());

            pstmt.executeUpdate();
            // Fim da pstmt insert

            //Resultset para id
            ResultSet rs = pstmt.getGeneratedKeys();

            //rs.next();
            if (rs.next()) {
                ev.setIdEvento(rs.getInt("ID"));
                conexao.commit();
            }

            //Fim da busca
        } // Verifica se a conexao foi fechada
        catch (SQLException e) {
            try {
                conexao.rollback();

            } catch (SQLException ex) {
                Logger.getLogger(DAOEndereco.class.getName()).log(Level.SEVERE, null, ex);
            }
            Logger.getLogger(Endereco.class.getName()).
                    log(Level.SEVERE, "Erro ao cadastrar: " + e.getMessage());
        } finally {
            //4
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAOEndereco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void Atualizar(String OBJ, String ob) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Deletar(String NomeEV, String SEN) {
        Connection conexao = null;
        try {
            conexao = Conexao.getConexao();

            String sqlDelEV = "update Evento set status = false where nome = '" + NomeEV + "' and ID in (select eve.idEvento from InstituicaoEvento eve, Instituicao e where e.id = eve.idInstituicao and e.senha = '" + SEN + "');";

            PreparedStatement pstmt = conexao.prepareStatement(sqlDelEV);
            pstmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList ConsultarEVinst(String NomeEV, String SEN) {
        ArrayList<Evento> resul = new ArrayList();
        Connection conexao = null;
        try {
            conexao = Conexao.getConexao();
            String sqlConsulta = "select * from Evento where nome = '" + NomeEV + "' and status = true and ID in (select eve.idEvento from InstituicaoEvento eve, Instituicao e where e.id = eve.idInstituicao and e.senha = '" + SEN + "');";
            PreparedStatement pstmt = conexao.prepareStatement(sqlConsulta);
            ResultSet rs;
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Evento in = new Evento();

                in.setIdEvento(rs.getInt("ID"));
                in.setDataInicio(rs.getDate("dataInicio"));
                in.setDataFim(rs.getDate("dataFim"));
                in.setNome(rs.getString("nome"));
                in.setTipoEvento(rs.getString("tipo"));
                in.setDescricao(rs.getString("descricao"));

                resul.add(in);

            }
            return resul;

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
    public ArrayList Consultar(String N) {
        ArrayList<Evento> resul = new ArrayList();
        Connection conexao = null;
        try {
            conexao = Conexao.getConexao();
            String sqlConsulta = "select * from Evento where nome ilike '%" + N + "%' and status = true";
            PreparedStatement pstmt = conexao.prepareStatement(sqlConsulta);
            ResultSet rs;
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Evento in = new Evento();
                in.setIdEvento(rs.getInt("ID"));
                in.setDataInicio(rs.getDate("dataInicio"));
                in.setDataFim(rs.getDate("dataFim"));
                in.setNome(rs.getString("nome"));
                in.setTipoEvento(rs.getString("tipo"));
                in.setDescricao(rs.getString("descricao"));
                resul.add(in);
            }
            return resul;

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

    public Evento Consultar1(Integer id) {
        Evento in = new Evento();
        Connection conexao = null;
        try {
            conexao = Conexao.getConexao();
            String sqlConsulta = "select * from Evento where id ="+id;
            PreparedStatement pstmt = conexao.prepareStatement(sqlConsulta);
            ResultSet rs;
            rs = pstmt.executeQuery();
            while (rs.next()) {
                in.setIdEvento(rs.getInt("ID"));
                in.setDataInicio(rs.getDate("dataInicio"));
                in.setDataFim(rs.getDate("dataFim"));
                in.setNome(rs.getString("nome"));
                in.setTipoEvento(rs.getString("tipo"));
                in.setDescricao(rs.getString("descricao"));
            }
            return in;
            
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
    public ArrayList Listar() {
        ArrayList<Evento> resul = new ArrayList();
        Connection conexao = null;
        try {
            conexao = Conexao.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(LISTAR);
            ResultSet rs;
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Evento in = new Evento();

                in.setIdEvento(rs.getInt("ID"));
                in.setDataInicio(rs.getDate("dataInicio"));
                in.setDataFim(rs.getDate("dataFim"));
                in.setNome(rs.getString("nome"));
                in.setTipoEvento(rs.getString("tipo"));
                in.setDescricao(rs.getString("descricao"));

                resul.add(in);

            }
            return resul;

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

    public ArrayList Listar2() {
        ArrayList<Evento> resul = new ArrayList();
        Connection conexao = null;
        try {
            conexao = Conexao.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(LISTAR2);
            ResultSet rs;
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Evento in = new Evento();

                in.setIdEvento(rs.getInt("ID"));
                in.setDataInicio(rs.getDate("dataInicio"));
                in.setDataFim(rs.getDate("dataFim"));
                in.setNome(rs.getString("nome"));
                in.setTipoEvento(rs.getString("tipo"));
                in.setDescricao(rs.getString("descricao"));

                resul.add(in);

            }
            return resul;

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

    public ArrayList ListarPorData() {
        ArrayList<Evento> resul = new ArrayList();
        Connection conexao = null;
        try {
            conexao = Conexao.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(LISTAevATIVO);
            ResultSet rs;
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Evento in = new Evento();

                in.setIdEvento(rs.getInt("ID"));
                in.setDataInicio(rs.getDate("dataInicio"));
                in.setDataFim(rs.getDate("dataFim"));
                in.setNome(rs.getString("nome"));
                in.setTipoEvento(rs.getString("tipo"));
                in.setDescricao(rs.getString("descricao"));

                resul.add(in);

            }
            return resul;

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

    public void InserirAuxInstituicaoEvento(int idinstituicao, int idvento) {
        try {

            conexao.setAutoCommit(false);

            //PreparedStatement INSERT - RETURN_GENERATED_KEYS por que recebe a id do banco
            String sqlInstituicao = "insert into InstituicaoEvento (idInstituicao, IdEvento) values(" + idinstituicao + "," + idvento + ")";
            PreparedStatement pstmt = conexao.prepareStatement(sqlInstituicao, PreparedStatement.RETURN_GENERATED_KEYS);

            pstmt.execute();
            // Fim da pstmt insert

            conexao.commit();

            //Fim da busca
        } // Verifica se a conexao foi fechada
        catch (SQLException e) {
            try {
                conexao.rollback();

            } catch (SQLException ex) {
                Logger.getLogger(DAOEndereco.class.getName()).log(Level.SEVERE, null, ex);
            }
            Logger.getLogger(Endereco.class.getName()).
                    log(Level.SEVERE, "Erro ao cadastrar: " + e.getMessage());
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public ArrayList AtualizarEndEV(int IdEnd) {
        ArrayList<Endereco> resul = new ArrayList();
        Connection conexao = null;
        try {
            conexao = Conexao.getConexao();
            String sqlConsulta = "select * from endereco where id = " + IdEnd + "";
            PreparedStatement pstmt = conexao.prepareStatement(sqlConsulta);
            ResultSet rs;
            rs = pstmt.executeQuery();
            while (rs.next()) {

                String sqlAltera = "update Endereco set cep=?, nomelogradouro=?, numero=?, bairro=?, municipio=?, uf=?, pais=? where id =" + IdEnd + "";

                PreparedStatement pstm = conexao.prepareStatement(sqlAltera);

                pstm.setString(1, en.getCep());

                pstm.setString(2, en.getNomelogradouro());

                pstm.setInt(3, en.getNumeroen());

                pstm.setString(4, en.getBairro());

                pstm.setString(5, en.getMunicipio());

                pstm.setString(6, en.getEstado());

                pstm.setString(7, en.getPais());

                pstm.executeUpdate();

                resul.add(en);

            }
            return resul;

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

    public ArrayList EventoEndereco(int IdEv) {
        ArrayList<Endereco> resul = new ArrayList();
        Connection conexao = null;
        try {
            conexao = Conexao.getConexao();
            String sqlConsulta = "select * from enderecoevento eve, endereco e where e.id = eve.idendereco and eve.idevento = " + IdEv + "";
            PreparedStatement pstmt = conexao.prepareStatement(sqlConsulta);
            ResultSet rs;
            rs = pstmt.executeQuery();
            while (rs.next()) {

                Endereco en = new Endereco();

                en.setIdEndereco(rs.getInt("ID"));
                en.setCep(rs.getString("cep"));
                en.setNomelogradouro(rs.getString("NomeLogradouro"));
                en.setNumeroen(Integer.parseInt(rs.getString("Numero")));
                en.setBairro(rs.getString("Bairro"));
                en.setMunicipio(rs.getString("Municipio"));
                en.setEstado(rs.getString("UF"));
                en.setPais(rs.getString("pais"));

                resul.add(en);

            }
            return resul;

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

    public ArrayList InstituicaoEvento(int IdEv) {
        ArrayList<Instituicao> resul = new ArrayList();
        Connection conexao = null;
        try {
            conexao = Conexao.getConexao();
            String sqlConsulta = "select * from InstituicaoEvento eve, Instituicao e where e.id = eve.idInstituicao and eve.idEvento = " + IdEv + "";
            PreparedStatement pstmt = conexao.prepareStatement(sqlConsulta);
            ResultSet rs;
            rs = pstmt.executeQuery();
            while (rs.next()) {

                Instituicao in = new Instituicao();

                in.setIdInstituicao(rs.getInt("ID"));
                in.setNome(rs.getString("Nome"));
                in.setRazao(rs.getString("razaoSocial"));
                in.setTipo(rs.getString("tipo"));
                in.setCnpj(rs.getString("CNPJ"));
                in.setModalidade(rs.getString("modalidade"));
                in.setEmail(rs.getString("email"));

                resul.add(in);

            }
            return resul;

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

    public void InserirAuxEnderecoEvento(int idendereco, int idevento) {
        try {

            conexao.setAutoCommit(false);

            //PreparedStatement INSERT - RETURN_GENERATED_KEYS por que recebe a id do banco
            String sqlEndereco = "insert into EnderecoEvento (idEndereco, idEvento) values(" + idendereco + "," + idevento + ")";
            PreparedStatement pstmt = conexao.prepareStatement(sqlEndereco, PreparedStatement.RETURN_GENERATED_KEYS);

            pstmt.execute();
            // Fim da pstmt insert

            conexao.commit();

            //Fim da busca
        } // Verifica se a conexao foi fechada
        catch (SQLException e) {
            try {
                conexao.rollback();

            } catch (SQLException ex) {
                Logger.getLogger(DAOEndereco.class.getName()).log(Level.SEVERE, null, ex);
            }
            Logger.getLogger(Endereco.class.getName()).
                    log(Level.SEVERE, "Erro ao cadastrar: " + e.getMessage());
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void Ativar(Evento e) {
        try {
            PreparedStatement pstmt = conexao.prepareStatement(ATIVAR);
            pstmt.setInt(1, e.getIdEvento());
            pstmt.execute();
        } catch (SQLException f) {
            throw new RuntimeException(f);
        } finally {
            try {
                conexao.close();
            } catch (SQLException f) {
                throw new RuntimeException(f);
            }
        }
    }

    public void Desativar(Evento e) {
        try {
            PreparedStatement pstmt = conexao.prepareStatement(DESATIVAR);
            pstmt.setInt(1, e.getIdEvento());
            pstmt.execute();
        } catch (SQLException f) {
            throw new RuntimeException(f);
        } finally {
            try {
                conexao.close();
            } catch (SQLException f) {
                throw new RuntimeException(f);
            }
        }
    }

}
