package travelling.view;

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import travelling.MainApp;
import travelling.model.Travel;

public class TravelSearchController {
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
	
	private MainApp mainApp;
	private Stage primaryStage;
	private BorderPane rootLayout;
	private TravelController travelController;

	public TravelSearchController() {
	}
	@FXML
	private void initialize() {
		cityColumn.setCellValueFactory(cellData -> cellData.getValue().cityProperty());
		minPriceColumn.setCellValueFactory(cellData -> cellData.getValue().minPriceProperty().asObject());
		maxPriceColumn.setCellValueFactory(cellData -> cellData.getValue().maxPriceProperty().asObject());
		hotelsNumberColumn.setCellValueFactory(cellData -> cellData.getValue().hotelsNumberProperty().asObject());
	}/*
	public void setTravelController(TravelController travelController)
	{
		this.travelController = travelController;
		travelTable.setItems(travelController.getTravelSearchData());
	}
	 public void setTravel(TravelController travelController) {
	        this.travelController = travelController;
	        cityColumn.setText("asdsa");
	        minPriceColumn.setText("2");
	        maxPriceColumn.setText("42");
	        hotelsNumberColumn.setText("3");
	    }
	    */
	public void setTravelController(TravelController travelController)
	{
		this.travelController = travelController;
		travelTable.setItems(travelController.getTravelSearchData());
	}
	/*
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		// Add observable list data to the table
		travelTable.setItems(mainApp.getTravelData());
	}
	*/
}
