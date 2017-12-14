package network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import travelling.model.NetworkMessage;
import travelling.model.User;

public class ClientServingThread implements Runnable {

	Socket socket;
	ObjectInputStream socketInput;
	ObjectOutputStream socketOutput;
	User associatedUser;
	private boolean running;
	
	public ClientServingThread(Socket socket) {
		super();
		this.socket = socket;
		try {
			socketInput=new ObjectInputStream(socket.getInputStream());
			socketOutput=new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

	@Override
	public void run() {
		while(running) {
			try {
				NetworkMessage message = (NetworkMessage) socketInput.readObject();
				System.out.println("Thread running");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}

	}
	
	private NetworkMessage processMessage(NetworkMessage message){
		NetworkMessage messageToReturn=null;
		
		
		
		return messageToReturn;
	}

}
