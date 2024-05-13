package mwallpach.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import mwallpach.springboot.model.Product;
import mwallpach.springboot.model.WarehouseData;
import mwallpach.springboot.repository.WarehouseDataRepository;

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

	@GetMapping("/all")
	public Iterable<WarehouseData> getAllWarehouses() {
		return warehouseDataRepository.findAll();
	}

	@GetMapping("/{id}")
	public WarehouseData getWarehouseById(@PathVariable String id) {
		return warehouseDataRepository.findById(id).orElse(null);
	}

	@GetMapping("/{id}/products")
	public Iterable<Product> getProductsByWarehouseId(@PathVariable String id) {
		WarehouseData warehouse = warehouseDataRepository.findById(id).orElse(null);
		if (warehouse != null) {
			return warehouse.getProducts();
		}
		return null; // Warehouse not found
	}
}
