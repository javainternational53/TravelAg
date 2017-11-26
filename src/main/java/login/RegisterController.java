package login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
	private Button fxResetAll;
	
	@FXML
	private Button fxSignUp;
	
	public void ResetAll(ActionEvent event) {
		fxFirstName.setText("");
		fxLastName.setText("");
		fxUserName.setText("");
		fxPassword.setText("");
		fxEmail.setText("");
	}
}
