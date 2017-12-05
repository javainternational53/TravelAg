package login;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class MainController {
	@FXML
	private TextField fxUserName;
	
	@FXML
	private TextField fxPassword;
	
	@FXML
	private Button fxLogin;
	
	@FXML
	private Button fxSignUp;
	
	public void Login(ActionEvent event) throws IOException {
		if(fxUserName.getText().equals("user") && fxPassword.getText().equals("pass")) {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/travel.fxml"));
			Scene scene = new Scene(root,1000,600);
			primaryStage.setScene(scene);
			primaryStage.show();
			((Node) (event.getSource())).getScene().getWindow().hide();
		}
		else {
			Alert alert = new Alert(AlertType.ERROR);
	        alert.setTitle("Error");
	        alert.setHeaderText("Wrong password or username");
	        alert.setContentText("Try again.");
	        alert.showAndWait();
		}
	}
	
}
