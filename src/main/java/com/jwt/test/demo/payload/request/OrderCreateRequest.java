package com.jwt.test.demo.payload.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreateRequest {
    private List<LineOrderCreateRequest> lineOrderRequestList;
    private BigDecimal price;
    private Long tableId;
    private String token;
}
