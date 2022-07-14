package com.github.yagoalmeida.productservice.controller;

import com.github.yagoalmeida.productservice.entity.Product;
import com.github.yagoalmeida.productservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    final ProductService service;

    public ProductController(ProductService productService) {
        this.service = productService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Product> save(@RequestBody final Product product) {
        return service.create(product);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Mono<Product> getProduct(@PathVariable("id") final Long id) {
        return service.getById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Flux<Product> list() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Product> deleteProduct(@PathVariable("id") final Long id) {
        return service.deleteById(id);
    }
}
