
package Model;

import java.util.ArrayList;

public class Notificacao {
    private Evento e;
    private ArrayList<Pessoa> usersNotificados;
    
    public Evento getE() {
        return e;
    }
    
    public void setE(Evento e) {
        this.e = e;
    }
    
    public ArrayList<Pessoa> getUsersNotificados() {
        return usersNotificados;
    }
    
    public void setUsersNotificados(ArrayList<Pessoa> usersNotificados) {
        this.usersNotificados = usersNotificados;
    }
}
