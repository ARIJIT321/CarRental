package car;

import java.time.LocalDate;

public class Rent {
	private String carId;
    private String customerId;
    private LocalDate rentDate;
    
    
    
	public Rent(String carId, String customerId, LocalDate rentDate) {
		super();
		this.carId = carId;
		this.customerId = customerId;
		this.rentDate = rentDate;
	}
	public String getCarId() {
		return carId;
	}
	public void setCarId(String carId) {
		this.carId = carId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public LocalDate getRentDate() {
		return rentDate;
	}
	public void setRentDate(LocalDate rentDate) {
		this.rentDate = rentDate;
	}
	
	@Override
	public String toString() {
		return "Rent [carId=" + carId + ", customerId=" + customerId + ", rentDate=" + rentDate + "]";
	}
    
    
}
