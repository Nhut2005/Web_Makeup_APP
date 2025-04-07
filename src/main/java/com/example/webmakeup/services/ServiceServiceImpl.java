package com.example.webmakeup.services;

import org.springframework.stereotype.Service;
import com.example.webmakeup.models.ServiceModel;
import com.example.webmakeup.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public ServiceModel createService(ServiceModel service) {
        return serviceRepository.save(service);
    }

    @Override
    public List<ServiceModel> getAllServices() {
        return serviceRepository.findAll();
    }

    @Override
    public ServiceModel getServiceById(Long id) {
        Optional<ServiceModel> service = serviceRepository.findById(id);
        return service.orElseThrow(() -> new RuntimeException("Service not found"));
    }

    @Override
    public ServiceModel updateService(Long id, ServiceModel service) {
        ServiceModel existingService = getServiceById(id);
        existingService.setName(service.getName());
        existingService.setDescription(service.getDescription());
        existingService.setPrice(service.getPrice());
        return serviceRepository.save(existingService);
    }

    @Override
    public void deleteService(Long id) {
        serviceRepository.deleteById(id);
    }

    @Override
    public List<ServiceModel> searchServicesByName(String name) {
        return serviceRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<ServiceModel> getServicesByPriceRange(double minPrice, double maxPrice) {
        return serviceRepository.findByPriceBetween(minPrice, maxPrice);
    }
}
