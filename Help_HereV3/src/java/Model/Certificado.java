package Model;

import Control.*;
import Model.*;
import DAO.*;
import Util.*;
import java.util.*;

public class Certificado {
    private String emissor;
    private Pessoa Pessoa;
    private int horas;
    private Instituicao instituicao;
    private Evento evento;
    private boolean analisado;
    private boolean valido;
    private ArrayList<Evento> pendentes;
    private ArrayList<Pessoa> pessoasPendesntes;

    public ArrayList<Pessoa> getPessoasPendesntes() {
        return pessoasPendesntes;
    }

    public void setPessoasPendesntes(ArrayList<Pessoa> pessoasPendesntes) {
        this.pessoasPendesntes = pessoasPendesntes;
    }
    
    public ArrayList<Evento> getPendentes() {
        return pendentes;
    }

    public void setPendentes(ArrayList<Evento> pendentes) {
        this.pendentes = pendentes;
    }
    
    

    public boolean isAnalisado() {
        return analisado;
    }

    public void setAnalisado(boolean analisado) {
        this.analisado = analisado;
    }

    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }
    
    

    public Pessoa getPessoa() {
        return Pessoa;
    }

    public void setPessoa(Pessoa Pessoa) {
        this.Pessoa = Pessoa;
    }
    
    //Gets

    public String getEmissor() {
        return emissor;
    }

    public int getHoras() {
        return horas;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public Evento getEvento() {
        return evento;
    }
    
    //Sets

    public void setEmissor(String emissor) {
        this.emissor = emissor;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
            
}

