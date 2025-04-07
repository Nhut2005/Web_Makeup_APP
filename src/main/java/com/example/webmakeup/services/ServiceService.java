package com.example.webmakeup.services;

import com.example.webmakeup.models.ServiceModel;

import java.util.List;

public interface ServiceService {
    ServiceModel createService(ServiceModel service);
    List<ServiceModel> getAllServices();
    ServiceModel getServiceById(Long id);
    ServiceModel updateService(Long id, ServiceModel service);
    void deleteService(Long id);
    List<ServiceModel> searchServicesByName(String name);
    List<ServiceModel> getServicesByPriceRange(double minPrice, double maxPrice);
}
