/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fullstack.webshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.fullstack.webshop.entity.Customer;
/**
 *
 * @author nzsom
 */

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "customer", path = "customer")

public interface CustomerRepository extends JpaRepository<Customer, Long>{
    
}
