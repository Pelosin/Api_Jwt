package com.jwt.test.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "order_tb")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Column(nullable = false)
    private List<LineOrder> lineOrderList;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    private OrderStatus status;
    @OneToOne
    private TbTable tableToServe;
}
