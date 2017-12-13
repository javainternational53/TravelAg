package travelling.view;

import java.awt.Label;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import travelling.MainApp;
import travelling.model.Travel;

public class TravelController {
	@FXML
	List<Travel> travelList;
	@FXML
	private TableView<Travel> travelTable;
	@FXML
	private TableColumn<Travel, String> cityColumn;
	@FXML
	private TableColumn<Travel, Double> minPriceColumn;
	@FXML
	private TableColumn<Travel, Double> maxPriceColumn;
	@FXML
	private TableColumn<Travel, Integer> hotelsNumberColumn;

	@FXML
	private TextField minPriceInput = new TextField();
	@FXML
	private TextField maxPriceInput = new TextField();
	@FXML
	private TextField cityInput = new TextField();

	@FXML
	private Button searchButton = new Button();
	@FXML
	private Button clearButton = new Button();
	
	@FXML
	private MainApp mainApp;
	private Stage primaryStage;
	private BorderPane rootLayout;

	private ObservableList<Travel> travelSearchData = FXCollections.observableArrayList();

	public ObservableList<Travel> getTravelSearchData() {
		return travelSearchData;
	}

	public void setTravelSearchData(ObservableList<Travel> travelSearchData) {
		this.travelSearchData = travelSearchData;
	}

	public TravelController() {
	}

	public void SignUp(ActionEvent event) throws IOException {
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("travelling/view/register.fxml"));
		Scene scene = new Scene(root, 400, 500);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Register");
		primaryStage.show();
	}

	public void Login(ActionEvent event) throws IOException {
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("travelling/view/login.fxml"));
		Scene scene = new Scene(root, 300, 200);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Login");
		primaryStage.show();
	}

	@FXML
	public void initialize() {
		// Initialize the person table with the two columns.
		cityColumn.setCellValueFactory(cellData -> cellData.getValue().cityProperty());
		minPriceColumn.setCellValueFactory(cellData -> cellData.getValue().minPriceProperty().asObject());
		maxPriceColumn.setCellValueFactory(cellData -> cellData.getValue().maxPriceProperty().asObject());
		hotelsNumberColumn.setCellValueFactory(cellData -> cellData.getValue().hotelsNumberProperty().asObject());
		/*
		if(LoginController.loginout == false)
			System.out.println("asd");
		else
			System.out.println("uio");
		*/
		this.searchButton.setOnAction((event) -> {
			double minPrice = 1;
			double maxPrice = 10000000;
			String city = "";
			travelSearchData.clear();
			if (minPriceInput.getText() != null)
				try {
					minPrice = Double.parseDouble(minPriceInput.getText());
				} catch (NumberFormatException e) {
					minPrice = 1.0;
				}
			if (maxPriceInput.getText() != null)
				try {
					maxPrice = Double.parseDouble(maxPriceInput.getText());
				} catch (NumberFormatException e) {
					maxPrice = 10000000;
				}
			if (cityInput.getText() != null)
				try {
					city = cityInput.getText();
				} catch (Exception e) {
					city = "";
				}
			for (Travel travel : mainApp.getTravelData()) {
				if (minPrice <= travel.getMinPrice() && maxPrice >= travel.getMAxPrice()
						&& (city.equals(travel.getCity()) || city.length() == 0)) {
					travelSearchData.add(travel);
					System.out.println(travelSearchData.get(0).getCity());
					// System.out.println(mainApp.getTravelSearchData().get(0).getCity());
					// System.out.println(travelSearchData);
					// System.out.println(travel.getCity());
				}
			}
			if (travelSearchData.size() != 0) {

				try {
					// Load the fxml file and create a new stage for the popup.
					FXMLLoader loader = new FXMLLoader();
					loader.setLocation(MainApp.class.getResource("view/travelSearch.fxml"));
					AnchorPane page = (AnchorPane) loader.load();
					Stage dialogStage = new Stage();
					dialogStage.setTitle("TravelSearch");
					dialogStage.initModality(Modality.WINDOW_MODAL);
					dialogStage.initOwner(primaryStage);
					Scene scene = new Scene(page);
					dialogStage.setScene(scene);

					// Set the persons into the controller.
					// controller.setTravelController(travelSearchData);
					TravelSearchController controller = loader.getController();
					controller.setTravelController(this);
					dialogStage.show();
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Dialog");
				alert.setHeaderText("Nincs találat");
				alert.setContentText("Próbálkozz újra");

				alert.showAndWait();
			}
			System.out.println();
		});
		
		this.clearButton.setOnAction((event) -> {
			cityInput.setText("");
			minPriceInput.setText("");
			maxPriceInput.setText("");
		});
		travelTable.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
					/*Ide jon majd a cuccos*/
					System.out.println("Proba");
					Travel selectedTravelItem = travelTable.getSelectionModel().getSelectedItem();
				}
			}
		});
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		// Add observable list data to the table
		travelTable.setItems(mainApp.getTravelData());
	}
}
