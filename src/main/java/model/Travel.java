package travel.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Travel {
	private StringProperty city;
	private DoubleProperty minPrice;
	private DoubleProperty maxPrice;
	private IntegerProperty hotelsNumber;
	
	public Travel(){
	}

	public Travel(String city, Double minPrice, Double maxPrice, int hotelsNumber) {
		super();
		this.city = new SimpleStringProperty(city);
		this.minPrice = new SimpleDoubleProperty(minPrice);
		this.maxPrice = new SimpleDoubleProperty(maxPrice);
		this.hotelsNumber = new SimpleIntegerProperty(hotelsNumber);
	}
	
	public String getCity() {
		return city.get();
	}
	public void setCity(String city) {
		this.city.set(city);
	}
	public StringProperty cityProperty() {
		return city;
	}
	
	public Double getMinPrice() {
		return minPrice.get();
	}
	public void setMinPrice(Double minPrice) {
		this.minPrice.set(minPrice);
	}
	public DoubleProperty minPriceProperty() {
		return minPrice;
	}
	
	public Double getMAxPrice() {
		return maxPrice.get();
	}
	public void setMaxPrice(Double maxPrice) {
		this.maxPrice.set(maxPrice);
	}
	public DoubleProperty maxPriceProperty() {
		return maxPrice;
	}
	
	public int getHotelsNumber() {
		return hotelsNumber.get();
	}
	public void setHotelsNumber(int hotelsNumber) {
		this.hotelsNumber.set(hotelsNumber);
	}
	public IntegerProperty hotelsNumberProperty() {
		return hotelsNumber;
	}
}
