package com.jwt.test.demo.repo;

import com.jwt.test.demo.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepo extends JpaRepository<Category, Long> {
    public Category save(Category foodCategory);
    public Optional<Category> findById(Long id);
}
