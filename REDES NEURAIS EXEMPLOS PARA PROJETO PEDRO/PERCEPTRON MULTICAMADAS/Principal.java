/*
Nome: Thiago Aparecido Gonçalves da Costa       R.A:537241
      João Ricardo Ito Messias                  R.A:536814
      Leonardo Ademir Tonezi                    R.A:540201
 */

package perceptron;
import static java.lang.System.exit;
import java.util.Scanner; 

public class Principal {
    
   
    
    public static void main(String[] args) {
         
        Scanner scan = new Scanner(System.in);
        int escolha;
            
        
        
        System.out.print("O que você deseja treinar: 1)AND - 2)OR - 3)XOR - 4)Letra A ou T - 0)Sair");
        escolha = scan.nextInt();
        System.out.println(escolha);
        
        switch(escolha){
            
            case(1):
                //*******************AND*******************
                int padroes1 [][]= {
                                {0,0},
                                {0,1},
                                {1,0},
                                {1,1}
                };

                int dj1[] = {
                            0,
                            0,
                            0,
                            1
                            };
                
                //cria um Perceptron com 2 entradas
                Perceptron p1 = new Perceptron(2);
                
                //eta = 0.2
                p1.atualizarY(padroes1);
                p1.treinar(padroes1,dj1,0.2);
                break;
                //*****************************************
            case(2):
               //*******************OR*********************
                int padroes2 [][]= {
                                {0,0},
                                {0,1},
                                {1,0},
                                {1,1}
                };

                int dj2[] = {
                            0,
                            1,
                            1,
                            1
                            };
                
                //cria um Perceptron com 2 entradas
                Perceptron p2 = new Perceptron(2);
                
                //eta = 0.2
                p2.atualizarY(padroes2);
                p2.treinar(padroes2,dj2,0.2);
                break;
                //******************************************
            
            case(3):
               //*******************OR*********************
                int padroes3 [][]= {
                                {0,0},
                                {0,1},
                                {1,0},
                                {1,1}
                };

                int entradasp3[][] = {
                                {0,1},
                                {1,0},    
                                {1,1}
                };
                
                int dj3_1[] = {
                            1,
                            1,
                            1,
                            0
                            };
                int dj3_2[] = {
                            0,
                            1,
                            1,
                            1
                            };
                int dj3_3[] = {
                            0,
                            0,
                            1
                            };
                
                //cria um Perceptron com 2 entradas
                Perceptron p3_1 = new Perceptron(2);
                Perceptron p3_2 = new Perceptron(2);
                Perceptron p3_3 = new Perceptron(2);
                
                //eta = 0.2
               
                p3_1.atualizarY(padroes3);
                p3_1.treinar(padroes3, dj3_1, 0.2);
                p3_2.atualizarY(padroes3);
                p3_2.treinar(padroes3, dj3_2, 0.2);
                p3_3.atualizarY(entradasp3);
                p3_3.treinar(entradasp3, dj3_3, 0.2);
                
                //************NEURÔNIO DE MULTICAMADAS**********************
                
                System.out.println("******************************");
                int x1[] = {0,0};
                int rx1_1 = ativacaoY(p3_1.somatorio(x1));
                int rx1_2 = ativacaoY(p3_2.somatorio(x1));
                int ex1[] = {rx1_1,rx1_2};
                System.out.println("Saída para 0,0: "+ativacaoY(p3_3.somatorio(ex1)));
                
                int x2[] = {1,0};
                int rx2_1 = ativacaoY(p3_1.somatorio(x2));
                int rx2_2 = ativacaoY(p3_2.somatorio(x2));
                int ex2[] = {rx2_1,rx2_2};
                System.out.println("Saída para 1,0: "+ativacaoY(p3_3.somatorio(ex2)));
                
                int x3[] = {0,1};
                int rx3_1 = ativacaoY(p3_1.somatorio(x3));
                int rx3_2 = ativacaoY(p3_2.somatorio(x3));
                int ex3[] = {rx3_1,rx3_2};
                System.out.println("Saída para 0,1: "+ativacaoY(p3_3.somatorio(ex3)));
                
                int x4[] = {1,1};
                int rx4_1 = ativacaoY(p3_1.somatorio(x4));
                int rx4_2 = ativacaoY(p3_2.somatorio(x4));
                int ex4[] = {rx4_1,rx4_2};
                System.out.println("Saída para 1,1: "+ativacaoY(p3_3.somatorio(ex4)));
                
                
               
                break;
                //******************************************    
                
            case(4):
                //*******************LETRA A ou T***********
                int padroes4 [][]= {
                                {1,1,1,1,1,
                                 1,0,0,0,1,
                                 1,0,0,0,1,
                                 1,1,1,1,1,
                                 1,0,0,0,1},
                                {1,1,1,1,1,
                                 0,0,1,0,0,
                                 0,0,1,0,0,
                                 0,0,1,0,0,
                                 0,0,1,0,0},


                };

                int dj4[] = {
                            0,
                            1
                            };
                
                //cria um Perceptron com 25 entradas
                Perceptron p4 = new Perceptron(25);
                
                //eta = 0.2
                p4.atualizarY(padroes4);
                p4.treinar(padroes4,dj4,0.2);
                break;
                //******************************************
                case(0):
                    exit(1);
                    break;
                default:
                    System.out.println("Informe uma opção válida!");
                    break;          
        } 
       
    }
    
    public static int ativacaoY(double x){
        int r = 0; 
        
        if(x>=0){
         r = 1;   
        }
        
        return r;
    }

}
