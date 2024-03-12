package com.matias.springboot.di.app.springbootdi.services;

import java.util.List;

import com.matias.springboot.di.app.springbootdi.models.Product;

public interface ProductService {

    List<Product> findAll();
    Product findByiD(Long id);
}
