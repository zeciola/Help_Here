package Command.ContribuirAction;

import Command.ICommand;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DoarCondicional implements ICommand{

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        //receber dados do doador
        
        //vincular ao banco 
        
        //gerar boleto
        
        //redirecionar
        
        return "ok.jsp";
    }
    
}
