package com.jwt.test.demo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jwt.test.demo.config.audit.AuditorConfig;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order_tb")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EntityListeners(AuditingEntityListener.class)
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdDateTime;


}
