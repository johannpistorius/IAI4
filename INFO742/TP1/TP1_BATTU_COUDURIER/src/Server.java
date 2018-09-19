import java.net.*;
import java.text.MessageFormat;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Server {

	public static void main(String[] args) throws Exception {

		try {
			String dataToSend = "";
			
			ServerSocket serverSocket = new ServerSocket(1602);
			System.out.println("ServerSocket");
			Socket connectionSocket = serverSocket.accept();

			
			while(true) {
				BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream())); 
			
				DataOutputStream  outToClient =  new DataOutputStream(connectionSocket.getOutputStream()); 
			    String clientSentence = inFromClient.readLine(); 
			    
			    /* Question 3
			    String capitalizedSentence = clientSentence.toUpperCase() + '\n'; 

			    outToClient.writeBytes(capitalizedSentence); */
			    
			    LocalDateTime currentTime = LocalDateTime.now();

			    // On check l'information reçue par le client
			    switch (clientSentence.toUpperCase()) {
			    case "DATE":
			    	LocalDate date = currentTime.toLocalDate();
			        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
			        dataToSend = date.format(formatter);
			    	break;
			    	
			    case "HOUR":
			    	int heure = currentTime.getHour();
			    	int minutes = currentTime.getMinute();
			    	int seconds = currentTime.getSecond(); 
			    	
			    	dataToSend = MessageFormat.format("{0}h {1}min {2}s", heure, minutes, seconds);
			    	break;
			    	
			    case "MOON":
			    	dataToSend = "IDK";
			    	break;
			    default:
			    	dataToSend = "Unrecognized sentence";
			    	break;
			    }
			    
			    
			    // On envoie l'information au client
			    outToClient.writeBytes(dataToSend + '\n');
			}
			
		}
		
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
		


	}

}
