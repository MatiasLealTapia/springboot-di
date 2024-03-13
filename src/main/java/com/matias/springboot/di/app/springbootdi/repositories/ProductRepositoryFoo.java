package com.matias.springboot.di.app.springbootdi.repositories;

import java.util.Collections;
import java.util.List;

// import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
// import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.matias.springboot.di.app.springbootdi.models.Product;

/*
 * @Primary se ocupa por que Spring no sabe cual interfaz ocupar.
 * Se escoge @Primary cuando hay 2 o más implementaciones de la misma interfaz.
 * La implementación que sea @Primary es la que elegirá Spring.
 * NO PUEDEN HABER 2 IMPLEMENTACIONES @Primary .
 */
// @Primary
/*
 * @RequestScope cambia el contexto del componente de Singleton (por defecto) por Request.
 * Se refiere a que por cada Request se crea y se destruye, 
 * no asi Singleton que se crea y queda en memoria de la aplicación.
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
@SessionScope
/*
 * Al repositorio se le puede dar un nombre explicito para las llamadas del @Qualifier("").
 * Si no se le agrega nada, quedará el nombre por defecto del componente.
 */
@Repository("productFoo")
// @Repository
public class ProductRepositoryFoo implements ProductRepository {

    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(1L, "Monitor Asus 27", 600L));
    }

    @Override
    public Product findById(Long id) {
        return new Product(id, "Monitor Asus 27", 600L);
    }

}
