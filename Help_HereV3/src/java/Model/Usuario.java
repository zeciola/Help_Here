package Model;

// Usuario é a tabela Usuário
// Usuario is the table Usuário
public class Usuario {

    private Pessoa pe;
    private Endereco en;
    private int id;
    private String nome;
    private String senha;
    private PerfilDeAcesso perfil;
    private boolean status;

     //Sets
    
    public void setPe(Pessoa pe) {
        this.pe = pe;
    }
    public void setEn(Endereco en) {
        this.en = en;
    }
    public void setId(int CodPessoa) {
        this.id = CodPessoa;
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
    public void setStatus(boolean status) {
        this.status = status;
    }
    

     //Gets
    public Pessoa getPe() {
        return pe;
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
    public boolean isStatus() {
        return status;
    }
}
