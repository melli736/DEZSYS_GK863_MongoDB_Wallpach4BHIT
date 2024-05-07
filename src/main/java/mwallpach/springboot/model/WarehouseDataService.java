package mwallpach.springboot.model;

import mwallpach.springboot.repository.*;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;

@Service
public class WarehouseDataService {
    private final RestTemplate restTemplate;
    private final WarehouseDataRepository warehouseDataRepository;

    public WarehouseDataService(RestTemplate restTemplate, WarehouseDataRepository warehouseDataRepository) {
        this.restTemplate = restTemplate;
        this.warehouseDataRepository = warehouseDataRepository;
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
        Arrays.asList(response.getBody()).forEach(warehouseDataRepository::save);
    }
}
