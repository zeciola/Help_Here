package DAO;

import com.mysql.jdbc.PreparedStatement;
import java.util.*;

public interface iDAO {
    public void Inserir();
    public void Atualizar();
    public void Deletar();
    public ArrayList Consultar();
    public ArrayList Listar();
}
