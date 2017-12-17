package travelling.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


@Entity
@Table(name = "User")
public class User implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String FirstName;
	
	private String LastName;
	
	private String username;
	
	private String password;

	private String email;
	
	private String BankCard;
	
	
	
	public User(String firstName, String lastName, String username, String password, String email, String bankCard) {
		FirstName = firstName;
		LastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		BankCard = bankCard;
	}

	public User() {
		super();
	}

	public User(long id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username=username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password=password;
	}
	
	public StringProperty userNameProperty() {
		return new SimpleStringProperty(username);
	}
	
	public StringProperty passwordProperty() {
		return new SimpleStringProperty(password);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ""
				+ ", username=" + username 
				+ ", password=" + password 
				+ ", first_name=" + FirstName 
				+ ", last_name=" + LastName 
				+ ", bank_card= " + BankCard 
				+ ", E-mail=" + email + "]";
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	
	public StringProperty firstNameProperty() {
		return new SimpleStringProperty(FirstName);
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public StringProperty lastNameProperty() {
		return new SimpleStringProperty(LastName);
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public StringProperty emailProperty() {
		return new SimpleStringProperty(email);
	}
	
	public String getBankCard() {
		return BankCard;
	}

	public void setBankCard(String bankCard) {
		BankCard = bankCard;
	}
	
	public StringProperty bankCardProperty() {
		return new SimpleStringProperty(BankCard);
	}
	
}
