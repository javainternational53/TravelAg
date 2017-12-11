/*
package travel;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import travel.model.Travel;
import travel.view.TravelController;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	private ObservableList<Travel> travelData = FXCollections.observableArrayList();

	public MainApp() {
		travelData.add(new Travel("Budapest", 4000.0, 50000.0, 50));
		travelData.add(new Travel("Debrecen", 3000.0, 30000.0, 30));
		travelData.add(new Travel("Miskolc", 2000.0, 25000.0, 25));
		travelData.add(new Travel("Szeged", 3000.0, 20000.0, 34));
		travelData.add(new Travel("Gy�r", 3000.0, 30000.0, 23));
		travelData.add(new Travel("Eger", 2500.0, 25000.0, 19));
		travelData.add(new Travel("", 0.0, 0.0, 00));
		travelData.add(new Travel("", 0.0, 0.0, 00));
		travelData.add(new Travel("", 0.0, 0.0, 00));
		travelData.add(new Travel("", 0.0, 0.0, 00));
		travelData.add(new Travel("", 0.0, 0.0, 00));
		travelData.add(new Travel("", 0.0, 0.0, 00));
		travelData.add(new Travel("", 0.0, 0.0, 00));
		
	}
	
	public ObservableList<Travel> getTravelData() {
        return travelData;
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
	    /*
	    
	       public void swmtest() {
	        
	    }

            

	 
	    public Stage getPrimaryStage() {
	        return primaryStage;
	    }

	    public static void main(String[] args) {
	        launch(args);
	    }
}
*/



