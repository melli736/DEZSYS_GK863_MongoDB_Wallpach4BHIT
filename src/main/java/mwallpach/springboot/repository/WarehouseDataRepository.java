package mwallpach.springboot.repository;

import mwallpach.springboot.model.*;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WarehouseDataRepository extends MongoRepository<WarehouseData, String> {
}
