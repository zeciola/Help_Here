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

