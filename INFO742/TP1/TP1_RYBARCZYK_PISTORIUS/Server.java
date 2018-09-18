import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Server {
	   //On initialise des valeurs par défaut
	   private int port = 1600;
	   private String host = "127.0.0.1";
	   private ServerSocket serverSocket = null;
	   private boolean isRunning = true;
	   
	   public Server(){
	      try {
	    	  serverSocket = new ServerSocket(port, 100, InetAddress.getByName(host));
	      } catch (UnknownHostException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	   }
	   
	   public Server(String pHost, int pPort){
	      host = pHost;
	      port = pPort;
	      try {
	    	  serverSocket = new ServerSocket(port, 100, InetAddress.getByName(host));
	      } catch (UnknownHostException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	   }
	   //On lance notre serveur
	   public void open() throws IOException{
           // Question 1
           /*Socket connectionSocket = serverSocket.accept();

           //Create Input&Outputstreams for the connection
           InputStream inputToServer = connectionSocket.getInputStream();
           OutputStream outputFromServer = connectionSocket.getOutputStream();
           Scanner scanner = new Scanner(inputToServer, "UTF-8");
           PrintWriter serverPrintOut = new PrintWriter(new OutputStreamWriter(outputFromServer, "UTF-8"), true);

           serverPrintOut.println("Hello World!Enter goodbye to exit");

           //Have the server take input from the client and echo it back
           //This should be placed in a loop that listens for a terminator text e.g. bye
           boolean done = false;

           while(!done && scanner.hasNextLine()) {
               String line = scanner.nextLine();
               serverPrintOut.println("Echo from Server: " + line);

               if(line.toLowerCase().trim().equals("goodbye")) {
                   done = true;
               }
           }*/
		   
		   
		   
	      //Toujours dans un thread à part vu qu'il est dans une boucle infinie
		  
	      Thread t = new Thread(new Runnable(){
	         public void run(){
	            boolean isRunning= true;
	            while(isRunning == true){ 
	                try {
	                    //On attend une connexion d'un client
	                    Socket client = serverSocket.accept();
	                    //Une fois reçue, on la traite dans un thread séparé
	                    System.out.println("Connexion cliente reçue.");                  
	                    Client c =new Client(client);
	                    c.run();
	                    
	                 } catch (IOException e) {
	                    e.printStackTrace();

	                 }
	             }
	            
	            try {
	            	serverSocket.close();
	             } catch (IOException e) {
	                e.printStackTrace();
	                serverSocket = null;
	             }
	          }
	       });
	       
	       t.start();
	    }
	    
	    public void close(){
	       isRunning = false;
	    }  
	                  
	    
}