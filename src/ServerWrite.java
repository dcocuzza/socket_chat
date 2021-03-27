import java.io.*;
import java.net.*;
import java.nio.*;
import java.util.*;
public class ServerWrite extends Thread{
	private Socket connection;
	private DataInputStream in;
	private DataOutputStream out;
	private BufferedReader tastiera;
	
	public ServerWrite(Socket connection) throws IOException{
		this.connection = connection;
		in = new DataInputStream(this.connection.getInputStream());
		out = new DataOutputStream(this.connection.getOutputStream());
	}
	
	public void run() {
		try {
			String messaggio1;
			tastiera = new BufferedReader(new InputStreamReader(System.in));
			do {
				
				System.out.println("Scrivi a: " + connection.getInetAddress() + ":" + connection.getPort());
				messaggio1 = tastiera.readLine();
				
				out.writeBytes(messaggio1 + "\n");
				
			}while(!messaggio1.equals(""));
			
			
			System.out.println("Connessione chiusa!\n");
			connection.shutdownInput();
			connection.shutdownOutput();
			connection.close();
			
		}
		catch(IOException exception) {
			
		}

	}

}
