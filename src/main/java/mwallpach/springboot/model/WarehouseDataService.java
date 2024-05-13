package mwallpach.springboot.model;

import mwallpach.springboot.repository.ProductRepository;
import mwallpach.springboot.repository.WarehouseDataRepository;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class WarehouseDataService {
    private final RestTemplate restTemplate;
    private final WarehouseDataRepository warehouseDataRepository;
    private final ProductRepository productRepository;

    public WarehouseDataService(RestTemplate restTemplate, WarehouseDataRepository warehouseDataRepository, ProductRepository productRepository) {
        this.restTemplate = restTemplate;
        this.warehouseDataRepository = warehouseDataRepository;
        this.productRepository = productRepository;
    }

    public void fetchDataAndStoreInMongoDB() {
        // Daten von der REST-Schnittstelle abrufen
        // Annahme: Die REST-Schnittstelle gibt WarehouseData-Objekte zurück
        ResponseEntity<WarehouseData[]> response = restTemplate.exchange(
                "http://localhost:8080/warehouse/all",
                HttpMethod.GET,
                null,
                WarehouseData[].class
        );

        // Daten in MongoDB speichern
        Arrays.asList(response.getBody()).forEach(warehouseData -> {
            warehouseDataRepository.save(warehouseData);
            warehouseData.getProducts().forEach(product -> productRepository.save(product));
        });
    }
}
