package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLServerSocketFactory;


public class Server implements Runnable {

	private ArrayList<Thread> connections;
	private ServerSocket serverSocket;
	private int port;
	private boolean running;
	
	
	
	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public ArrayList<Thread> getConnections() {
		return connections;
	}

	public void setConnections(ArrayList<Thread> connections) {
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
			
			ServerSocketFactory factory=ServerSocketFactory.getDefault();
			serverSocket=factory.createServerSocket(port);
			running=true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connections=new ArrayList<Thread>();
	}
	
	@Override
	public void run() {
		System.out.println("Server started");
		while(running) {
			try {
				
				Socket socket=serverSocket.accept();
				System.out.println("new Socket is applying");
				ClientServingThread newServer=new ClientServingThread(socket);
				System.out.println("Socket created");
				Thread newThread=new Thread(newServer);
				System.out.println("socket running");
				newThread.start();
				sortConnections();
				connections.add(newThread);
				System.out.println("You can't stop socket now MWahahahaha...");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}

	private void sortConnections() {
		for(Thread t : connections) 
		{
			if(!t.isAlive()) 
			{
				connections.remove(t);
			}
			
		}
		
	}
	
	
	
}
