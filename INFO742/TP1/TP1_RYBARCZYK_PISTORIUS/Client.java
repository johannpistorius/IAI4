import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.util.Date;

public class Client implements Runnable{

   private Socket sock;
   private PrintWriter writer = null;
   private BufferedInputStream reader = null;
   
   public Client(Socket pSock){
      sock = pSock;
   }
   
   public void run(){
      System.err.println("Lancement du traitement de la connexion cliente");

      boolean closeConnexion = false;
      //tant que la connexion est active, on traite les demandes
      while(!sock.isClosed()){
         
         try {
            writer = new PrintWriter(sock.getOutputStream());
            reader = new BufferedInputStream(sock.getInputStream());
            
            //On attend la demande du client            
            String response = read();
            InetSocketAddress remote = (InetSocketAddress)sock.getRemoteSocketAddress();
            
            //On affiche les infos sur la connexion
            String debug = "";
            debug = "Thread : " + Thread.currentThread().getName() + ". ";
            debug += "Demande de l'adresse : " + remote.getAddress().getHostAddress() +".";
            debug += " Sur le port : " + remote.getPort() + ".\n";
            debug += "\t -> Commande re�ue : " + response + "\n";
            System.err.println("\n" + debug);
            String toSend="";
	        switch(response.toUpperCase()){
	            case "DATE?;":
	               toSend = DateFormat.getDateInstance(DateFormat.FULL).format(new Date());
	               break;
	            case "HOUR?;":
	               toSend = DateFormat.getTimeInstance(DateFormat.MEDIUM).format(new Date());
	               break;
	            case "MOON?;":
	               toSend = "I don't know!";
	               break;
	            default : 
	               toSend = "Commande inconnu !";                     
	               break;
	        }
	        writer.write(toSend);
            writer.flush();
            if(closeConnexion){
               System.err.println("COMMANDE CLOSE DETECTEE ! ");
               writer = null;
               reader = null;
               sock.close();
               break;
            }
         }catch(SocketException e){
            System.err.println("LA CONNEXION A ETE INTERROMPUE ! ");
            break;
         } catch (IOException e) {
            e.printStackTrace();
         }         
      }
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