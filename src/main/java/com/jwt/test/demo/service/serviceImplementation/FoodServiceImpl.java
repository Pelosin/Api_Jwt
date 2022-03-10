package com.jwt.test.demo.service.serviceImplementation;

import com.jwt.test.demo.domain.Food;
import com.jwt.test.demo.mapper.FoodMapper;
import com.jwt.test.demo.payload.response.FoodResponse;
import com.jwt.test.demo.repo.FoodRepo;
import com.jwt.test.demo.service.FoodService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.juli.logging.Log;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class FoodServiceImpl implements FoodService {

    private final @NonNull FoodRepo foodRepo;
    private final @NonNull FoodMapper foodMapper;

    @Override
    public List<FoodResponse> getAllFood() {
        List<FoodResponse> foodResponseList = foodMapper.toFoods(foodRepo.findAll());
        log.info("Getting Food");
        return foodResponseList;
    }

    @Override
    @org.springframework.transaction.annotation.Transactional
    public Food saveFood(Food food) {
        return foodRepo.save(food);
    }

    @Override
    public void deleteFoodById(Long id) {
        foodRepo.delete(foodRepo.findById(id).get());
    }

    @Override
    public Food findById(Long id) {
        return foodRepo.findById(id).get();
    }


}
