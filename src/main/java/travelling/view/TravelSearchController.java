package travelling.view;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import travelling.MainApp;
import travelling.model.Travel;

public class TravelSearchController {
	@FXML
	List<Travel> travelSearchList;
	@FXML
	private TableView<Travel> travelSearchTable;
	@FXML
	private TableColumn<Travel, String> cityColumn;
	@FXML
	private TableColumn<Travel, Double> minPriceColumn;
	@FXML
	private TableColumn<Travel, Double> maxPriceColumn;
	@FXML
	private TableColumn<Travel, Integer> hotelsNumberColumn;
	
	private ObservableList<Travel> travelsearchObservList = FXCollections.observableArrayList();

	private MainApp mainApp;
	
	private TravelSearchController() {
		
	}
	@FXML
	private void initialize() {
		cityColumn.setCellValueFactory(cellData -> cellData.getValue().cityProperty());
		minPriceColumn.setCellValueFactory(cellData -> cellData.getValue().minPriceProperty().asObject());
		maxPriceColumn.setCellValueFactory(cellData -> cellData.getValue().maxPriceProperty().asObject());
		hotelsNumberColumn.setCellValueFactory(cellData -> cellData.getValue().hotelsNumberProperty().asObject());
	}
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		// Add observable list data to the table
		travelSearchTable.setItems(mainApp.getTravelData());
	}
}
