
package Model;

import java.util.ArrayList;

public class Notificacao {
    private Evento e;
    private ArrayList<Pessoa> pessoasNotificar;
    
    
    //Sets
    public void setE(Evento e) {
        this.e = e;
    }
    public void setUsersNotificados(ArrayList<Pessoa> usersNotificados) {
        this.pessoasNotificar = usersNotificados;
    }
    
    
    //Gets
    public Evento getE() {
        return e;
    }
    public ArrayList<Pessoa> getUsersNotificados() {
        return pessoasNotificar;
    }
   
}
