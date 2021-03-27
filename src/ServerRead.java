import java.io.*;
import java.net.*;
import java.nio.*;
import java.util.*;
public class ServerRead extends Thread{
	private Socket connection;
	private DataInputStream in;
	private DataOutputStream out;
	
	public ServerRead(Socket connection) throws IOException{
		this.connection = connection;
		in = new DataInputStream(this.connection.getInputStream());
		out = new DataOutputStream(this.connection.getOutputStream());
	}
	
	public void run() {
		try {
			String messaggio1;
			do {
				
				messaggio1 = "";
			    messaggio1 = in.readLine();
			    System.out.println(connection.getInetAddress() + ":" + connection.getPort() + " = " + messaggio1);

				
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
