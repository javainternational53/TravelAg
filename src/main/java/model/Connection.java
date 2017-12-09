package model;

import java.net.Socket;

public class Connection {
	
	Socket socket;
	User associatedUser;
	
	public Connection(Socket socket, User associatedUser) {
		super();
		this.socket = socket;
		this.associatedUser = associatedUser;
	}
	
	@Override
	public String toString() {
		return "Connection [socket=" + socket + ", associatedUser=" + associatedUser + "]";
	}
	
	public Socket getSocket() {
		return socket;
	}
	
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	
	public User getAssociatedUser() {
		return associatedUser;
	}
	
	public void setAssociatedUser(User associatedUser) {
		this.associatedUser = associatedUser;
	}
	
	
}
