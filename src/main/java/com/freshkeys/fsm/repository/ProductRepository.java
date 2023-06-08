package com.freshkeys.fsm.repository;

import com.freshkeys.fsm.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findByName(String Name);
}
