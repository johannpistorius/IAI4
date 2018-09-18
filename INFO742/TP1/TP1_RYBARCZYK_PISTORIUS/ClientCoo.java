import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.Scanner;

public class ClientCoo implements Runnable{

   private Socket connexion = null;
   private PrintWriter writer = null;
   private BufferedInputStream reader = null;
   
   //Notre liste de commandes. Le serveur nous r�pondra diff�remment selon la commande utilis�e.
   private String[] listCommands = {"DATE?;", "HOUR?;", "MOON?;"};
   private static int count = 0;
   private String name = "Client-";    
   
   public ClientCoo(String host, int port){
      name += ++count;
      try {
         connexion = new Socket(host, port);
      } catch (UnknownHostException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
    
   public void run(){
         try {
            writer = new PrintWriter(connexion.getOutputStream(), true);
            reader = new BufferedInputStream(connexion.getInputStream());
            //On envoie la commande au serveur
            //Question 3
            /*
            Scanner sc = new Scanner(System.in);
            System.out.println("Veuillez saisir un mot :");
            String str = sc.nextLine();
            writer.write(str);
            writer.flush();  
            
            System.out.println("Commande " + str + " envoy�e au serveur");*/
            
            //Question 4
            String commande = getCommand();
            writer.write(commande);
            writer.flush();  
            
            System.out.println("Commande " + commande + " envoy�e au serveur");
        
            //On attend la r�ponse
            String response = read();
            System.out.println("\t * " + name + " : R�ponse re�ue " + response);
            
         } catch (IOException e1) {
            e1.printStackTrace();
         }
      writer.write("CLOSE");
      writer.flush();
      writer.close();
   }
   //M�thode qui permet d'envoyer des commandes de fa�on al�atoire
   private String getCommand(){
      Random rand = new Random();
      return listCommands[rand.nextInt(listCommands.length)];
   }
   //pour lire les r�ponses
   private String read() throws IOException{      
      String response = "";
      int stream;
      byte[] b = new byte[4096];
      stream = reader.read(b);
      response = new String(b, 0, stream);
      return response;
   } 
}