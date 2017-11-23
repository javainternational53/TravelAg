package login;

import java.io.InputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.User;
import persistence.PersistenceManager;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/login.fxml"));
			Scene scene = new Scene(root,700,450);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

    public static void main(String[] args) {
    	
    	User user=new User();
        user.setUsername("asd");
        user.setId(0);
        
        PersistenceManager.createUser(user);
        
        user=null;
        
        user=PersistenceManager.getUserByName("asd");
        
        System.out.println(user);
    	
    	launch(args);
       
    }
}
