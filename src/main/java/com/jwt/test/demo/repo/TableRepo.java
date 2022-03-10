package com.jwt.test.demo.repo;

import com.jwt.test.demo.domain.TbTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepo extends JpaRepository<TbTable ,Long> {
    TbTable findByTableNumber(String tableNumber);
}
