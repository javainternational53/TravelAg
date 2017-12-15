package network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import org.mindrot.jbcrypt.BCrypt;

import persistence.PersistenceManager;
import travelling.model.AttachmentType;
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
		System.out.println("Clientservingthread...");
		try {
			socketOutput=new ObjectOutputStream(socket.getOutputStream());
			socketInput=new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Clientservingthread done");
		running=true;
	}

	@Override
	public void run() {
		while(running) {
			try {
				System.out.println("Thread running...");
				NetworkMessage message = (NetworkMessage) socketInput.readObject();
				System.out.println("Thread is still running");
				socketOutput.writeObject(processMessage(message));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				running=false;
				e.printStackTrace();
				
			}catch(Exception e) {
				running=false;
				e.printStackTrace();
			}
			
			
		}

	}
	
	private NetworkMessage processMessage(NetworkMessage message){
		System.out.println(message);
		NetworkMessage messageToReturn=new NetworkMessage();
		messageToReturn.setRequest("failure");
		if(message.getRequest().equals("Login"));{
			User userToLogin=(User)message.getAttachment();
			User foundUser=PersistenceManager.getUserByName(userToLogin.getUsername());
			if(BCrypt.checkpw(userToLogin.getPassword(), foundUser.getPassword())) {
				foundUser.setPassword("");
				messageToReturn.setRequest("Login response");
				messageToReturn.setAttachment(foundUser);
				messageToReturn.setAttachmentType(AttachmentType.USER);
			}
				
		}
		
		return messageToReturn;
	}

}
