package travelling.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import travelling.MainApp;
import travelling.model.User;

public class LoginController {

	@FXML
	private TextField fxUserName;

	@FXML
	private TextField fxPassword;

	@FXML
	private Button fxLogin;
	
	public List<User> userAll = new ArrayList<User>();
	public MenuController menucontroller;
	
	public List<User> getUserAll() {
		return userAll;
	}

	public void setUserAll(List<User> userAll) {
		this.userAll = userAll;
	}

	public void add() {
		userAll.add(new User(001, "user", "pass"));
		userAll.add(new User(002, "user1", "pass1"));
		userAll.add(new User(003, "user2", "pass2"));
		userAll.add(new User(004, "user3", "pass3"));	
	}

	public void Login(ActionEvent event) throws IOException {
		add();
		//System.out.println(userAll.size());
		int count = 0;
		for (User user : userAll) {
			++count;
			// System.out.println(user.getUser());
			// System.out.println(user.getPass());
			if (fxUserName.getText().equals(user.getUsername()) && fxPassword.getText().equals(user.getPassword())) {
				((Node) (event.getSource())).getScene().getWindow().hide();
				System.out.println("ok");
				break;
			} else if (userAll.size() == count) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("Wrong password or username");
				alert.setContentText("Try it again.");
				alert.showAndWait();
				break;
			}
		}
		userAll.clear();
	}
}
