package travelling.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


@Entity
@Table(name = "User")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	
	StringProperty username;
	
	StringProperty password;

	
	public User(long id, String username, String password) {
		super();
		this.id = id;
		this.username = new SimpleStringProperty(username);
		this.password = new SimpleStringProperty(password);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username.get();
	}

	public void setUsername(String username) {
		this.username.set(username);
	}
	public StringProperty userNameProperty() {
		return username;
	}

	public String getPassword() {
		return password.get();
	}

	public void setPassword(String password) {
		this.password.set(password);;
	}
	public StringProperty passwordProperty() {
		return password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	
	
}
