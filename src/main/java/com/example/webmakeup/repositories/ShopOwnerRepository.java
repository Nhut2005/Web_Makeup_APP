package com.example.webmakeup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.webmakeup.models.ShopOwner;

@Repository
public interface ShopOwnerRepository extends JpaRepository<ShopOwner, Long> {
    ShopOwner findByUsername(String username);
}
