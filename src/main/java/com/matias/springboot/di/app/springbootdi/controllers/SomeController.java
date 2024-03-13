package com.matias.springboot.di.app.springbootdi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matias.springboot.di.app.springbootdi.models.Product;
import com.matias.springboot.di.app.springbootdi.services.ProductService;

@RestController
@RequestMapping("/api")
public class SomeController {

    /*
     * @Autowired usado en la primera forma es lo mismo que usarlo junto a su constructor
     */
    @Autowired
    private ProductService service;
    
    /* 
     * Sugerencia -- Remover @Autowired no necesario --
     * @Autowired solamente necesario cuando es un metodo "SET" o "SETTER" 
     */
    // @Autowired 
    // public SomeController(ProductService service) {
    //     this.service = service;
    // }

    @GetMapping
    public List<Product> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Product show(@PathVariable Long id) {
        return service.findByiD(id);
    }
}
