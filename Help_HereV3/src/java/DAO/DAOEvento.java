package DAO;

import Model.Endereco;
import Model.Evento;
import Model.Instituicao;
import Model.Mensagem;
import Model.Pessoa;
import Model.Usuario;
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

public class DAOEvento /*implements iDAO*/ {

    private static final Connection conexao = Conexao.getConexao();

    private static final String INSERT = "insert into Evento (dataInicio, dataFim, nome, tipo, descricao) values(?,?,?,?,?)";

    private static final String LISTAR = "select * from Evento where status = true";

    private static final String LISTAR2 = "select * from Evento";

    private static final String ATIVAR = "update evento set status = true where id = ?";

    private static final String DESATIVAR = "update evento set status = false where id = ?";

    private static final String LISTAevATIVO = "select * from Evento where current_date between  datainicio and   datafim and status = true";

    //DAO Metodos
    //@Override
    public void Inserir(Evento ev) {
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




    public void AtualizarEvento(Evento ev) {
        try {

            String sqlAltera = "update Evento set (datainicio, datafim, nome, tipo, descricao) = (?,?,?,?,?) where id =  '"+ev.getIdEvento()+"'";

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

    

    //@Override
    public void Deletar(Evento ev, Instituicao inst) {
        Connection conexao = null;
        try {
            conexao = Conexao.getConexao();

            String sqlDelEV = "update Evento set status = false where nome = '" + ev.getNome() + "' and ID in (select eve.idEvento from InstituicaoEvento eve, Instituicao e where e.id = eve.idInstituicao and e.senha = '" + inst.getSenha() + "');";

            PreparedStatement pstmt = conexao.prepareStatement(sqlDelEV);
            pstmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void DeletarEvPessoa(Evento ev, Usuario user) {
        Connection conexao = null;
        try {
            conexao = Conexao.getConexao();

            String sqlDelEV = "update Evento set status = false where nome = '" + ev.getNome() + "' and ID in (select eve.idEvento from PessoaEvento eve, Usuario e where e.IDPessoa = eve.idPessoa and e.senha = '" + user.getSenha() + "');";

            PreparedStatement pstmt = conexao.prepareStatement(sqlDelEV);
            pstmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public ArrayList ConsultarEVinst(Evento ev, Instituicao inst) {
        ArrayList<Evento> resul = new ArrayList();
        Connection conexao = null;
        try {
            conexao = Conexao.getConexao();
            String sqlConsulta = "select * from Evento where nome = '" + ev.getNome() + "' and status = true and ID in (select eve.idEvento from InstituicaoEvento eve, Instituicao e where e.id = eve.idInstituicao and e.senha = '" + inst.getSenha() + "');";
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

    //@Override
    public ArrayList Consultar(Evento ev) {
        ArrayList<Evento> resul = new ArrayList();
        Connection conexao = null;
        try {
            conexao = Conexao.getConexao();
            String sqlConsulta = "select * from Evento where nome ilike '%" + ev.getNome() + "%' and status = true";
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

   /* public ArrayList ConsultarId(int id) {
        ArrayList<Evento> resul = new ArrayList();
        Connection conexao = null;
        try {
            conexao = Conexao.getConexao();
            String sqlConsulta = "select * from Evento where id ="+id;
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
    Parei aqui  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    */
    
    public Evento Consultar1(Evento ev) {
        Evento in = new Evento();
        Connection conexao = null;
        try {
            conexao = Conexao.getConexao();
            String sqlConsulta = "select * from Evento where id ="+ev.getIdEvento();
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
    
    //@Override
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
    
    public ArrayList ListarPorID(Instituicao inst) {
        ArrayList<Evento> resul = new ArrayList();
        Connection conexao = null;
        try {
            conexao = Conexao.getConexao();
            String sqlListar = "select * from InstituicaoEvento ie, Evento eve where eve.id = ie.idevento and ie.idInstituicao ="+inst.getIdInstituicao()+" and status = true";
            PreparedStatement pstmt = conexao.prepareStatement(sqlListar);
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

    public ArrayList ListarEvPessoaPorID(Usuario user) {
        ArrayList<Evento> resul = new ArrayList();
        Connection conexao = null;
        try {
            conexao = Conexao.getConexao();
            String sqlListar = "select * from PessoaEvento pe, Evento eve where eve.id = pe.idevento and pe.idPessoa ="+user.getId()+" and status = true";
            PreparedStatement pstmt = conexao.prepareStatement(sqlListar);
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

    public void InserirAuxInstituicaoEvento(Instituicao inst, Evento ev) {
        Connection conexao = null;
        try {

            conexao = Conexao.getConexao();

            //PreparedStatement INSERT - RETURN_GENERATED_KEYS por que recebe a id do banco
            String sqlInstituicao = "insert into InstituicaoEvento (idInstituicao, IdEvento) values(" + inst.getIdInstituicao() + "," + ev.getIdEvento() + ")";
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

    public void InserirAuxPessoaEvento(Pessoa p, Evento ev) {
        try {

            conexao.setAutoCommit(false);

            //PreparedStatement INSERT - RETURN_GENERATED_KEYS por que recebe a id do banco
            String sqlInstituicao = "insert into PessoaEvento (idPessoa, IdEvento) values(" + p.getId() + "," + ev.getIdEvento() + ")";
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
    
    public ArrayList AtualizarEndEV(Endereco en) {
        ArrayList<Endereco> resul = new ArrayList();
        Connection conexao = null;
        try {
            conexao = Conexao.getConexao();
            String sqlConsulta = "select * from endereco where id = " + en.getIdEndereco() + "";
            PreparedStatement pstmt = conexao.prepareStatement(sqlConsulta);
            ResultSet rs;
            rs = pstmt.executeQuery();
            while (rs.next()) {

                String sqlAltera = "update Endereco set cep=?, nomelogradouro=?, numero=?, bairro=?, municipio=?, uf=?, pais=? where id =" + en.getIdEndereco() + "";

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

    public ArrayList EventoEndereco(Evento ev) {
        ArrayList<Endereco> resul = new ArrayList();
        Connection conexao = null;
        try {
            conexao = Conexao.getConexao();
            String sqlConsulta = "select * from enderecoevento eve, endereco e where e.id = eve.idendereco and eve.idevento = " + ev.getIdEvento() + "";
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

    public ArrayList InstituicaoEvento(Evento ev) {
        ArrayList<Instituicao> resul = new ArrayList();
        Connection conexao = null;
        try {
            conexao = Conexao.getConexao();
            String sqlConsulta = "select * from InstituicaoEvento eve, Instituicao e where e.id = eve.idInstituicao and eve.idEvento = " + ev.getIdEvento() + "";
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

    public ArrayList PessoaEvento(Evento ev) {
        ArrayList<Pessoa> resul = new ArrayList();
        Connection conexao = null;
        try {
            conexao = Conexao.getConexao();
            String sqlConsulta = "select * from PessoaEvento eve, Pessoa e where e.id = eve.idPessoa and eve.idEvento = " + ev.getIdEvento() + "";
            PreparedStatement pstmt = conexao.prepareStatement(sqlConsulta);
            ResultSet rs;
            rs = pstmt.executeQuery();
            while (rs.next()) {

                Pessoa in = new Pessoa();

                in.setId(rs.getInt("ID"));
                in.setNome(rs.getString("Nome"));
                in.setSobrenome(rs.getString("Sobrenome"));
                in.setEmail(rs.getString("email"));
                in.setCpf(rs.getString("CPF"));
                

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

    
    public void InserirAuxEnderecoEvento(Endereco en, Evento ev) {
        Connection conexao = Conexao.getConexao();
        try {

            conexao.setAutoCommit(false);

            //PreparedStatement INSERT - RETURN_GENERATED_KEYS por que recebe a id do banco
            String sqlEndereco = "insert into EnderecoEvento (idEndereco, idEvento) values(" + en.getIdEndereco() + "," + ev.getIdEvento() + ")";
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
    
    public void AtualizarContador(Evento e) {
        try {
            String sqlAtualiza = "update Instituicao set contador = contador-1 where id in (select idinstituicao from instituicaoevento eve, instituicao e where e.id = eve.idinstituicao and eve.idevento = "+e.getIdEvento()+" )";
                   
           PreparedStatement pstmt = conexao.prepareStatement(sqlAtualiza, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.executeQuery();
            
            
            conexao.commit();
            
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
    
    
    public void AtualizarContadorP(Evento e) {
        try {
            String sqlAtualiza = "update Pessoa set contador = contador-1 where id in (select idpessoa from pessoaevento eve, pessoa e where e.id = eve.idpessoa and eve.idevento =  "+e.getIdEvento()+" )";
                   
           PreparedStatement pstmt = conexao.prepareStatement(sqlAtualiza, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.executeQuery();
            
            
            conexao.commit();
            
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
