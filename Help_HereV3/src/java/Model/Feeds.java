package Model;
import java.sql.Date;

public class Feeds {
    
    private int idEV;
    private String NomeEvento;
    private Date datainiev;
    private Date datafimev;

    public int getIdEV() {
        return idEV;
    }

    public void setIdEV(int idEV) {
        this.idEV = idEV;
    }

    public String getNomeEvento() {
        return NomeEvento;
    }

    public void setNomeEvento(String NomeEvento) {
        this.NomeEvento = NomeEvento;
    }

    public Date getDatainiev() {
        return datainiev;
    }

    public void setDatainiev(Date datainiev) {
        this.datainiev = datainiev;
    }

    public Date getDatafimev() {
        return datafimev;
    }

    public void setDatafimev(Date datafimev) {
        this.datafimev = datafimev;
    }
}
