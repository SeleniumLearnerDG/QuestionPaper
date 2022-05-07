package com.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class Pojo {
    private Long id;
    private String name;
    private LocalDate manufactured;
    private Boolean inStock;
    private Integer count;
    private List<String> categories;
    private BigDecimal unitPrice;
    private LocalDateTime lastUpdated;
}
