package Model;

import Control.*;
import Model.*;
import DAO.*;
import Util.*;
import java.util.*;

public class Certificado {
    private String emissor;
    private String AquemseDestina;
    private int horas;
    private String nomeDoEvento;
    private Instituicao instituicao;
    private Evento evento;
    
    //Gets

    public String getEmissor() {
        return emissor;
    }

    public String getAquemseDestina() {
        return AquemseDestina;
    }

    public int getHoras() {
        return horas;
    }

    public String getNomeDoEvento() {
        return nomeDoEvento;
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

    public void setAquemseDestina(String AquemseDestina) {
        this.AquemseDestina = AquemseDestina;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public void setNomeDoEvento(String nomeDoEvento) {
        this.nomeDoEvento = nomeDoEvento;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    
    
        
}

