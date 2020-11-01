/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fullstack.webshop.dao;

/**
 *
 * @author nzsom
 */
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;
import com.fullstack.webshop.entity.Product;

@CrossOrigin("http://localhost:4200")
public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findByCategoryId(@RequestParam("id") Long id, Pageable pageable);
    
    Page<Product> findByNameContaining(@RequestParam("name") String name, Pageable pageable);
    //Spring boot magic: SELECT * FROM Product WHERE p.name LIKE CONCAT('%', : NAME , '%')

}