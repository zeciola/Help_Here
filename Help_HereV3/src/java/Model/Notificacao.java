
package Model;

import java.util.ArrayList;

public class Notificacao {
    private Evento e;
    private ArrayList<Pessoa> pessoasNotificar;
    
    public Evento getE() {
        return e;
    }
    
    public void setE(Evento e) {
        this.e = e;
    }
    
    public ArrayList<Pessoa> getUsersNotificados() {
        return pessoasNotificar;
    }
    
    public void setUsersNotificados(ArrayList<Pessoa> usersNotificados) {
        this.pessoasNotificar = usersNotificados;
    }
}
