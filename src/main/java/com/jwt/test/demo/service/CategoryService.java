package com.jwt.test.demo.service;

import com.jwt.test.demo.domain.Category;
import com.jwt.test.demo.domain.Food;

import java.util.List;

public interface CategoryService {
    List<Category> findAllCategories();

    Category addFoodToCategory(Long id, Food food);
}
