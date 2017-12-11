package network;

import java.io.IOException;
import java.net.Socket;

import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;


public class Client {

	Socket socket;
	int port=8080;
	
	public Client() {
		SocketFactory factory=SSLSocketFactory.getDefault();
		try {
			socket=factory.createSocket();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
}
