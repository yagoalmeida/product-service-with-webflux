package com.github.yagoalmeida.productservice.service;

import com.github.yagoalmeida.productservice.entity.Product;
import com.github.yagoalmeida.productservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@Slf4j
@Transactional
public class ProductService {

    final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Mono<Product> getById(final Long id) {
        return repository.findById(id);
    }

    public Flux<Product> findAll() {
        return repository.findAll();
    }

    public Mono<Product> create(final Product product) {
        return repository.save(product);
    }

    public Mono<Product> deleteById(final Long id) {
        return repository.findById(id)
                .flatMap(existingProduct -> repository.delete(existingProduct)
                        .then(Mono.just(existingProduct)));
    }
}