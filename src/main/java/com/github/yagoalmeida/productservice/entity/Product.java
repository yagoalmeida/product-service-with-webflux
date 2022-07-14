package com.github.yagoalmeida.productservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("product")
public class Product {
    @Id
    private Long id;
    private String name;
    private BigDecimal price;

}
