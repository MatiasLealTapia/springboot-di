package com.matias.springboot.di.app.springbootdi.services;

import java.util.List;
import java.util.stream.Collectors;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
// import org.springframework.core.env.Environment;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matias.springboot.di.app.springbootdi.models.Product;
import com.matias.springboot.di.app.springbootdi.repositories.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService {
    
    // @Autowired
    // private Environment environment;

    @Value("${config.price.tax}")
    private Double tax;

    /*
     * @Autowired usado en la primera forma es lo mismo que usarlo junto a su constructor
     */
    // @Autowired
    // @Qualifier("productList")
    private ProductRepository repository;
    
    /* 
     * Sugerencia -- Remover @Autowired no necesario --
     * @Autowired solamente necesario cuando es un metodo "SET" o "SETTER" 
     */
    // @Autowired 
    /*
     * @Qualifier("") escoge explicitamente cual es el componente que quiere implementar.
     * Se le da el nombre del componente en concreto.
     * SIEMPRE LA PRIMERA LETRA DEL COMPONENTE DEBE IR EN MINUSCULA (Dentro de @Qualifier("")).
     * En caso de que se le de un nombre dentro de @Repository al componente a implementar, se ocupa ese nombre.
     * Si no se ocupa @Qualifier(""), se implementará el componente que tenga @Primary .
     */
    public ProductServiceImpl(@Qualifier("productJson")ProductRepository repository/*, Environment environment*/) {
        this.repository = repository;
        // this.environment = environment;
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll().stream().map(p -> {
            /*
             * Implementacion Environment con .properties personalizado.
             * con la variable "tax" se llama desde una vez al value y se guarda.
             */
            // Double priceTax = p.getPrice() * environment.getProperty("config.price.tax", Double.class);
            Double priceTax = p.getPrice() * tax;
            // Product newProd = new Product(p.getId(), p.getName(), priceTax.longValue());
            // return newProd;
            Product newProd = (Product) p.clone();
            newProd.setPrice(priceTax.longValue());
            return newProd;
        }).collect(Collectors.toList());
    }

    @Override
    public Product findByiD(Long id) {
        return repository.findById(id);
    }


}
