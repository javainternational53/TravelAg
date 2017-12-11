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


	public TravelController() {
	}

	@FXML
	private void initialize() {
		// Initialize the person table with the two columns.
		cityColumn.setCellValueFactory(cellData -> cellData.getValue().cityProperty());
		minPriceColumn.setCellValueFactory(cellData -> cellData.getValue().minPriceProperty().asObject());
		maxPriceColumn.setCellValueFactory(cellData -> cellData.getValue().maxPriceProperty().asObject());
		hotelsNumberColumn.setCellValueFactory(cellData -> cellData.getValue().hotelsNumberProperty().asObject());

		// Keres� vissza�ll�t�sa
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
						&& (city.equals(travel.getCity()) || city.length() == 0)) {
					System.out.println(travel.getCity());
					
					Stage primaryStage = new Stage();
					Parent root = null;
					try {
						root = FXMLLoader.load(getClass().getClassLoader().getResource("travel/view/travelSearch.fxml"));
					} catch (IOException e) {
						e.printStackTrace();
					}
					Scene scene = new Scene(root,600,400);
					primaryStage.setScene(scene);
					primaryStage.setTitle("TravelSearch");
					primaryStage.show();
				
				}
			}
			System.out.println();
		});
		
	}

	
}
