package com.jwt.test.demo.util;

import com.jwt.test.demo.domain.Food;

import java.math.BigDecimal;

public class FoodCreator {
    public static Food createFoodToBeSaved(){
        return Food.builder()
                .name("Spaguetyyy")
                .description("Italiano capitche")
                .price(new BigDecimal(13.50))
                .build();
    }

    public static Food createValidFood(){
        return Food.builder()
                .id(1L)
                .name("Spaguetyyy")
                .description("Italiano capitche")
                .price(new BigDecimal(13.50))
                .build();
    }

    public static Food createValidUpdatedFood(){
        return Food.builder()
                .id(1L)
                .name("Spaguetyyy 2")
                .description("Italiano capitche, itsa me mariooooo")
                .price(new BigDecimal(13.50))
                .build();
    }

    public static Food createValidFoodResponse(){
        return Food.builder()
                .name("Spaguetyyy 2")
                .description("Italiano capitche, itsa me mariooooo")
                .price(new BigDecimal(13.50))
                .build();
    }
}
