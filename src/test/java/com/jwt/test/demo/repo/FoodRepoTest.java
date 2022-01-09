package com.jwt.test.demo.repo;

import com.jwt.test.demo.domain.Food;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DisplayName("Tests for foodRepo")
class FoodRepoTest {

    @Autowired
    private FoodRepo foodRepo;

    @Test
    @DisplayName("Save persist food when successful")
    public void save_PersistFood_WhenSuccessful(){
        Food foodToBeSaved = createFood();
        Food savedFood = foodRepo.save(foodToBeSaved);
        Assertions.assertThat(savedFood).isNotNull();
        Assertions.assertThat(foodToBeSaved.getName()).isEqualTo(savedFood.getName());
    }

    @Test
    @DisplayName("Get All returns a list of foods when successful")
    public void getAll_ReturnsListOfFood_WhenSuccessful(){
        Food foodToBeSaved = createFood();
        Food savedFood = foodRepo.save(foodToBeSaved);
        List<Food> foodList = foodRepo.findAll();
        Assertions.assertThat(foodList).isNotNull();
    }

    @Test
    @DisplayName("Delete remove food when successful")
    public void delete_RemoveFood_WhenSuccessful(){
        Food foodToBeSaved = createFood();
        foodRepo.save(foodToBeSaved);
        foodRepo.delete(foodToBeSaved);
        Optional<Food> deletedFood = foodRepo.findById(foodToBeSaved.getId());
        Assertions.assertThat(deletedFood).isEmpty();
    }

    @Test
    @DisplayName("Save updates food when successful")
    public void save_UpdatesFood_WhenSuccessful(){
        Food foodToBeSave = createFood();
        Food savedFood = foodRepo.save(foodToBeSave);

        savedFood.setName("Lolo");

        Food updatedFood = foodRepo.save(savedFood);

        Assertions.assertThat(updatedFood).isNotNull();
        Assertions.assertThat(updatedFood.getId()).isNotNull();
        Assertions.assertThat(updatedFood.getName()).isEqualTo(savedFood.getName());

    }
    public Food createFood(){
        return Food.builder()
                .name("Sla")
                .description("Bla")
                .price(new BigDecimal(6.50))
                .build();
    }

}