import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.RemoteException;

public class ThreadsSocket extends Thread{

    private Socket socket;

    public ThreadsSocket(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName());
        try {
            OutputStream bufferSaida = socket.getOutputStream();
            InputStream bufferEntrada = socket.getInputStream();

            while (true) {
                byte[] textoAEnviar = new byte[32];
                byte[] textoRecebido = new byte[32];

                bufferEntrada.read(textoRecebido);
                String mensagem = new String(textoRecebido).trim();

                if (mensagem.equals("Bye")) {
                    break;
                }
                mensagem = mensagem.toUpperCase();

                textoAEnviar = mensagem.getBytes();
                bufferSaida.write(textoAEnviar);
                bufferSaida.flush();
            }
            bufferSaida.close();
            bufferEntrada.close();
            socket.close();
            socket.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
