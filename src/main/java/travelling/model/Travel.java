package travelling.model;

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
	private StringProperty packageOffer;
	private IntegerProperty numberOfPersons;
	
	public Travel(){
	}

	public Travel(String city, Double minPrice, Double maxPrice, String packageOffer, int numberOfPersons) {
		super();
		this.city = new SimpleStringProperty(city);
		this.minPrice = new SimpleDoubleProperty(minPrice);
		this.maxPrice = new SimpleDoubleProperty(maxPrice);
		this.packageOffer = new SimpleStringProperty(packageOffer);
		this.numberOfPersons = new SimpleIntegerProperty(numberOfPersons);
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
	
	public String getPackageOffer() {
		return packageOffer.get();
	}
	public void setPackageOffer(String packageOffer) {
		this.packageOffer.set(packageOffer);
	}
	public StringProperty packageOfferProperty() {
		return packageOffer;
	}
	
	public int getNumberOfPersons() {
		return numberOfPersons.get();
	}
	public void setNumberOfPersons(int numberOfPersons) {
		this.numberOfPersons.set(numberOfPersons);
	}
	public IntegerProperty numberOfPersonsProperty() {
		return numberOfPersons;
	}
}
