package login;

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

	
}
