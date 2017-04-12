package DAO;


import java.util.*;

public interface iDAO {
    public void Inserir();
    public void Atualizar(String OBJ, String ob);
    public void Deletar(String OBJ, String ob);
    public ArrayList Consultar(String OBJ);
    public ArrayList Listar();
}
