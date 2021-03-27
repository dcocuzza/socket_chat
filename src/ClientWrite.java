import java.io.*;
import java.net.*;
import java.nio.*;
import java.util.*;
public class ClientWrite extends Thread{
	private Socket server;
	private DataInputStream in;
	private DataOutputStream out;
	private BufferedReader tastiera;
	
	public ClientWrite(Socket server) throws IOException{
		this.server = server;
		in = new DataInputStream(server.getInputStream());
		out = new DataOutputStream(server.getOutputStream());
	}
	
	public void run() {
		try {
			String invio;
			tastiera = new BufferedReader(new InputStreamReader(System.in));
			do {
				
				System.out.print("Messaggio da inviare al server: \n"); 
				
				invio = tastiera.readLine();
				
				out.writeBytes(invio + "\n");
				
			}while(!invio.equals(""));
			
			
		} catch (IOException e) {
			System.err.println("Errore");
		}
	}

}
