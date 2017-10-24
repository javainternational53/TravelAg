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

		// Tesztelési fázis , mielőtt megkapja a dba

		if (username.equals("test") && pass.equals("test")) {

			Parent root = FXMLLoader.load(this.getClass().getClassLoader().getResource("felulet.fxml"));
			Stage main = new Stage();

			main.setScene(new Scene(root, 500, 775));
			main.show();

			((Node) (event.getSource())).getScene().getWindow().hide();

		} else
			System.out.println("Wrong Password , Try it again ! ");

	}

	public void initialize(URL url, ResourceBundle rb) {

	}
}
