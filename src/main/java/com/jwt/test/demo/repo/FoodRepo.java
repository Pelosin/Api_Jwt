package com.jwt.test.demo.repo;


import com.jwt.test.demo.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepo extends JpaRepository<Food, Long> {
    public Food findByName(String name);
}
