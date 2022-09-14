import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class ClienteTCP {
    public static void main(String[] args) throws Exception{
        String enderecoServidor = "127.0.0.1";
        int portaServidor = 4444;

        //Criação socket
        Socket tomadaCliente = new Socket(enderecoServidor, portaServidor);

        OutputStream bufferSaida = tomadaCliente.getOutputStream();
        InputStream bufferEntrada = tomadaCliente.getInputStream();

        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            byte[] textoAEnviar = new byte[32];
            byte[] textoRecebido = new byte[32];
            System.out.println("Enviar (digite Bye para terminar): ");

            String mensagem = teclado.readLine();
            textoAEnviar = mensagem.getBytes();
            bufferSaida.write(textoAEnviar);
            bufferSaida.flush();

            if(mensagem.equals("Bye")){
                break;
            }

            bufferEntrada.read(textoRecebido);
            System.out.println("Mensagem do servidor: " + new String(textoRecebido).trim());
        }
        bufferSaida.close();
        bufferEntrada.close();
        teclado.close();
        tomadaCliente.close();
    }
}
