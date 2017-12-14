package travelling;

import java.io.IOException;
import java.io.InputStream;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import persistence.PersistenceManager;

import travelling.model.Travel;
import travelling.model.User;
import travelling.view.TravelController;

public class MainApp extends Application {

	public static void startInServerMode() {
	
	}
	
	private Stage primaryStage;
	private BorderPane rootLayout;
	private ObservableList<Travel> travelData = FXCollections.observableArrayList();
	//test
	public MainApp() {
		travelData.add(new Travel("Budapest", 100.0, 50000.0, "yes"));
		travelData.add(new Travel("Debrecen", 100.0, 30000.0, "yes"));
		travelData.add(new Travel("Miskolc", 2000.0, 25000.0, "yes"));
		travelData.add(new Travel("Szeged", 3000.0, 20000.0, "yes"));
		travelData.add(new Travel("Győr", 3000.0, 30000.0, "yes"));
		travelData.add(new Travel("Nyiregyhaza", 2500.0, 25000.0, "yes"));
		travelData.add(new Travel("Bekescsaba", 2500.0, 25000.0, "yes"));
		travelData.add(new Travel("Szolnok", 2500.0, 25000.0, "yes"));
		travelData.add(new Travel("Eger", 2500.0, 25000.0, "yes"));
		travelData.add(new Travel("Salgotarjan", 2500.0, 25000.0, "yes"));
		travelData.add(new Travel("Kecskemet", 2500.0, 25000.0, "yes"));
		travelData.add(new Travel("Szekszard", 2500.0, 25000.0, "yes"));
		travelData.add(new Travel("Pecs", 2500.0, 25000.0, "yes"));
		travelData.add(new Travel("Szekesfehervar", 2500.0, 25000.0, "yes"));
		travelData.add(new Travel("Tatabanya", 2500.0, 25000.0, "yes"));
		travelData.add(new Travel("Kaposvar", 2500.0, 25000.0, "yes"));
		travelData.add(new Travel("Veszprem", 2500.0, 25000.0, "yes"));
		travelData.add(new Travel("Zalaegerszeg", 2500.0, 25000.0, "yes"));
		travelData.add(new Travel("Szombathely", 2500.0, 25000.0, "yes"));
	}	

	public ObservableList<Travel> getTravelData() {
        return travelData;
    }
	
	 public void setTravelData(ObservableList<Travel> travelData) {
		this.travelData = travelData;
	}

	@Override
	    public void start(Stage primaryStage) {
	        this.primaryStage = primaryStage;
	        this.primaryStage.setTitle("Travel");

	        menu();

	        travel();
	    }

	    public void menu() {
	        try {
	            // Load root layout from fxml file.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(MainApp.class.getResource("view/menu.fxml"));
	            rootLayout = (BorderPane) loader.load();

	            Scene scene = new Scene(rootLayout);
	            primaryStage.setScene(scene);
	            primaryStage.show();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
		
	    public void travel() {
	        try {
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(MainApp.class.getResource("view/travel.fxml"));
	            AnchorPane personOverview = (AnchorPane) loader.load();

	            rootLayout.setCenter(personOverview);
	         // Give the controller access to the main app.
	            TravelController controller = loader.getController();
	            controller.setMainApp(this);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public Stage getPrimaryStage() {
	        return primaryStage;
	    }
    public static void main(String[] args) {
    	/*
    	if(args[0].equals("-server"))
    		startInServerMode();
    	else
    		launch(args);
       */
    	launch(args);
    }
}
