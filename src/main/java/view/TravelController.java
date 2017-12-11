package travel.view;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import javax.print.DocFlavor.STRING;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import travel.MainApp;
import travel.model.Travel;

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
	private Button deleteButton = new Button();

	private ObservableList<Travel> travelsearchObservList = null;

	private MainApp mainApp;

	public TravelController() {
	}

	@FXML
	private void initialize() {
		// Initialize the person table with the two columns.
		cityColumn.setCellValueFactory(cellData -> cellData.getValue().cityProperty());
		minPriceColumn.setCellValueFactory(cellData -> cellData.getValue().minPriceProperty().asObject());
		maxPriceColumn.setCellValueFactory(cellData -> cellData.getValue().maxPriceProperty().asObject());
		hotelsNumberColumn.setCellValueFactory(cellData -> cellData.getValue().hotelsNumberProperty().asObject());

		// Keresõ visszaállítása
		this.searchButton.setOnAction((event) -> {
			double minPrice = 1;
			double maxPrice = 10000000;
			String city = "";
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
						&& city.equals(travel.getCity())) {
					System.out.println(travel.getCity());
					/*
					Stage primaryStage = new Stage();
					Parent root = null;
					try {
						root = FXMLLoader.load(getClass().getClassLoader().getResource("travel/view/travelSearch.fxml"));
					} catch (IOException e) {
						e.printStackTrace();
					}
					Scene scene = new Scene(root,1000,500);
					primaryStage.setScene(scene);
					primaryStage.setTitle("TravelSearch");
					primaryStage.show();
					((Node) (event.getSource())).getScene().getWindow().hide();
					*/
				}

			}
		});
		/*
		 * //Keresés az utak között this.searchButton.setOnAction((event) -> {
		 * 
		 * this.cityComboBox.setValue(""); this.minPriceInput.setText("1");
		 * this.maxPriceInput.setText("100000");
		 * System.out.println(mainApp.getTravelData().size());
		 * //this.travelTable.getItems().remove(0, this.travelTable.getItems().size());
		 * //this.travelTable.getItems().addAll(travelList); });
		 */
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		// Add observable list data to the table
		travelTable.setItems(mainApp.getTravelData());
	}

	public void Login(ActionEvent event) throws IOException {
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("travel/view/login.fxml"));
		Scene scene = new Scene(root, 300, 200);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Login");
		primaryStage.show();
	}

	public void SignUp(ActionEvent event) throws IOException {
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("travel/view/register.fxml"));
		Scene scene = new Scene(root, 400, 500);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Register");
		primaryStage.show();
	}

	public void exit() {
		System.exit(0);
	}
}
