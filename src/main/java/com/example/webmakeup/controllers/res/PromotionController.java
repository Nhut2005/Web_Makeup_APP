package com.example.webmakeup.controllers;


import com.example.webmakeup.models.Promotion;
import com.example.webmakeup.services.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/promotions")
public class PromotionController {

    @Autowired
    private PromotionService promotionService;

    @PostMapping
    public ResponseEntity<Promotion> create(@RequestBody Promotion promotion) {
        return new ResponseEntity<>(promotionService.createPromotion(promotion), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Promotion>> getAll() {
        return ResponseEntity.ok(promotionService.getAllPromotions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Promotion> getById(@PathVariable Long id) {
        return ResponseEntity.ok(promotionService.getPromotionById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Promotion> update(@PathVariable Long id, @RequestBody Promotion promotion) {
        return ResponseEntity.ok(promotionService.updatePromotion(id, promotion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        promotionService.deletePromotion(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/active")
    public ResponseEntity<List<Promotion>> getActive() {
        return ResponseEntity.ok(promotionService.getActivePromotions());
    }
}
