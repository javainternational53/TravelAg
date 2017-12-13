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
	private Button fxClear;
	
	@FXML
	private Button fxSignUp;
	
	public void ReseAll(ActionEvent event) {
		fxFirstName.setText("");
		fxLastName.setText("");
		fxUserName.setText("");
		fxPassword.setText("");
		fxEmail.setText("");
	}
	private MainApp mainApp;
	private Stage primaryStage;
	private BorderPane rootLayout;
	
	
}
