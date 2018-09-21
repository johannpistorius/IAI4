import java.io.*;
import java.net.Socket;
import java.text.MessageFormat;
import java.util.Scanner;

@SuppressWarnings("InfiniteLoopStatement")
public class Client {

    public static void main(String[] args) throws IOException {

        try {
            while (true) {
                // On créé une socket
                Socket socket = new Socket("localhost", 1600);

                // Lecture du message entré par l'utilisateur
                Scanner scanner = new Scanner(System.in);
                System.out.println("Entrez votre message");
                String message = scanner.nextLine();

                // Envoie du message au serveur (out)
                // OutputSteam -> DataOutPutStream
                OutputStream outputStream = socket.getOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                dataOutputStream.writeBytes(message + "\n"); // Attention au retour chariot

                // Ouvre un flux sur l'entrée, permet de lire les informations envoyés par le serveur (in)
                // InputStream -> InputStreamReader -> BufferedReader
                InputStream inputStream = socket.getInputStream();
                InputStreamReader inputStreamReader1 = new InputStreamReader(inputStream);
                BufferedReader bufferedReader1 = new BufferedReader(inputStreamReader1);

                String messageRecu = bufferedReader1.readLine();

                System.out.println(MessageFormat.format("From server : {0}", messageRecu));

            }

        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
