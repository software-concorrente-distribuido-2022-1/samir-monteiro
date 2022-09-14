import java.net.ServerSocket;
import java.io.*;
import java.net.*;

public class ServidorTCP {
    public static void main(String[] args) throws Exception{
        ServerSocket tomadaServidora = new ServerSocket(4444);
        System.out.println("Aguardando conexoes...");
        while(true) {
            Socket tomadaCliente = tomadaServidora.accept();

            ThreadsSocket thread = new ThreadsSocket(tomadaCliente);
            thread.run();
        }
    }
}
