package Servidor;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class ServidorRMI {
    public static void main(String[] args) {
        try {
            ICalculadora calc = new Calculadora();
            String objName = "rmi://localhost/Calc";

            System.out.println("Registrando o objeto no RMIRegistry...");
            LocateRegistry.createRegistry(1099);
            Naming.rebind(objName, calc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}