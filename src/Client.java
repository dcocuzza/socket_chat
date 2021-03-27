import java.net.*;
import java.io.*;
public class Client {
	Socket server;
	int porta = 50000; //porta server
	DataInputStream in;
	DataOutputStream out;
	BufferedReader tastiera;
	
	public Socket connessione(){
		
			try {
				System.out.println("Connessione al server...");
				
				server = new Socket(InetAddress.getLocalHost(), porta);
				
				System.out.println("Connesso");
				
				ClientRead cr = new ClientRead(server);
				ClientWrite cw = new ClientWrite(server);
				cr.start();
				cw.start();
				
				
			} catch (UnknownHostException e) {
				System.err.println("Host sconosciuto");
			} catch (IOException e) {
				System.err.println("Errore generico");
			}
			
			
			
			return server;
		
		
	}
	
	public void comunicazione() {	
		try {
			String invio;
			tastiera = new BufferedReader(new InputStreamReader(System.in));
			do {
				
				System.out.print("Messaggio da inviare al server: "); 
				
				invio = tastiera.readLine();
				
				out.writeBytes(invio + "\n");
				
			}while(!invio.equals(""));
			
			
		} catch (IOException e) {
			System.err.println("Errore");
		}
	}

	public static void main(String[] args) {
	     Client c = new Client();
	     c.connessione();
	   
	}

}
