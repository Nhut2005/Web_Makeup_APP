package com.example.webmakeup.services;

import com.example.webmakeup.models.Promotion;

import java.util.List;

public interface PromotionService {
    Promotion createPromotion(Promotion promotion);
    List<Promotion> getAllPromotions();
    Promotion getPromotionById(Long id);
    Promotion updatePromotion(Long id, Promotion promotion);
    void deletePromotion(Long id);
    List<Promotion> getActivePromotions();
}