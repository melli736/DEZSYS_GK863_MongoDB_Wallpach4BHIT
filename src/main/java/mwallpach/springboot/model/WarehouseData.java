package mwallpach.springboot.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.data.annotation.Id;

@Document(collection = "warehouseData")
public class WarehouseData {

	@Id
	private String id;
	private String warehouseName;
	private String timestamp;
	private List<Product> products;

	/**
	 * Constructor
	 */
	public WarehouseData() {
		this.products = new ArrayList<>();
		this.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
	}

	public void addProduct(Product product) {
		this.products.add(product);
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

	public List<Product> getProducts() {
		return this.products;
	}

	/**
	 * Methods
	 */
	@Override
	public String toString() {
		String info = String.format("Warehouse Info: ID = %s, Name = %s, timestamp = %s", id, warehouseName, timestamp );
		return info;
	}
}
