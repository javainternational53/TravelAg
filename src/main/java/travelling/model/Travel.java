package travelling.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
@Table(name = "Travel")
public class Travel implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long Id;
	private String city;
	private Double minPrice;
	private Double maxPrice;
	private String packageOffer;
	private Integer numberOfPersons;
	
	public Travel(){
	}

	public Travel(String city, Double minPrice, Double maxPrice, String packageOffer, int numberOfPersons) {
		super();
		this.city = city;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.packageOffer = packageOffer;
		this.numberOfPersons = numberOfPersons;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public StringProperty cityProperty() {
		return new SimpleStringProperty(city);
	}
	
	public Double getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
	}
	public DoubleProperty minPriceProperty() {
		return new SimpleDoubleProperty(minPrice);
	}
	
	public Double getMAxPrice() {
		return maxPrice;
	}
	
	public void setMaxPrice(Double maxPrice) {
		this.maxPrice=maxPrice;
	}
	
	public DoubleProperty maxPriceProperty() {
		return new SimpleDoubleProperty(maxPrice);
	}
	
	public String getPackageOffer() {
		return packageOffer;
	}
	
	public void setPackageOffer(String packageOffer) {
		this.packageOffer=packageOffer;
	}
	
	public StringProperty packageOfferProperty() {
		return new SimpleStringProperty(packageOffer);
	}
	
	public int getNumberOfPersons() {
		return numberOfPersons;
	}
	
	public void setNumberOfPersons(int numberOfPersons) {
		this.numberOfPersons=numberOfPersons;
	}
	
	public IntegerProperty numberOfPersonsProperty() {
		return new SimpleIntegerProperty(numberOfPersons);
	}

	@Override
	public String toString() {
		return "Travel [Id=" + Id + ", city=" + city + ", minPrice=" + minPrice + ", maxPrice=" + maxPrice
				+ ", packageOffer=" + packageOffer + ", numberOfPersons=" + numberOfPersons + "]";
	}
	
	
}
