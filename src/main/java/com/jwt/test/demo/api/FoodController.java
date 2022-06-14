package com.jwt.test.demo.api;

import com.jwt.test.demo.domain.Food;
import com.jwt.test.demo.payload.response.FoodResponse;
import com.jwt.test.demo.service.FoodService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api/food")
public class FoodController {
    private final @NonNull FoodService foodService;

    @GetMapping()
    public ResponseEntity<List<FoodResponse>> getAllFood(){
        return ResponseEntity.ok().body(foodService.getAllFood());
    }

    @PostMapping("/save")
    public ResponseEntity<Food> saveFood(@RequestBody Food food) {
        return ResponseEntity.ok().body(foodService.saveFood(food));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFoodById(@PathVariable Long id) {
        foodService.deleteFoodById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
