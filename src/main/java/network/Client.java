package network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

import javax.net.SocketFactory;


import travelling.model.AttachmentType;
import travelling.model.NetworkMessage;
import travelling.model.User;


public class Client {

	Socket socket;
	ObjectInputStream input;
	ObjectOutputStream output;
	int port=8080;
	
	public Client() {
		SocketFactory factory=SocketFactory.getDefault();
		
		try {
			socket=factory.createSocket();
			
			socket.connect(new InetSocketAddress("localhost", port));
			
			input=new ObjectInputStream(socket.getInputStream());
			output=new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Client done");
	}
	
	public NetworkMessage SendLoginRequest(String user,String password) {
		System.out.println("Sending request");
		NetworkMessage request,response;
		User userToAttach=new User();
		System.out.println("Sending Request 2");
		userToAttach.setUsername(user);
		System.out.println("Sending Request 3");
		userToAttach.setPassword(password);
		
		request=new NetworkMessage();
		request.setAttachment(userToAttach);
		request.setAttachmentType(AttachmentType.USER);
		request.setRequest("Login");
		System.out.println("Sending Request 4");
		return sendRequest(request);
		
	}
	
	private NetworkMessage sendRequest(NetworkMessage request) {
		NetworkMessage response=null;
		System.out.println("Sending Request 5");
		try {
			output.writeObject(request);
			System.out.println("Sending Request 6");
			response=(NetworkMessage) input.readObject();
			System.out.println("Sending Request 7");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Request Sent");		
		return response;
	}
	
	
	
	
}
