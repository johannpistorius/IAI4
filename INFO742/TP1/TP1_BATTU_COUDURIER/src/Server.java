import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SuppressWarnings("InfiniteLoopStatement")
public class Server {

    public static void main(String[] args) throws IOException {

        try {
            System.out.println("Server initialized");
            ServerSocket server = new ServerSocket(1600);

            while (true) {
                // On créé une socket
                Socket socket = server.accept();

                // On ouvre un flux sur l'entrée (in)
                // InputStream -> InputStreamReader -> BufferedReader
                InputStream inputStream = socket.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                // Attente d'un message du client
                String message = bufferedReader.readLine();

                // Traitement
                String reponse = "";

                LocalDateTime currentTime = LocalDateTime.now();
                switch (message.toUpperCase()) {
                    case "DATE":
                        LocalDate date = currentTime.toLocalDate();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
                        reponse = date.format(formatter);
                        break;

                    case "HOUR":
                        int heure = currentTime.getHour();
                        int minutes = currentTime.getMinute();
                        int seconds = currentTime.getSecond();

                        reponse = MessageFormat.format("{0}h {1}min {2}s", heure, minutes, seconds);
                        break;

                    case "MOON":
                        reponse = "IDK";
                        break;
                    default:
                        reponse = "Unrecognized sentence";
                        break;
                }

                // On ouvre un flux sur la sortie (out)
                // OutputStream -> DataOutputStream
                OutputStream outputStream = socket.getOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                dataOutputStream.writeBytes(reponse + "\n");
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }
}
