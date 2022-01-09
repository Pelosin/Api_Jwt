package com.jwt.test.demo.service.serviceImplementation;

import com.jwt.test.demo.domain.Food;
import com.jwt.test.demo.mapper.FoodMapper;
import com.jwt.test.demo.payload.response.FoodResponse;
import com.jwt.test.demo.repo.FoodRepo;
import com.jwt.test.demo.service.FoodService;
import com.jwt.test.demo.util.FoodCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class FoodServiceImplTest {
    @InjectMocks
    private FoodServiceImpl foodService;

    @Mock
    private FoodRepo foodRepoMock;

    @Mock
    private FoodMapper foodMapper;

    @BeforeEach
    void setUp(){


        BDDMockito.when(foodRepoMock.findAll())
                .thenReturn(List.of(FoodCreator.createValidFoodResponse()));

        BDDMockito.when(foodRepoMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(FoodCreator.createValidFood()));

        BDDMockito.when(foodRepoMock.save(ArgumentMatchers.any(Food.class)))
                .thenReturn(FoodCreator.createValidFood());

        BDDMockito.doNothing().when(foodRepoMock).delete(ArgumentMatchers.any(Food.class));
    }


    @Test
    @DisplayName("findAll returns a List of FoodResponse when successful")
    void findAll_ReturnsListOfFood_WhenSuccessful(){
        String expectedName = FoodCreator.createValidFood().getName();

        List<FoodResponse> foodList = foodService.getAllFood();

        Assertions.assertThat(foodList).isNotNull().hasSize(1);
        Assertions.assertThat(foodList.get(0).getName()).isEqualTo(expectedName);

    }

}