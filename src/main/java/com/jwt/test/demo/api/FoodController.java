package com.jwt.test.demo.api;

import com.jwt.test.demo.payload.response.FoodResponse;
import com.jwt.test.demo.service.FoodService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/food")
public class FoodController {
    private final @NonNull FoodService foodService;

    @GetMapping()
    public ResponseEntity<List<FoodResponse>> getAllFood(){
        return ResponseEntity.ok().body(foodService.getAllFood());
    }
}
