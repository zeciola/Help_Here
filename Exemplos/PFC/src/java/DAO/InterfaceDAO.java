/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;

/**
 *
 * @author Diego
 */
public interface InterfaceDAO {
    public void Inserir();
    public void Atualizar();
    public void Deletar();
    public ArrayList Consultar();
    public ArrayList Listar();
}
