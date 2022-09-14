package Cliente;

import java.rmi.Naming;

public class ClienteRMI {
    public static void main(String[] args) throws Exception {
        String objName = "rmi://localhost:1099/Calc";
        ICalculadora calc = (ICalculadora) Naming.lookup(objName);
        System.out.println("O resultado da soma é: " + calc.adicao(1, 2));
    }
}
