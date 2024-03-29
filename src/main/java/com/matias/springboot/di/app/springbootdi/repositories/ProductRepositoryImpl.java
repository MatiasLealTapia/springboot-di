package com.matias.springboot.di.app.springbootdi.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
// import org.springframework.web.context.annotation.RequestScope;
// import org.springframework.web.context.annotation.SessionScope;

import com.matias.springboot.di.app.springbootdi.models.Product;

/*
 * @Primary se ocupa por que Spring no sabe cual interfaz ocupar.
 * Se escoge @Primary cuando hay 2 o más implementaciones de la misma interfaz.
 * La implementación que sea @Primary es la que elegirá Spring.
 * NO PUEDEN HABER 2 IMPLEMENTACIONES @Primary .
 */
@Primary
/*
 * @RequestScope cambia el contexto del componente de Singleton (por defecto) por Request.
 * Se refiere a que por cada Request se crea y se destruye, 
 * no asi Singleton que se crea y queda en memoria del servidor.
 */
// @RequestScope
/*
 * @SessionScope cambia el contexto del componente de Singleton (por defecto) por Session.
 * Se refiere a que cuando se abra por primera vez se cree y cuando se cierre se destruya.
 * Ej.: Cuando se abre un navegador y entras se crea esta instancia, 
 * mientras sigas navegando seguira creada y modificandose,
 * cuando cierres tu navegador esta instancia se destruira, 
 * asi cuando vuelvas a abrir en tu navegador, se vuelva a crear.
 */
// @SessionScope
/*
 * Al repositorio se le puede dar un nombre explicito para las llamadas del @Qualifier("").
 * Si no se le agrega nada, quedará el nombre por defecto del componente.
 */
@Repository("productList")
// @Repository
public class ProductRepositoryImpl implements ProductRepository {

    private List<Product> data;

    public ProductRepositoryImpl() {
        this.data = Arrays.asList(
                new Product(1L, "Memoria Corsair 32", 300L),
                new Product(2L, "Cpu Intel Core i9", 850L),
                new Product(3L, "Teclado Razer Mini 60%", 180L),
                new Product(4L, "Motherboard Gigabyte", 490L));
    }

    @Override
    public List<Product> findAll() {
        return data;
    }

    @Override
    public Product findById(Long id) {
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
}
