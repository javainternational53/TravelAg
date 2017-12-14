package network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;

import travelling.model.AttachmentType;
import travelling.model.NetworkMessage;
import travelling.model.User;


public class Client {

	Socket socket;
	ObjectInputStream input;
	ObjectOutputStream output;
	int port=8080;
	
	public Client() {
		SocketFactory factory=SSLSocketFactory.getDefault();
		try {
			socket=factory.createSocket();
			socket.connect(new InetSocketAddress(InetAddress.getLocalHost(), port));
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
		userToAttach.setUsername(user);
		userToAttach.setPassword(password);
		request=new NetworkMessage();
		request.setAttachment(user);
		request.setAttachmentType(AttachmentType.USER);
		request.setRequest("Login");
		return sendRequest(request);
		
	}
	
	private NetworkMessage sendRequest(NetworkMessage request) {
		NetworkMessage response=null;
		try {
			output.writeObject(request);
			response=(NetworkMessage) input.readObject();
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
