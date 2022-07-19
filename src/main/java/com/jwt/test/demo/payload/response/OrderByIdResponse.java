package com.jwt.test.demo.payload.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jwt.test.demo.domain.LineOrder;
import com.jwt.test.demo.payload.request.LineOrderCreateRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderByIdResponse {
    private Long id;
    private List<LineOrder> lineOrderList;
    private BigDecimal price;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createdDateTime;
}
