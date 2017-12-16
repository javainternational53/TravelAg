package travelling.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="BookedTravel")
public class BookedTravel {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long Id;
	
	long userId;
	
	long travelId;
	
	double sum;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getTravelId() {
		return travelId;
	}

	public void setTravelId(long travelId) {
		this.travelId = travelId;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double price) {
		this.sum = price;
	}

	@Override
	public String toString() {
		return "BookedTravel [Id=" + Id + ", userId=" + userId + ", travel=" + travelId + ", sum=" + sum + "]";
	}
	
	
	
	
	
	
	
}
