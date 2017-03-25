package Model;


// Login é a tabela Usuário

// Login is the table Usuário

public class Login {
    
    private String nome;
    private String senha;
    private PerfilDeAcesso perfil;

    //Gets

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public PerfilDeAcesso getPerfil() {
        return perfil;
    }
    
    //Sets

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
