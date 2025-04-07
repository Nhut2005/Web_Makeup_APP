package com.example.webmakeup.repositories;

import com.example.webmakeup.models.ServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ServiceRepository extends JpaRepository<ServiceModel, Long> {
    List<ServiceModel> findByPriceBetween(double minPrice, double maxPrice);  // Phương thức này phải có trong repository
    List<ServiceModel> findByNameContainingIgnoreCase(String name);
}

