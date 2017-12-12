package travelling.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "Szallas")
public class Szallas {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	
	String address;
	
	Quality qualityOfSzallas;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Quality getQualityOfSzallas() {
		return qualityOfSzallas;
	}

	public void setQualityOfSzallas(Quality qualityOfSzallas) {
		this.qualityOfSzallas = qualityOfSzallas;
	}

	@Override
	public String toString() {
		return "szallas [id=" + id + ", address=" + address + ", qualityOfSzallas=" + qualityOfSzallas + "]";
	}
	
	
}
