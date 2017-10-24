package login;


// beágyazási str : srv - ver 1.2 


import java.io.InputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

    	//RS
    	//loader.setLocation(Main.class.getResourceAsStream("sample.fxml"));
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/sample.fxml"));

 

        primaryStage.setScene(new Scene(root, 500, 775));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
