package com.example.webmakeup.controllers;

import com.example.webmakeup.models.ServiceModel;
import com.example.webmakeup.services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @PostMapping
    public ResponseEntity<ServiceModel> createService(@RequestBody ServiceModel service) {
        ServiceModel createdService = serviceService.createService(service);
        return new ResponseEntity<>(createdService, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ServiceModel>> getAllServices() {
        List<ServiceModel> services = serviceService.getAllServices();
        return new ResponseEntity<>(services, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceModel> getServiceById(@PathVariable Long id) {
        ServiceModel service = serviceService.getServiceById(id);
        return new ResponseEntity<>(service, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceModel> updateService(@PathVariable Long id, @RequestBody ServiceModel service) {
        ServiceModel updatedService = serviceService.updateService(id, service);
        return new ResponseEntity<>(updatedService, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable Long id) {
        serviceService.deleteService(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ServiceModel>> searchServices(@RequestParam String name) {
        List<ServiceModel> services = serviceService.searchServicesByName(name);
        return new ResponseEntity<>(services, HttpStatus.OK);
    }

    @GetMapping("/price-range")
    public ResponseEntity<List<ServiceModel>> getServicesByPriceRange(@RequestParam double minPrice, @RequestParam double maxPrice) {
        List<ServiceModel> services = serviceService.getServicesByPriceRange(minPrice, maxPrice);
        return new ResponseEntity<>(services, HttpStatus.OK);
    }
}