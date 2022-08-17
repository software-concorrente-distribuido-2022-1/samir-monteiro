/* Defina uma classe Contador como uma subclasse de Thread, que imprime números de 0 a
10. Crie a classe TesteContador que deve definir o método main() que cria e inicia a
execução da thread Contador. Teste o resultado executando a classe TesteContador */
public class TesteContador {
    public static void main(String args[]) {
        Contador contador = new Contador();
        contador.start();
    }
}

class Contador extends Thread {
    public void run(){
        for(int i = 0; i <= 10; i++){
            System.out.println(i);
        }
    }
}

/* Altere as classes Contador e TesteContador de modo que a classe Contador seja definida
como uma implementação da interface Runnable. Teste o resultado. */
public class TesteContador {
    public static void main(String args[]) {
        Contador contador = new Thread(new Contador());
        contador.start();
    }
}

class Contador implements Runnable {
    public void run(){
        for(int i = 0; i <= 10; i++){
            System.out.println(i);
        }
    }
}

/*Altere o método main() da classe TesteContador para criar duas ou mais threads Contador
e inicialize a execução das mesmas */
public class TesteContador {
    public static void main(String args[]) {
        Contador contador1 = new Thread(new Contador());
		Contador contador2 = new Thread(new Contador());
		Contador contador3 = new Thread(new Contador());
		Contador contador4 = new Thread(new Contador());
		contador1.start();
		contador2.start();
		contador3.start();
		contador4.start();
    }
}

class Contador extends Runnable {
	public void run() {
		for(int i = 0; i <= 10; i++) {
			System.out.printlin(i);
		}
	}
}