package Util;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConvertData {
    
    
    
    public static Date converteStringParaDate(String data ){
    
        
        try {
            SimpleDateFormat df = new SimpleDateFormat("dd/mm/yyyy");
            
            
            return df.parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(ConvertData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    
    public static java.sql.Date converteDataParaBanco(Date data){
        
        return new java.sql.Date(data.getTime());
    }
    
    
}
