package com.github.yagoalmeida.productservice.repository;

import com.github.yagoalmeida.productservice.entity.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProductRepository extends ReactiveCrudRepository<Product, Long> {
}