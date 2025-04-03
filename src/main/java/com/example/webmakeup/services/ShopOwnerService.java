package com.example.webmakeup.services;

import com.example.webmakeup.models.ShopOwner;

import java.util.List;
import java.util.Optional;

public interface ShopOwnerService {
    List<ShopOwner> getAllShopOwners();
    Optional<ShopOwner> getShopOwnerById(Long id);
    ShopOwner createShopOwner(ShopOwner shopOwner);
    Optional<ShopOwner> updateShopOwner(Long id, ShopOwner shopOwnerDetails);
    boolean deleteShopOwner(Long id);
}
