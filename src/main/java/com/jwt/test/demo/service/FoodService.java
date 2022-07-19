package com.jwt.test.demo.service;

import com.jwt.test.demo.domain.Food;
import com.jwt.test.demo.payload.response.FoodResponse;

import java.util.List;
import java.util.Optional;

public interface FoodService {
    List<FoodResponse> getAllFood();
    Food saveFood(Food food);
    void deleteFoodById(Long id);
    Food findById(Long id);
    void changeImage(Long id, String url);
}
