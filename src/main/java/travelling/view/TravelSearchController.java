package travelling.view;

import java.io.IOException;
import java.util.List;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
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
	private TableColumn<Travel, String> packageOfferColumn;
	@FXML
	private TableColumn<Travel, Integer> numberOfPersonsColumn;
	
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
		packageOfferColumn.setCellValueFactory(cellData -> cellData.getValue().packageOfferProperty());
		numberOfPersonsColumn.setCellValueFactory(cellData -> cellData.getValue().numberOfPersonsProperty().asObject());
	
		travelTable.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {

				if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
					Travel selectedTravelItem = travelTable.getSelectionModel().getSelectedItem();
					if (selectedTravelItem.getCity().equals("Budapest")) {
						try {

							FXMLLoader loader = new FXMLLoader();
							loader.setLocation(MainApp.class.getResource("view/budapest.fxml"));
							AnchorPane page = (AnchorPane) loader.load();
							Stage dialogStage = new Stage();
							dialogStage.setTitle("City");
							dialogStage.initModality(Modality.WINDOW_MODAL);
							dialogStage.initOwner(primaryStage);
							Scene scene = new Scene(page);
							dialogStage.setScene(scene);

							// Set the persons into the controller.
							// controller.setTravelController(travelSearchData);
							/*
							 * TravelSearchController controller = loader.getController();
							 * controller.setTravelController(this);
							 */
							dialogStage.show();

						} catch (IOException e) {
							e.printStackTrace();
						}
					}

					
				}

				//

				if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
					Travel selectedTravelItem = travelTable.getSelectionModel().getSelectedItem();
					if (selectedTravelItem.getCity().equals("Debrecen")) {
						try {

							FXMLLoader loader = new FXMLLoader();
							loader.setLocation(MainApp.class.getResource("view/debrecen.fxml"));
							AnchorPane page = (AnchorPane) loader.load();
							Stage dialogStage = new Stage();
							dialogStage.setTitle("City");
							dialogStage.initModality(Modality.WINDOW_MODAL);
							dialogStage.initOwner(primaryStage);
							Scene scene = new Scene(page);
							dialogStage.setScene(scene);

							// Set the persons into the controller.
							// controller.setTravelController(travelSearchData);
							/*
							 * TravelSearchController controller = loader.getController();
							 * controller.setTravelController(this);
							 */
							dialogStage.show();

						} catch (IOException e) {
							e.printStackTrace();
						}
					}

					
				}

				// ***

				if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
					Travel selectedTravelItem = travelTable.getSelectionModel().getSelectedItem();
					if (selectedTravelItem.getCity().equals("Miskolc")) {
						try {

							FXMLLoader loader = new FXMLLoader();
							loader.setLocation(MainApp.class.getResource("view/miskolc.fxml"));
							AnchorPane page = (AnchorPane) loader.load();
							Stage dialogStage = new Stage();
							dialogStage.setTitle("City");
							dialogStage.initModality(Modality.WINDOW_MODAL);
							dialogStage.initOwner(primaryStage);
							Scene scene = new Scene(page);
							dialogStage.setScene(scene);

							// Set the persons into the controller.
							// controller.setTravelController(travelSearchData);
							/*
							 * TravelSearchController controller = loader.getController();
							 * controller.setTravelController(this);
							 */
							dialogStage.show();

						} catch (IOException e) {
							e.printStackTrace();
						}
					}

					
				}

				if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
					Travel selectedTravelItem = travelTable.getSelectionModel().getSelectedItem();
					if (selectedTravelItem.getCity().equals("Szeged")) {
						try {

							FXMLLoader loader = new FXMLLoader();
							loader.setLocation(MainApp.class.getResource("view/szeged.fxml"));
							AnchorPane page = (AnchorPane) loader.load();
							Stage dialogStage = new Stage();
							dialogStage.setTitle("City");
							dialogStage.initModality(Modality.WINDOW_MODAL);
							dialogStage.initOwner(primaryStage);
							Scene scene = new Scene(page);
							dialogStage.setScene(scene);

							// Set the persons into the controller.
							// controller.setTravelController(travelSearchData);
							/*
							 * TravelSearchController controller = loader.getController();
							 * controller.setTravelController(this);
							 */
							dialogStage.show();

						} catch (IOException e) {
							e.printStackTrace();
						}
					}

					
				}

				// ***

				if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
					Travel selectedTravelItem = travelTable.getSelectionModel().getSelectedItem();
					if (selectedTravelItem.getCity().equals("Gyor")) {
						try {

							FXMLLoader loader = new FXMLLoader();
							loader.setLocation(MainApp.class.getResource("view/gyor.fxml"));
							AnchorPane page = (AnchorPane) loader.load();
							Stage dialogStage = new Stage();
							dialogStage.setTitle("City");
							dialogStage.initModality(Modality.WINDOW_MODAL);
							dialogStage.initOwner(primaryStage);
							Scene scene = new Scene(page);
							dialogStage.setScene(scene);

							// Set the persons into the controller.
							// controller.setTravelController(travelSearchData);
							/*
							 * TravelSearchController controller = loader.getController();
							 * controller.setTravelController(this);
							 */
							dialogStage.show();

						} catch (IOException e) {
							e.printStackTrace();
						}
					}

					
				}

				// ***

				if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
					Travel selectedTravelItem = travelTable.getSelectionModel().getSelectedItem();
					if (selectedTravelItem.getCity().equals("Nyiregyhaza")) {
						try {

							FXMLLoader loader = new FXMLLoader();
							loader.setLocation(MainApp.class.getResource("view/nyiregyhaza.fxml"));
							AnchorPane page = (AnchorPane) loader.load();
							Stage dialogStage = new Stage();
							dialogStage.setTitle("City");
							dialogStage.initModality(Modality.WINDOW_MODAL);
							dialogStage.initOwner(primaryStage);
							Scene scene = new Scene(page);
							dialogStage.setScene(scene);

							// Set the persons into the controller.
							// controller.setTravelController(travelSearchData);
							/*
							 * TravelSearchController controller = loader.getController();
							 * controller.setTravelController(this);
							 */
							dialogStage.show();

						} catch (IOException e) {
							e.printStackTrace();
						}
					}

					
				}

				// ***

				if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
					Travel selectedTravelItem = travelTable.getSelectionModel().getSelectedItem();
					if (selectedTravelItem.getCity().equals("Bekescsaba")) {
						try {

							FXMLLoader loader = new FXMLLoader();
							loader.setLocation(MainApp.class.getResource("view/bekescsaba.fxml"));
							AnchorPane page = (AnchorPane) loader.load();
							Stage dialogStage = new Stage();
							dialogStage.setTitle("City");
							dialogStage.initModality(Modality.WINDOW_MODAL);
							dialogStage.initOwner(primaryStage);
							Scene scene = new Scene(page);
							dialogStage.setScene(scene);

							// Set the persons into the controller.
							// controller.setTravelController(travelSearchData);
							/*
							 * TravelSearchController controller = loader.getController();
							 * controller.setTravelController(this);
							 */
							dialogStage.show();

						} catch (IOException e) {
							e.printStackTrace();
						}
					}

					
				}

				// ***

				if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
					Travel selectedTravelItem = travelTable.getSelectionModel().getSelectedItem();
					if (selectedTravelItem.getCity().equals("Szolnok")) {
						try {

							FXMLLoader loader = new FXMLLoader();
							loader.setLocation(MainApp.class.getResource("view/szolnok.fxml"));
							AnchorPane page = (AnchorPane) loader.load();
							Stage dialogStage = new Stage();
							dialogStage.setTitle("City");
							dialogStage.initModality(Modality.WINDOW_MODAL);
							dialogStage.initOwner(primaryStage);
							Scene scene = new Scene(page);
							dialogStage.setScene(scene);

							// Set the persons into the controller.
							// controller.setTravelController(travelSearchData);
							/*
							 * TravelSearchController controller = loader.getController();
							 * controller.setTravelController(this);
							 */
							dialogStage.show();

						} catch (IOException e) {
							e.printStackTrace();
						}
					}

					
				}

				// ***

				if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
					Travel selectedTravelItem = travelTable.getSelectionModel().getSelectedItem();
					if (selectedTravelItem.getCity().equals("Eger")) {
						try {

							FXMLLoader loader = new FXMLLoader();
							loader.setLocation(MainApp.class.getResource("view/eger.fxml"));
							AnchorPane page = (AnchorPane) loader.load();
							Stage dialogStage = new Stage();
							dialogStage.setTitle("City");
							dialogStage.initModality(Modality.WINDOW_MODAL);
							dialogStage.initOwner(primaryStage);
							Scene scene = new Scene(page);
							dialogStage.setScene(scene);

							// Set the persons into the controller.
							// controller.setTravelController(travelSearchData);
							/*
							 * TravelSearchController controller = loader.getController();
							 * controller.setTravelController(this);
							 */
							dialogStage.show();

						} catch (IOException e) {
							e.printStackTrace();
						}
					}

					
				}

				// ***

				if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
					Travel selectedTravelItem = travelTable.getSelectionModel().getSelectedItem();
					if (selectedTravelItem.getCity().equals("Salgotarjan")) {
						try {

							FXMLLoader loader = new FXMLLoader();
							loader.setLocation(MainApp.class.getResource("view/salgotarjan.fxml"));
							AnchorPane page = (AnchorPane) loader.load();
							Stage dialogStage = new Stage();
							dialogStage.setTitle("City");
							dialogStage.initModality(Modality.WINDOW_MODAL);
							dialogStage.initOwner(primaryStage);
							Scene scene = new Scene(page);
							dialogStage.setScene(scene);

							// Set the persons into the controller.
							// controller.setTravelController(travelSearchData);
							/*
							 * TravelSearchController controller = loader.getController();
							 * controller.setTravelController(this);
							 */
							dialogStage.show();

						} catch (IOException e) {
							e.printStackTrace();
						}
					}

					
				}

				// ***

				if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
					Travel selectedTravelItem = travelTable.getSelectionModel().getSelectedItem();
					if (selectedTravelItem.getCity().equals("Kecskemet")) {
						try {

							FXMLLoader loader = new FXMLLoader();
							loader.setLocation(MainApp.class.getResource("view/kecskemet.fxml"));
							AnchorPane page = (AnchorPane) loader.load();
							Stage dialogStage = new Stage();
							dialogStage.setTitle("City");
							dialogStage.initModality(Modality.WINDOW_MODAL);
							dialogStage.initOwner(primaryStage);
							Scene scene = new Scene(page);
							dialogStage.setScene(scene);

							// Set the persons into the controller.
							// controller.setTravelController(travelSearchData);
							/*
							 * TravelSearchController controller = loader.getController();
							 * controller.setTravelController(this);
							 */
							dialogStage.show();

						} catch (IOException e) {
							e.printStackTrace();
						}
					}

					
				}

				// ***

				if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
					Travel selectedTravelItem = travelTable.getSelectionModel().getSelectedItem();
					if (selectedTravelItem.getCity().equals("Szekszard")) {
						try {

							FXMLLoader loader = new FXMLLoader();
							loader.setLocation(MainApp.class.getResource("view/szekszard.fxml"));
							AnchorPane page = (AnchorPane) loader.load();
							Stage dialogStage = new Stage();
							dialogStage.setTitle("City");
							dialogStage.initModality(Modality.WINDOW_MODAL);
							dialogStage.initOwner(primaryStage);
							Scene scene = new Scene(page);
							dialogStage.setScene(scene);

							// Set the persons into the controller.
							// controller.setTravelController(travelSearchData);
							/*
							 * TravelSearchController controller = loader.getController();
							 * controller.setTravelController(this);
							 */
							dialogStage.show();

						} catch (IOException e) {
							e.printStackTrace();
						}
					}

					
				}

				if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
					Travel selectedTravelItem = travelTable.getSelectionModel().getSelectedItem();
					if (selectedTravelItem.getCity().equals("Pecs")) {
						try {

							FXMLLoader loader = new FXMLLoader();
							loader.setLocation(MainApp.class.getResource("view/pecs.fxml"));
							AnchorPane page = (AnchorPane) loader.load();
							Stage dialogStage = new Stage();
							dialogStage.setTitle("City");
							dialogStage.initModality(Modality.WINDOW_MODAL);
							dialogStage.initOwner(primaryStage);
							Scene scene = new Scene(page);
							dialogStage.setScene(scene);

							// Set the persons into the controller.
							// controller.setTravelController(travelSearchData);
							/*
							 * TravelSearchController controller = loader.getController();
							 * controller.setTravelController(this);
							 */
							dialogStage.show();

						} catch (IOException e) {
							e.printStackTrace();
						}
					}

					
				}
				if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
					Travel selectedTravelItem = travelTable.getSelectionModel().getSelectedItem();
					if (selectedTravelItem.getCity().equals("Szekesfehervar")) {
						try {

							FXMLLoader loader = new FXMLLoader();
							loader.setLocation(MainApp.class.getResource("view/szekesfehervar.fxml"));
							AnchorPane page = (AnchorPane) loader.load();
							Stage dialogStage = new Stage();
							dialogStage.setTitle("City");
							dialogStage.initModality(Modality.WINDOW_MODAL);
							dialogStage.initOwner(primaryStage);
							Scene scene = new Scene(page);
							dialogStage.setScene(scene);

							// Set the persons into the controller.
							// controller.setTravelController(travelSearchData);
							/*
							 * TravelSearchController controller = loader.getController();
							 * controller.setTravelController(this);
							 */
							dialogStage.show();

						} catch (IOException e) {
							e.printStackTrace();
						}
					}

					
				}

				if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
					Travel selectedTravelItem = travelTable.getSelectionModel().getSelectedItem();
					if (selectedTravelItem.getCity().equals("Tatabanya")) {
						try {

							FXMLLoader loader = new FXMLLoader();
							loader.setLocation(MainApp.class.getResource("view/tatabanya.fxml"));
							AnchorPane page = (AnchorPane) loader.load();
							Stage dialogStage = new Stage();
							dialogStage.setTitle("City");
							dialogStage.initModality(Modality.WINDOW_MODAL);
							dialogStage.initOwner(primaryStage);
							Scene scene = new Scene(page);
							dialogStage.setScene(scene);

							// Set the persons into the controller.
							// controller.setTravelController(travelSearchData);
							/*
							 * TravelSearchController controller = loader.getController();
							 * controller.setTravelController(this);
							 */
							dialogStage.show();

						} catch (IOException e) {
							e.printStackTrace();
						}
					}

					
				}

				if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
					Travel selectedTravelItem = travelTable.getSelectionModel().getSelectedItem();
					if (selectedTravelItem.getCity().equals("Kaposvar")) {
						try {

							FXMLLoader loader = new FXMLLoader();
							loader.setLocation(MainApp.class.getResource("view/kaposvar.fxml"));
							AnchorPane page = (AnchorPane) loader.load();
							Stage dialogStage = new Stage();
							dialogStage.setTitle("City");
							dialogStage.initModality(Modality.WINDOW_MODAL);
							dialogStage.initOwner(primaryStage);
							Scene scene = new Scene(page);
							dialogStage.setScene(scene);

							// Set the persons into the controller.
							// controller.setTravelController(travelSearchData);
							/*
							 * TravelSearchController controller = loader.getController();
							 * controller.setTravelController(this);
							 */
							dialogStage.show();

						} catch (IOException e) {
							e.printStackTrace();
						}
					}

					
				}

				if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
					Travel selectedTravelItem = travelTable.getSelectionModel().getSelectedItem();
					if (selectedTravelItem.getCity().equals("Veszprem")) {
						try {

							FXMLLoader loader = new FXMLLoader();
							loader.setLocation(MainApp.class.getResource("view/veszprem.fxml"));
							AnchorPane page = (AnchorPane) loader.load();
							Stage dialogStage = new Stage();
							dialogStage.setTitle("City");
							dialogStage.initModality(Modality.WINDOW_MODAL);
							dialogStage.initOwner(primaryStage);
							Scene scene = new Scene(page);
							dialogStage.setScene(scene);

							// Set the persons into the controller.
							// controller.setTravelController(travelSearchData);
							/*
							 * TravelSearchController controller = loader.getController();
							 * controller.setTravelController(this);
							 */
							dialogStage.show();

						} catch (IOException e) {
							e.printStackTrace();
						}
					}

					
				}

				if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
					Travel selectedTravelItem = travelTable.getSelectionModel().getSelectedItem();
					if (selectedTravelItem.getCity().equals("Zalaegerszeg")) {
						try {

							FXMLLoader loader = new FXMLLoader();
							loader.setLocation(MainApp.class.getResource("view/zalaegerszeg.fxml"));
							AnchorPane page = (AnchorPane) loader.load();
							Stage dialogStage = new Stage();
							dialogStage.setTitle("City");
							dialogStage.initModality(Modality.WINDOW_MODAL);
							dialogStage.initOwner(primaryStage);
							Scene scene = new Scene(page);
							dialogStage.setScene(scene);

							// Set the persons into the controller.
							// controller.setTravelController(travelSearchData);
							/*
							 * TravelSearchController controller = loader.getController();
							 * controller.setTravelController(this);
							 */
							dialogStage.show();

						} catch (IOException e) {
							e.printStackTrace();
						}
					}

					
				}

				if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
					Travel selectedTravelItem = travelTable.getSelectionModel().getSelectedItem();
					if (selectedTravelItem.getCity().equals("Szombathely")) {
						try {

							FXMLLoader loader = new FXMLLoader();
							loader.setLocation(MainApp.class.getResource("view/szombathely.fxml"));
							AnchorPane page = (AnchorPane) loader.load();
							Stage dialogStage = new Stage();
							dialogStage.setTitle("City");
							dialogStage.initModality(Modality.WINDOW_MODAL);
							dialogStage.initOwner(primaryStage);
							Scene scene = new Scene(page);
							dialogStage.setScene(scene);

							// Set the persons into the controller.
							// controller.setTravelController(travelSearchData);
							/*
							 * TravelSearchController controller = loader.getController();
							 * controller.setTravelController(this);
							 */
							dialogStage.show();

						} catch (IOException e) {
							e.printStackTrace();
						}
					}

					
				}

			}

		});
	}
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
