/*
Nome: Thiago Aparecido Gonçalves da Costa       R.A:537241
      João Ricardo Ito Messias                  R.A:536814
      Leonardo Ademir Tonezi                    R.A:540201
 */
package perceptron;

import java.util.Random;

public class Perceptron {
  
    //atributos
    public double peso[];
    public double Y[];
    
    //construtor
    public Perceptron(int n){
        // criando os objetos
        peso = new double[n+1];
        Random gerador = new Random();
		
        //***************************Pesos entre -1 e 1 do W**********************
        for(int i =0; i < peso.length; i++){
            peso[i] = -1 + (1 - (-1)) * gerador.nextDouble();
            //System.out.printf("peso: "+i+" = "+ peso[i]+"\n");   
        }
    }
    
    //****************Gerando o somatório do Y************************************
    public double somatorio(int entradas[]){
        double s = 0;
        
        for(int i=0; i< peso.length; i++){
            //Verifico se i é igual a zero, pois dessa forma a entrada é igual a 1
            if(i==0){
                s += peso[i] * 1;
            }else{
                s+= peso[i] * entradas[i-1];
            }
        }    
        return s;
    }
    
    //*************************atualizando os resultados, ou seja o Y******************************
    public void atualizarY(int entradas[][]){
        Y = new double[entradas.length];
        
        for(int i=0; i<entradas.length; i++){
            //função = se o resultado for >=0, logo resultado igual a 1, se não resultado igual a 0  
            if(somatorio(entradas[i]) >= 0){
               Y[i] = 1;
            }else{
               Y[i] = 0;
            }
        }
    }
   
    //*******************************Função de Treinamento**************************************
    public void treinar(int entradas [][], int dj [], double eta){
        int conterro;
        while(true){
            //***************************contador de verificação de erro************************
            conterro = 0;
            
            System.out.printf("********TABELA**************\n"); 
            for(int k = 1; k < peso.length; k++){
                System.out.print(" X"+k+"");
            }
            System.out.print(" Yd");
            System.out.print("  Y");
            System.out.print("   E");
            System.out.print("\n");
            
            for(int k = 0; k < entradas.length; k++){  
                for(int l = 0; l < (peso.length)-1; l++){
                    System.out.print(" "+entradas[k][l]+" ");
                }
                System.out.print(" "+dj[k]+" ");
                System.out.print(" "+Y[k]+" ");
                System.out.print(" "+(dj[k] - Y[k])+" ");
                System.out.print("\n");
            }
            
            System.out.printf("******************************\n"); 
            
            
            for(int i=0; i< entradas.length; i++){
                double auxerro = 0;
                //função de erro => E = Yd - Y
                if((dj[i] - Y[i]) != 0){
                    conterro++;
                    auxerro = dj[i] - Y[i];
                    //************************for para atualizar os pesos**********************
                    //******função de atualização de peso: w[t+1] = w[t] + eta * erro * x[t]***
                    System.out.printf("*********CORREÇÃO*************\n"); 
                    for(int j = 0; j < peso.length; j++){
                        //x0 sendo 1
                        if(j==0){
                            peso[j] = peso[j] + eta * auxerro * 1;
                        }else{
                            peso[j] = peso[j] + eta * auxerro * entradas[i][j-1];
                        }
                        System.out.printf("peso: "+j+" = "+ peso[j]+"\n");   
                    }
                    System.out.printf("******************************\n"); 
                }
            }
            
            //Se não tiver mais erros eu saiu do while true
            if(conterro == 0){
                System.out.printf("RECONHECEU! \n");
                break;
            }else{
                atualizarY(entradas);
            }
        }
    }
}
