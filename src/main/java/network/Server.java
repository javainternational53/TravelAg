package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLServerSocketFactory;

import persistence.PersistenceManager;
import travelling.model.User;


public class Server implements Runnable {

	private ArrayList<Thread> connections;
	private ServerSocket serverSocket;
	private int port;
	private boolean running;
	
	void createTestUser(){
		User user = PersistenceManager.getUserByName("testuser99");
		System.out.println(user);
		if(user == null) {
			user=new User();
			user.setUsername("testuser99");
			user.setPassword("testPass");
			user.setFirstName("Johnny");
			user.setLastName("Test");
			user.setEmail("jtest@testmail.com");
			user.setBankCard("1234-5678-9101-1121");
			PersistenceManager.createUser(user);
		}
	}
	
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
		createTestUser();
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
				System.out.println("Ready for connection");
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
