/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author 11141104689
 */
public class Login {
    private String nome;
    private String senha;
    private PerfilDeAcesso perfil;

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public PerfilDeAcesso getPerfil() {
        return perfil;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setPerfil(PerfilDeAcesso perfil) {
        this.perfil = perfil;
    }
    
    
}
