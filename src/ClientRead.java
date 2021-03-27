import java.io.*;
import java.net.*;
import java.nio.*;
import java.util.*;
public class ClientRead extends Thread{
	private Socket server;
	private DataInputStream in;
	private DataOutputStream out;
	
	public ClientRead(Socket server) throws IOException{
		this.server = server;
		in = new DataInputStream(server.getInputStream());
		out = new DataOutputStream(server.getOutputStream());
	}
	
	public void run() {
		try {
			String messaggio1;
			do {
				
			    messaggio1 = in.readLine();
			    System.out.println(server.getInetAddress() + ":" + server.getPort() + " = " + messaggio1);

				
			}while(!messaggio1.equals(""));
			
		}
		catch(IOException exception) {
			
		}

	}

}
