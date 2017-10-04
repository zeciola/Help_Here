/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Diego
 */
public class GeraNumero {
    private int n1;
    private int n2;
    private int n3;
    private int n4;
    private int n5;
    
    public String GeraNumero(String origem){
        
        String N5 = origem.substring(origem.length()-4, origem.length());
        n5 = Integer.parseInt(N5);
        //System.out.println(N5);
        
        String N4 = origem.substring(origem.length()-9, origem.length()-5);
        n4 = Integer.parseInt(N4);
        //System.out.println(N4);    
        
        String N3 = origem.substring(origem.length()-14, origem.length()-10);
        n3 = Integer.parseInt(N3);
        //System.out.println(N3);
            
        String N2 = origem.substring(origem.length()-19, origem.length()-15);
        n2 = Integer.parseInt(N2);
        //System.out.println(N2);
            
        String N1 = origem.substring(origem.length()-24, origem.length()-20);
        n1 = Integer.parseInt(N1);
        //System.out.println(N1);
        
        if(n5 == 9999){         
            n5 = 0000;
            if(n4 == 9999){
                n4 = 0000;
                if(n3 == 9999){
                    n3 = 0000;
                    if(n2 == 9999){
                        n2 =0000;
                        if(n1 == 9999){
                            n1 =0000;
                        }
                        else{
                            n1++;
                        }
                    }else{
                        n2++;
                    }
                }else{
                    n3++;
                }                
            }else{
                n4++;
            }
        }else{
            n5++;
        }
        
        String retorno = String.format("%04d", n1)+"."+String.format("%04d", n2)+"."+String.format("%04d", n3)+"."+String.format("%04d", n4)+"."+String.format("%04d", n5);
        return retorno;
    }
}
