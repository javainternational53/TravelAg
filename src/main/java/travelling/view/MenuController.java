package travelling.view;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import travelling.MainApp;
import travelling.model.User;


public class MenuController {
	private MainApp mainApp;
	private Stage primaryStage;
	private BorderPane rootLayout;
	public ObservableList<User> userListData = FXCollections.observableArrayList();
	private LoginController login;

	public ObservableList<User> getUserListData() {
		return userListData;
	}

	public void setUserListData(ObservableList<User> userListData) {
		this.userListData = userListData;
	}
	
	
	public void add() {
		//userListData.addAll(login.userAll);
		userListData.add(new User(1,"Ez","Meg"));
		userListData.add(new User(1,"Nem","Jol"));
		userListData.add(new User(1,"mukodik","."));	
	}
	
	public void UserList() throws IOException {
		try {
			System.out.println(userListData.size());
			add();
			System.out.println(userListData.size());
			// Load the fxml file and create a new stage for the popup.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/userList.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("UserList");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			
			UserListController controller = loader.getController();
			controller.setMenuController(this);
			
			dialogStage.show();
			/*
			// Set the persons into the controller.
			// controller.setTravelController(travelSearchData);
			TravelSearchController controller = loader.getController();
			controller.setTravelController(this);
			dialogStage.show();
			*/
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void exit(){
		System.exit(0);
	}
}
