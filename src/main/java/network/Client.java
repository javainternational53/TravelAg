package network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;

import javax.net.SocketFactory;

import travelling.model.AttachmentType;
import travelling.model.BookedTravel;
import travelling.model.NetworkMessage;
import travelling.model.User;

public class Client {

	Socket socket;
	ObjectInputStream input;
	ObjectOutputStream output;
	int port = 8080;

	public Client() {
		SocketFactory factory = SocketFactory.getDefault();

		try {
			socket = factory.createSocket();
			socket.connect(new InetSocketAddress("localhost", port));

			input = new ObjectInputStream(socket.getInputStream());
			output = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Client done");
	}

	public User SendLoginRequest(String user, String password) {
		User userToReturn = null;
		NetworkMessage request, response;
		User userToAttach = new User();

		userToAttach.setUsername(user);
		userToAttach.setPassword(password);
		request = new NetworkMessage();
		request.setAttachment(userToAttach);
		request.setAttachmentType(AttachmentType.USER);
		request.setRequest("Login");
		response = sendRequest(request);
		if (!response.getRequest().equals("Failure")) {
			userToReturn = (User) response.getAttachment();
		}
		return userToReturn;

	}

	public NetworkMessage SendSignupRequest(User user) {
		NetworkMessage request, response;

		request = new NetworkMessage();
		request.setAttachment(user);
		request.setAttachmentType(AttachmentType.USER);
		request.setRequest("Signup");

		return sendRequest(request);

	}

	public NetworkMessage sendSaveBookingRequest(BookedTravel travel) {
		NetworkMessage request, response = null;
		request = new NetworkMessage();

		request.setRequest("Save booking");
		request.setAttachment(travel);
		response = sendRequest(request);

		return response;
	}

	public List SendGetAllOffersRequest() {
		NetworkMessage request, response;

		request = new NetworkMessage();

		request.setRequest("GetAllOffers");

		List offers = (List) sendRequest(request).getAttachment();

		return offers;

	}

	public NetworkMessage sendLogoutRequest() {
		NetworkMessage request, response;

		request = new NetworkMessage();

		request.setRequest("Logout");
		
		return sendRequest(request);

	}

	private NetworkMessage sendRequest(NetworkMessage request) {
		NetworkMessage response = null;
		System.out.println("Sending Request 5");
		try {
			output.writeObject(request);
			System.out.println("Sending Request 6");
			response = (NetworkMessage) input.readObject();
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
