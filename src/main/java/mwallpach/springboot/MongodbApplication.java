package mwallpach.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import mwallpach.springboot.model.Product;
import mwallpach.springboot.model.WarehouseData;
import mwallpach.springboot.repository.*;

@SpringBootApplication
@RestController
@RequestMapping("/warehouse")
public class MongodbApplication implements CommandLineRunner {

	@Autowired
	private WarehouseDataRepository warehouseDataRepository;

	public static void main(String[] args) {
		SpringApplication.run(MongodbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}

	@PostMapping("/addProduct/{id}")
	public WarehouseData addProductToWarehouse(@PathVariable String id, @RequestBody Product product) {
		WarehouseData warehouse = warehouseDataRepository.findById(id).orElse(null);
		if (warehouse != null) {
			warehouse.addProduct(product);
			return warehouseDataRepository.save(warehouse);
		}
		return null; // Warehouse not found
	}

	@GetMapping("/all")
	public Iterable<WarehouseData> getAllWarehouses() {
		return warehouseDataRepository.findAll();
	}

	@GetMapping("/{id}/products")
	public Iterable<Product> getProductsByWarehouse(@PathVariable String id) {
		WarehouseData warehouse = warehouseDataRepository.findById(id).orElse(null);
		if (warehouse != null) {
			return warehouse.getProducts();
		}
		return null; // Warehouse not found
	}
}
