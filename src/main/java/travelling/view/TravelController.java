package travelling.view;

import java.awt.Label;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import network.Client;
import travelling.MainApp;
import travelling.model.Travel;
import travelling.model.User;

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
	private TableColumn<Travel, String> packageOfferColumn;
	@FXML
	private TableColumn<Travel, Integer> numberOfPersonsColumn;

	@FXML
	private TextField minPriceInput = new TextField();
	@FXML
	private TextField maxPriceInput = new TextField();
	@FXML
	private TextField cityInput = new TextField();
	@FXML
	private TextField userName = new TextField();
	@FXML
	private TextField password = new TextField();

	@FXML
	private Button searchButton = new Button();
	@FXML
	private Button clearButton = new Button();
	@FXML
	private Button loginButton = new Button();
	@FXML
	private Button signUpButton = new Button();

	@FXML
	private Text bejelentkezve;
	@FXML
	private Text usernameText;
	@FXML
	private Text usernameLabel;
	@FXML
	private Text passwordLabel;

	@FXML
	private MainApp mainApp;
	private Stage primaryStage;
	private BorderPane rootLayout;

    private Client client;

    private LoginController login;


	private ObservableList<Travel> travelSearchData = FXCollections.observableArrayList();

	public ObservableList<Travel> getTravelSearchData() {
		return travelSearchData;
	}

	public void setTravelSearchData(ObservableList<Travel> travelSearchData) {
		this.travelSearchData = travelSearchData;
	}

	public TravelController() {
		client = new Client();
		System.out.println("making travel");
		
		try {
		//client.SendLoginRequest("test", "asd");
		User user=(User)(client.SendLoginRequest("Test", "Test")).getAttachment();
		System.out.println(user);
		
		}catch(Exception e) {
			System.out.println("dasgebasz"+e.getMessage());
			
		}
		System.out.println();
		//System.out.println(client.SendLoginRequest("Test", "Test"));
	}

	public void SignUp(ActionEvent event) throws IOException {
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("travelling/view/register.fxml"));
		Scene scene = new Scene(root, 400, 500);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Register");
		primaryStage.show();
	}

	/*
	 * public void Login(ActionEvent event) throws IOException { Stage primaryStage
	 * = new Stage(); Parent root =
	 * FXMLLoader.load(getClass().getClassLoader().getResource(
	 * "travelling/view/login.fxml")); Scene scene = new Scene(root, 300, 200);
	 * primaryStage.setScene(scene); primaryStage.setTitle("Login");
	 * primaryStage.show(); }
	 */
	public List<User> userAll = new ArrayList<User>();

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

	private static boolean flag = true;

	@FXML
	public void initialize() {
		// Initialize the person table with the two columns.
		cityColumn.setCellValueFactory(cellData -> cellData.getValue().cityProperty());
		minPriceColumn.setCellValueFactory(cellData -> cellData.getValue().minPriceProperty().asObject());
		maxPriceColumn.setCellValueFactory(cellData -> cellData.getValue().maxPriceProperty().asObject());
		packageOfferColumn.setCellValueFactory(cellData -> cellData.getValue().packageOfferProperty());
		numberOfPersonsColumn.setCellValueFactory(cellData -> cellData.getValue().numberOfPersonsProperty().asObject());
		bejelentkezve.setVisible(false);
		usernameText.setVisible(false);
		/*
		 * if(LoginController.loginout == false) System.out.println("asd"); else
		 * System.out.println("uio");
		 */

		this.loginButton.setOnAction((event) -> {
			add();
			// System.out.println(userAll.size());
			int count = 0;
			for (User user : userAll) {
				++count;
				// System.out.println(user.getUser());
				// System.out.println(user.getPass());
				if (loginButton.getText().equals("Login") && userName.getText().equals(user.getUsername())
						&& password.getText().equals(user.getPassword())) {
					userName.setVisible(false);
					password.setVisible(false);
					bejelentkezve.setVisible(true);
					usernameText.setText(userName.getText());
					usernameText.setVisible(true);
					signUpButton.setVisible(false);
					usernameLabel.setVisible(false);
					passwordLabel.setVisible(false);
					loginButton.setText("Logout");
					break;
				} else if (userAll.size() == count) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error");
					alert.setHeaderText("Wrong password or username");
					alert.setContentText("Try it again.");
					alert.showAndWait();
					break;
				}
				if (loginButton.getText().equals("Logout")) {
					userName.setVisible(true);
					userName.setText("");
					password.setVisible(true);
					password.setText("");
					bejelentkezve.setVisible(false);
					usernameText.setText("");
					usernameText.setVisible(false);
					signUpButton.setVisible(true);
					usernameLabel.setVisible(true);
					passwordLabel.setVisible(true);
					loginButton.setText("Login");
					break;
				}
			}
			userAll.clear();

		});
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
				}
			}
			if (travelSearchData.size() != 0) {

				try {

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
			} else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Dialog");
				alert.setHeaderText("Nincs talĂˇlat");
				alert.setContentText("PrĂłbĂˇlkozz Ăşjra");

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

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		// Add observable list data to the table
		travelTable.setItems(mainApp.getTravelData());
	}
}
