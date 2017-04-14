package Model;

// Login é a tabela Usuário
// Login is the table Usuário
public class Login {

    private Pessoa pe;
    private Endereco en;

    private int id;
    private String nome;
    private String senha;
    private PerfilDeAcesso perfil;

    //Gets
    
    public void setPe(Pessoa pe) {
        this.pe = pe;
    }

    public void setEn(Endereco en) {
        this.en = en;
    }

    public Endereco getEn() {
        return en;
    }
    
    public int getId() {
        return id;
    }

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
    
    public Pessoa getPe() {
        return pe;
    }
    
    public void setId(int CodPessoa) {
        this.id = id;
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
