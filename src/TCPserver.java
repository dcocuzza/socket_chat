import java.io.*;
import java.net.*;
public class TCPserver extends Thread{
	int porta = 50000;
	private ServerSocket server = null;
	Socket client = null;
	
	public void run() {
		
		try {
			System.out.println("Inizializzazione server...");
			server = new ServerSocket(porta);
			System.out.println("Server in ascolto sulla porta: " + porta);
			while(!Thread.interrupted()) {
				
			    client = server.accept(); 
			
			    System.out.println("Connessione stabilita: " + client.getInetAddress() + ":" + client.getPort());
			    ServerRead sr = new ServerRead(client);
			    ServerWrite sw = new ServerWrite(client);
			    sr.start();
			    sw.start();
			}
			
			server.close();
					
					
		} catch (IOException e) {
			
		}

		
	}
	
	public static void main (String[] args) {
		
		TCPserver server = new TCPserver ();
		server.start();
	    
		
		
	}
}

