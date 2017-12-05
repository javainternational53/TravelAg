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
    public void start(Stage primaryStage) throws Exception{
    	//System.out.println("duplaasd");
    	//RS
    	
    	//loader.setLocation(Main.class.getResourceAsStream("sample.fxml"));
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/T1.fxml"));

        primaryStage.setScene(new Scene(root, 500, 775));
        primaryStage.show();
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
