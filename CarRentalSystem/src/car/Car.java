package car;

import java.io.Serializable;

public class Car implements Serializable{
	
	private String carId;
    private String brand;
    private String model;
    private int price;
    private boolean isAvailable;
    

    public Car(String carId, String brand, String model,int price, boolean isAvailable) {
		super();
		this.carId = carId;
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.isAvailable = isAvailable;
	}


	public String getCarId() {
		return carId;
	}


	public void setCarId(String carId) {
		this.carId = carId;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public boolean isAvailable() {
		return isAvailable;
	}


	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}


	@Override
	public String toString() {
		return "Car [carId=" + carId + ", brand=" + brand + ", model=" + model + ", price=" + price + ", isAvailable="
				+ isAvailable + "]";
	}




	
    
    
}
