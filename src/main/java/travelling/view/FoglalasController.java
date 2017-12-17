package travelling.view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import travelling.model.BookedTravel;

public class FoglalasController {
	private TravelController city;
	private CityController totalPrice;
	@FXML
	private Label cityName;
	@FXML
	private Label totalPriceLabel;
	
	private BookedTravel bookedTravel;
	
	public BookedTravel getBookedTravel() {
		return bookedTravel;
	}
	public void setBookedTravel(BookedTravel bookedTravel) {
		this.bookedTravel = bookedTravel;
	}
	
	@FXML
	private void initialize() {
		String proba = city.CityName;
		System.out.println(proba);
		cityName.setText(city.CityName);
		totalPriceLabel.setText(Double.toString(totalPrice.price));
	}
	@FXML
    void exit(ActionEvent event) throws IOException {
        ((Node)(event.getSource())).getScene().getWindow().hide();
        bookedTravel=new BookedTravel();
        
        bookedTravel.setSum(totalPrice.price);
    }

}
