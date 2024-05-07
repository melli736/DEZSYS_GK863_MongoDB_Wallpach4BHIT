package mwallpach.springboot;

import org.springframework.data.mongodb.core.mapping.Document;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "warehouseData")
public class WarehouseData {

	@Id
	private String id;
	private String warehouseName;
	private String timestamp;
	private String street;
	private String city;
	private String country;
	private String plz;
	private List<Product> productData;

	/**
	 * Constructor
	 */
	public WarehouseData() {

		int r = new Random().nextInt(6) + 4;

		productData = new ArrayList<Product>(r);

		for(int i = 0; i < r; i++) {
			productData.add(new Product());
		}

		this.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());

	}

	public List<Product> getProductData() {
		return this.productData;
	}

	public void setProductData(ArrayList<Product> productData) {
		this.productData = productData;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}


	public String getStreet() {
		return this.street;
	}

	public String getCity() {
		return this.city;
	}

	public String getCountry() {
		return this.country;
	}

	public String getPlz() {
		return this.plz;
	}


	public String getWarehouseID() {
		return id;
	}

	public void setWarehouseID(String warehouseID) {
		this.id = warehouseID;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * Methods
	 */
	@Override
	public String toString() {
		String info = String.format("Warehouse Info: ID = %s, timestamp = %s", id, timestamp );
		return info;
	}
}
