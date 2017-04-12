package DAO;


import java.util.*;

public interface iDAO {
    public void Inserir();
    public void Atualizar(String OBJ);
    public void Deletar(String OBJ);
    public ArrayList Consultar(String OBJ);
    public ArrayList Listar();
}
