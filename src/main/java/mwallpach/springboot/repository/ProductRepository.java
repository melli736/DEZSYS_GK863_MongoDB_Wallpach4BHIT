package mwallpach.springboot.repository;

import mwallpach.springboot.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
    Iterable<Product> findByWarehouseID(String warehouseID);
    Iterable<Product> findByWarehouseIDAndProductName(String warehouseID, String productName);
    Iterable<Product> findByProductQuantityLessThan(double quantity);
    Iterable<Product> findByWarehouseIDAndProductQuantityLessThan(String warehouseID, double quantity);
    Iterable<Product> findByProductCategoryIn(String... categories);
}
