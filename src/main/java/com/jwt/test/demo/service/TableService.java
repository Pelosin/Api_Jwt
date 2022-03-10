package com.jwt.test.demo.service;

import com.jwt.test.demo.domain.TbTable;

import java.util.List;
import java.util.Optional;

public interface TableService {
    TbTable save(TbTable table);
    Optional<TbTable> findTableByIdOrThrowBadRequest(Long id);
    Long occupyTable(Long id);
    void leaveTable(Long id);
    TbTable findByTableNumber(String tableNumber);
    List<TbTable> getTables();
}
