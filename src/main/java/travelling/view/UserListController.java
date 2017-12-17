package travelling.view;

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import travelling.MainApp;
import travelling.model.User;

public class UserListController {
	@FXML
	List<User> travelList;
	@FXML
	private TableView<User> userTable;
	@FXML
	private TableColumn<User, String> userNameColumn;
	@FXML
	private TableColumn<User, String> passwordColumn;
	
	private MainApp mainApp;
	private Stage primaryStage;
	private BorderPane rootLayout;
	private MenuController menuController;
	
	public UserListController() {
	}
	@FXML
	private void initialize() {
		userNameColumn.setCellValueFactory(cellData -> cellData.getValue().userNameProperty());
		passwordColumn.setCellValueFactory(cellData -> cellData.getValue().passwordProperty());
	}
}
