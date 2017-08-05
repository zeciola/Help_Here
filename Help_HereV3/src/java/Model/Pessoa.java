package Model;

import Control.*;
import Model.*;
import DAO.*;
import Util.*;
import java.util.Date;

public class Pessoa {

    private Endereco en;

    private int id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String rg;
    private boolean penalisado;
    private String datanascimento;
    private String email;

    //private int IDEndereco;
    private String telefone;
    private String celular;
    private String sexo;
    private boolean status;

    //Gets
    public Endereco getEn() {
        return en;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public boolean isPenalisado() {
        return penalisado;
    }

    public String getDatanascimento() {
        return datanascimento;
    }

    public String getEmail() {
        return email;
    }
    
    public String getTelefone() {
        return telefone;
    }

    public String getCelular() {
        return celular;
    }

    public String getSexo() {
        return sexo;
    }

    public boolean isStatus() {
        return status;
    }

    //Sets
    
    public void setEn(Endereco en) {
        this.en = en;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setPenalisado(boolean penalisado) {
        this.penalisado = penalisado;
    }

    public void setDatanascimento(String datanascimento) {
        this.datanascimento = datanascimento;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
