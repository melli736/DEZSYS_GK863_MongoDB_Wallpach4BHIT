package mwallpach.springboot.model;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.*;

@Configuration
@EnableScheduling
public class DataScheduler {
    private final WarehouseDataService warehouseDataService;

    public DataScheduler(WarehouseDataService warehouseDataService) {
        this.warehouseDataService = warehouseDataService;
    }

    @Scheduled(fixedRate = 60000) // Beispiel: alle 60 Sekunden ausführen
    public void fetchDataAndStoreInMongoDB() {
        warehouseDataService.fetchDataAndStoreInMongoDB();
    }
}

