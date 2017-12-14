package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLServerSocketFactory;


public class Server implements Runnable {

	private ArrayList<Runnable> connections;
	private ServerSocket serverSocket;
	private int port;
	private boolean running;
	
	public ArrayList<Runnable> getConnections() {
		return connections;
	}

	public void setConnections(ArrayList<Runnable> connections) {
		this.connections = connections;
	}
	
	public ServerSocket getServerSocket() {
		return serverSocket;
	}
	
	public void setServerSocket(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}
	
	public int getPort() {
		return port;
	}
	
	public void setPort(int port) {
		this.port = port;
	}
	
	public Server() {
		this.port = 8080;
		try {
			ServerSocketFactory factory=SSLServerSocketFactory.getDefault();
			serverSocket=factory.createServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connections=new ArrayList<Runnable>();
	}
	
	@Override
	public void run() {
		System.out.println("Server started");
		while(running) {
			try {
				Socket socket=serverSocket.accept();
				ClientServingThread newThread=new ClientServingThread(socket);
				newThread.run();
				connections.add(newThread);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}
	
	
	
}
