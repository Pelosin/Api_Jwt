package com.jwt.test.demo.mapper;

import com.jwt.test.demo.domain.Food;
import com.jwt.test.demo.payload.response.FoodResponse;
import com.jwt.test.demo.repo.FoodRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class FoodMapper {
    private final FoodRepo foodRepo;

    public List<FoodResponse> toFoods(List<Food> foodList) {
        List<FoodResponse> foodResponseList = new ArrayList<>();

        for (Food food : foodList) {
            FoodResponse foodResponse = new FoodResponse(food.getName(),
                    food.getDescription(), food.getPrice(), food.getUrl());
            foodResponseList.add(foodResponse);
        }
        return foodResponseList;
    }

}

