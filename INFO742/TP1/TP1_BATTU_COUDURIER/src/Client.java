import java.net.*;
import java.io.*;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
			
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		Socket client = new Socket("localhost", 1602);
		
		while(!client.isClosed()) {
			DataOutputStream outToServer = new DataOutputStream(client.getOutputStream());
			
			BufferedReader inFromServer = new BufferedReader(new InputStreamReader(client.getInputStream())); 
	
			String sentence = inFromUser.readLine(); 
	
			outToServer.writeBytes(sentence + '\n'); 
	        String modifiedSentence = inFromServer.readLine(); 
	        
	        System.out.println("FROM SERVER: " + modifiedSentence); 
		}
        client.close();
	}
}
