package login;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

	@FXML
	private JFXTextField user;

	@FXML
	private JFXPasswordField password;

	@FXML
	private JFXButton login;

	@FXML
	private JFXButton signup;

	@FXML
	void makeLogin(ActionEvent event) throws IOException {

		String username = user.getText();
		String pass = password.getText();
		// Tesztelési fázis, mielőtt megkapja a dba
		
		if (username.equals("test") && pass.equals("test")) {

			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/main.fxml"));
			Scene scene = new Scene(root,1000,300);
			primaryStage.setScene(scene);
			primaryStage.show();
			((Node) (event.getSource())).getScene().getWindow().hide();

		} else
		{
			Alert alert = new Alert(AlertType.ERROR);
	        alert.setTitle("Error");
	        alert.setHeaderText("Adat megadási probléma");
	        alert.setContentText("Nem tudtunk belépni.");
	        alert.showAndWait();
		}
	}

	public void initialize(URL url, ResourceBundle rb) {

	}
}
