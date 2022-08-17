import java.lang.Math;

public class Lebre {
    public static int posicao = 1;
    
    public static void main(String args[]) {
        Corrida corrida1 = new Corrida();
        LebreThread lebre1 = new LebreThread("Lebre 01", corrida1);
        LebreThread lebre2 = new LebreThread("Lebre 02", corrida1);
        LebreThread lebre3 = new LebreThread("Lebre 03", corrida1);
        LebreThread lebre4 = new LebreThread("Lebre 04", corrida1);
        LebreThread lebre5 = new LebreThread("Lebre 05", corrida1);
        lebre1.start();
        lebre2.start();
        lebre3.start();
        lebre4.start();
        lebre5.start();
    }
}

 class Corrida{
        public void fim(String nome, int pulos){
            if(MyClass.posicao == 1){
                System.out.println("A lebre " + nome + " ganhou a corrida com " + pulos + " pulos");
                MyClass.posicao++;
            }
            else{
                System.out.println("A lebre " + nome + " ficou na " + MyClass.posicao + " posição e deu um total de " + pulos + " pulos");
                MyClass.posicao++;
            }
        }
 }

class LebreThread extends Thread{
    String nome;
    Corrida corrida;
    int distanciaTotal;
    int pulos;
    
    public LebreThread (String nome, Corrida corrida){
        this.nome = nome;
        this.corrida = corrida;
    }

    public void run(){
        while(distanciaTotal < 20){
            int distanciaPercorrida = (int)(Math.random() * 3) + 1;
            distanciaTotal += distanciaPercorrida;
            System.out.println("Distancia percorida: " + distanciaPercorrida + " - " + this.nome);
            this.pulos++;
            this.yield();
        }
        corrida.fim(this.nome, pulos);
    }
}