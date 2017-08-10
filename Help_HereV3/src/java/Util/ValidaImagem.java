package Util;


import java.util.Date;

public class ValidaImagem {
    public boolean status=false;
    public String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public void validar(){
        Date dataAtual = new Date();
        String gerado ="-"+dataAtual.getDate()+"-"+dataAtual.getDay()+"-"+dataAtual.getYear()+"-"+dataAtual.getHours()+"-"+dataAtual.getMinutes()+"-"+dataAtual.getSeconds();
        
        int tamanho = nome.length();

        nome = nome.toUpperCase();
        
        if(nome.substring(tamanho-4).length()==4){
            String extensao = nome.substring(tamanho-4);
            String nomeAtual = nome.substring(0, tamanho-4);
            switch (extensao) {
                    case ".JPG":
                        nome = nomeAtual+gerado+".jpg";
                        status = true;
                        break;
                   
                    case ".PNG":
                        nome = nomeAtual+gerado+".png";
                        status = true;
                        break;
            } 
        }
        if(nome.substring(tamanho-5).length()==5){
           String extensao = nome.substring(tamanho-5);
           String nomeAtual = nome.substring(0, tamanho-5);
           
           switch (extensao) {
                    case ".JPEG":
                        nome = nomeAtual+gerado+".jpeg";
                        status = true;
                        break;
                   
                    case ".JPG2":
                        nome = nomeAtual+gerado+".jpg2";
                        status = true;
                        break;
            }
        }
    }
}
