package travelling.view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CityController {
	@FXML
	private CheckBox termalBathCb;
	@FXML
	private CheckBox cinemaCb;
	@FXML
	private CheckBox museumCb;
	@FXML
	private CheckBox restaurantCb;
	@FXML
	private CheckBox confectioneryCb;
	@FXML
	private CheckBox amusementParckCb;
	@FXML
	private CheckBox casinoCb;
	@FXML
	private CheckBox zooCb;

	@FXML
	private TextField startingPrice;
	@FXML
	private TextField totalPrice;
	@FXML
	private TextField termalBatchPrice;
	@FXML
	private TextField cinemaPrice;
	@FXML
	private TextField museumPrice;
	@FXML
	private TextField restaurantPrice;
	@FXML
	private TextField confectioneryPrice;
	@FXML
	private TextField amusementParckPrice;
	@FXML
	private TextField casinoPrice;
	@FXML
	private TextField zooPrice;
	
	@FXML
	private Button Accept = new Button();
	
	@FXML
	public Label cityName;
	
	public Label getCityName() {
		return cityName;
	}
	public void setCityName(Label cityName) {
		this.cityName = cityName;
	}
	public static double price;
	@FXML
	private void initialize() {
		price  = Double.parseDouble(startingPrice.getText());
		termalBathCb.setOnAction((event) -> {
			boolean selected = termalBathCb.isSelected();
			if (selected) {
				//System.out.println(price);
				price += Double.parseDouble(termalBatchPrice.getText());

				totalPrice.setText(Double.toString(price));
			} else {
				price -= Double.parseDouble(termalBatchPrice.getText());

				totalPrice.setText(Double.toString(price));
			}
		});
		
		cinemaCb.setOnAction((event) -> {
			boolean selected = cinemaCb.isSelected();
			if (selected) {
				//System.out.println(price);
				price += Double.parseDouble(cinemaPrice.getText());

				totalPrice.setText(Double.toString(price));
			} else {
				price -= Double.parseDouble(cinemaPrice.getText());

				totalPrice.setText(Double.toString(price));
			}
		});
		
		museumCb.setOnAction((event) -> {
			boolean selected = museumCb.isSelected();
			if (selected) {
				//System.out.println(price);
				price += Double.parseDouble(museumPrice.getText());

				totalPrice.setText(Double.toString(price));
			} else {
				price -= Double.parseDouble(museumPrice.getText());

				totalPrice.setText(Double.toString(price));
			}
		});
		
		restaurantCb.setOnAction((event) -> {
			boolean selected = restaurantCb.isSelected();
			if (selected) {
				//System.out.println(price);
				price += Double.parseDouble(restaurantPrice.getText());

				totalPrice.setText(Double.toString(price));
			} else {
				price -= Double.parseDouble(restaurantPrice.getText());

				totalPrice.setText(Double.toString(price));
			}
		});
		
		confectioneryCb.setOnAction((event) -> {
			boolean selected = confectioneryCb.isSelected();
			if (selected) {
				//System.out.println(price);
				price += Double.parseDouble(confectioneryPrice.getText());

				totalPrice.setText(Double.toString(price));
			} else {
				price -= Double.parseDouble(confectioneryPrice.getText());

				totalPrice.setText(Double.toString(price));
			}
		});
		
		amusementParckCb.setOnAction((event) -> {
			boolean selected = amusementParckCb.isSelected();
			if (selected) {
				//System.out.println(price);
				price += Double.parseDouble(amusementParckPrice.getText());

				totalPrice.setText(Double.toString(price));
			} else {
				price -= Double.parseDouble(amusementParckPrice.getText());

				totalPrice.setText(Double.toString(price));
			}
		});
		
		casinoCb.setOnAction((event) -> {
			boolean selected = casinoCb.isSelected();
			if (selected) {
				//System.out.println(price);
				price += Double.parseDouble(casinoPrice.getText());

				totalPrice.setText(Double.toString(price));
			} else {
				price -= Double.parseDouble(casinoPrice.getText());

				totalPrice.setText(Double.toString(price));
			}
		});
		
		zooCb.setOnAction((event) -> {
			boolean selected = zooCb.isSelected();
			if (selected) {
				//System.out.println(price);
				price += Double.parseDouble(zooPrice.getText());

				totalPrice.setText(Double.toString(price));
			} else {
				price -= Double.parseDouble(zooPrice.getText());

				totalPrice.setText(Double.toString(price));
			}
		});
	}
	@FXML
    void makeBack(ActionEvent event) throws IOException {
        ((Node)(event.getSource())).getScene().getWindow().hide();

    }
	@FXML
    void accept(ActionEvent event) throws IOException {
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("travelling/view/foglalas.fxml"));
		Scene scene = new Scene(root, 500, 215);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Accept");
		primaryStage.show();
		((Node)(event.getSource())).getScene().getWindow().hide();
		System.out.println("ok");
	}
}
