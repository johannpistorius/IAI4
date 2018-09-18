import java.io.IOException;
import java.util.Scanner;

public class Main {

   public static void main(String[] args) throws IOException {
    
      String host = "localhost";
      int port = 1600;
      
      Server s = new Server(host, port);
      s.open();
      
      System.out.println("Serveur initialisé.");
      
      ClientCoo c =new ClientCoo(host, port);
      c.run();
      
   }
   
}