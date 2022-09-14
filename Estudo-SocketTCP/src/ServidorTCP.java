import java.net.ServerSocket;
import java.io.*;
import java.net.*;

public class ServidorTCP {
    public static void main(String[] args) throws Exception{
        ServerSocket tomadaServidora = new ServerSocket(4444);
        System.out.println("Aguardando conexões...");
        Socket tomadaCliente = tomadaServidora.accept();

        OutputStream bufferSaida = tomadaCliente.getOutputStream();
        InputStream bufferEntrada = tomadaCliente.getInputStream();

        while(true){
            byte[] textoAEnviar = new byte[32];
            byte[] textoRecebido = new byte[32];

            bufferEntrada.read(textoRecebido);
            String mensagem = new String(textoRecebido).trim();

            if(mensagem.equals("Bye")){
                break;
            }
            mensagem = mensagem.toUpperCase();

            textoAEnviar = mensagem.getBytes();
            bufferSaida.write(textoAEnviar);
            bufferSaida.flush();
        }
        bufferSaida.close();
        bufferEntrada.close();
        tomadaCliente.close();
        tomadaServidora.close();
    }
}
