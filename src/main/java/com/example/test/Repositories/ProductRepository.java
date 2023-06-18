package com.example.test.Repositories;

import com.example.test.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select * from product where name = ?1", nativeQuery = true)
    Optional<Product> findByName(String name);
//    @Query(value = "select * from product where product.")
//    Optional<List<Product>> getBasket(Long id)
}
