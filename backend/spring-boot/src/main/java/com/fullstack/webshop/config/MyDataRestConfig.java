/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fullstack.webshop.config;

/**
 *
 * @author nzsom
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import com.fullstack.webshop.entity.Product;
import com.fullstack.webshop.entity.ProductCategory;
import com.fullstack.webshop.entity.Country;
import com.fullstack.webshop.entity.State;


/**
 *
 * @author nzsom
 */
@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer{
    
    private EntityManager entityManager;
    
    @Autowired
    public MyDataRestConfig(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }
    
    
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config){
        HttpMethod[] theUnsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};
       
            
        disableHttpMethods(Product.class, config, theUnsupportedActions);
        disableHttpMethods(ProductCategory.class, config, theUnsupportedActions);
        disableHttpMethods(Country.class, config, theUnsupportedActions);
        disableHttpMethods(State.class, config, theUnsupportedActions);
    
        exposeIds(config);
    }

    private void disableHttpMethods(Class theClass, RepositoryRestConfiguration config, HttpMethod[] theUnsupportedActions) {
        config.getExposureConfiguration().forDomainType(theClass).withItemExposure((metdate, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure((metdate, httpMethods) -> httpMethods.disable(theUnsupportedActions));
    }

    private void exposeIds(RepositoryRestConfiguration config) {
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();
        
        
        List<Class> entityClasses = new ArrayList<>();
        
        for(EntityType tempEntityType : entities){
            entityClasses.add(tempEntityType.getJavaType());
        }
        
        Class[] domainTypes = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);
              
    }
    
}