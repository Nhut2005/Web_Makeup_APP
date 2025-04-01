package com.example.webmakeup.controllers.res;

import com.example.webmakeup.models.ShopOwner;
import com.example.webmakeup.services.ShopOwnerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shopowners")
public class ShopOwnerController {

    private final ShopOwnerService shopOwnerService;

    public ShopOwnerController(ShopOwnerService shopOwnerService) {
        this.shopOwnerService = shopOwnerService;
    }

    @GetMapping
    public List<ShopOwner> getAllShopOwners() {
        return shopOwnerService.getAllShopOwners();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShopOwner> getShopOwnerById(@PathVariable Long id) {
        Optional<ShopOwner> shopOwner = shopOwnerService.getShopOwnerById(id);
        return shopOwner.map(ResponseEntity::ok)
                        .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ShopOwner createShopOwner(@RequestBody ShopOwner shopOwner) {
        return shopOwnerService.createShopOwner(shopOwner);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShopOwner> updateShopOwner(@PathVariable Long id, @RequestBody ShopOwner shopOwnerDetails) {
        Optional<ShopOwner> updatedShopOwner = shopOwnerService.updateShopOwner(id, shopOwnerDetails);
        return updatedShopOwner.map(ResponseEntity::ok)
                               .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShopOwner(@PathVariable Long id) {
        if (shopOwnerService.deleteShopOwner(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
