package com.jwt.test.demo.service.serviceImplementation;

import com.jwt.test.demo.domain.Category;
import com.jwt.test.demo.domain.Food;
import com.jwt.test.demo.repo.CategoryRepo;
import com.jwt.test.demo.service.CategoryService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class CategoryServiceImpl implements CategoryService {

    private final @NonNull CategoryRepo categoryRepo;

    @Override
    public List<Category> findAllCategories() {
        log.info("Getting categories");
        return categoryRepo.findAll();
    }

    @Override
    public Category addFoodToCategory(Long id, Food food) {
        Category category = categoryRepo.findById(id).get();
        category.getFoodList().add(food);
        return categoryRepo.save(category);
    }
}
