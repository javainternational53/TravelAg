package travelling.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import travelling.MainApp;

public class RegisterController {
	@FXML
	private TextField fxFirstName;
	
	@FXML
	private TextField fxLastName;
	
	@FXML
	private TextField fxUserName;
	
	@FXML
	private TextField fxPassword;
	
	@FXML
	private TextField fxEmail;
	
	@FXML
	private TextField fxBankCardNumber;
	
	@FXML
	private Button fxClear;
	
	@FXML
	private Button fxSignUp;
	
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String email;
	private String bankCardNumber;
	
	
	public void ReseAll(ActionEvent event) {
		fxFirstName.setText("");
		fxLastName.setText("");
		fxUserName.setText("");
		fxPassword.setText("");
		fxEmail.setText("");
		fxBankCardNumber.setText("");
	}

	private MainApp mainApp;
	private Stage primaryStage;
	private BorderPane rootLayout;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBankCardNumber() {
		return bankCardNumber;
	}

	public void setBankCardNumber(String bankCardNumber) {
		this.bankCardNumber = bankCardNumber;
	}

	
	
	public TextField getFxFirstName() {
		return fxFirstName;
	}

	public void setFxFirstName(TextField fxFirstName) {
		this.fxFirstName = fxFirstName;
	}

	public TextField getFxLastName() {
		return fxLastName;
	}

	public void setFxLastName(TextField fxLastName) {
		this.fxLastName = fxLastName;
	}

	public TextField getFxUserName() {
		return fxUserName;
	}

	public void setFxUserName(TextField fxUserName) {
		this.fxUserName = fxUserName;
	}

	public TextField getFxPassword() {
		return fxPassword;
	}

	public void setFxPassword(TextField fxPassword) {
		this.fxPassword = fxPassword;
	}

	public TextField getFxEmail() {
		return fxEmail;
	}

	public void setFxEmail(TextField fxEmail) {
		this.fxEmail = fxEmail;
	}


	public TextField getFxBankCardNumber() {
		return fxBankCardNumber;
	}

	public void setFxBankCardNumber(TextField fxBankCardNumber) {
		this.fxBankCardNumber = fxBankCardNumber;
	}

	public void SignUp(ActionEvent event) {
		setFirstName(fxFirstName.getText());
		setLastName(fxLastName.getText());
		setUserName(fxUserName.getText());
		setPassword(fxPassword.getText());
		setEmail(fxEmail.getText());
		setBankCardNumber(fxBankCardNumber.getText());
		
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(userName);
		System.out.println(password);
		System.out.println(email);
		System.out.println(bankCardNumber);
	}
	
}
