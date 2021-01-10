package com.fullstack.webshop.config;

/**
 *
 * @author dorcs
 */
import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.fullstack.webshop.config")
@PropertySource(value = {"classpath:persistence-mysql.properties"})
@PropertySource(value = {"classpath:application.properties"})
public class LoginConfig implements WebMvcConfigurer{
    @Autowired  
    private Environment env;  
    
    @Bean  
    public DataSource myDataSource() {  
          
        // create connection
        ComboPooledDataSource myDataSource = new ComboPooledDataSource();  
  
        // set driver  
        try {  
            myDataSource.setDriverClass("com.mysql.jdbc.Driver");         
        }  
        catch (Exception exc) {  
            throw new RuntimeException(exc);  
        }  
          
        // set database
        myDataSource.setJdbcId(env.getProperty("jdbc.id"));  
        myDataSource.setUser(env.getProperty("jdbc.user"));  
        myDataSource.setPassword(env.getProperty("jdbc.password"));  
        myDataSource.setPassword(env.getProperty("jdbc.firstname"));
        myDataSource.setPassword(env.getProperty("jdbc.lastname"));
          
        // set connection
        myDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));  
        myDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));  
        myDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));       
        myDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));  
  
        return myDataSource;  
    }
    
    private Properties getHibernateProperties() {  
  
        // set hibernate properties  
        Properties props = new Properties();  
        props.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));  
        props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));  
        props.setProperty("hibernate.format_sql", env.getProperty("hibernate.format_sql"));  
        props.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl"));  
        return props;                 
    }  
    
    private int getIntProperty(String propName) {  
              
            String propVal = env.getProperty(propName);  
              
            int intPropVal = Integer.parseInt(propVal);  
            return intPropVal;  
    }  
    
    @Bean  
        public LocalSessionFactoryBean sessionFactory(){  
              
            LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();  
              
            // set the properties  
            sessionFactory.setDataSource(myDataSource());  
            sessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));  
            sessionFactory.setHibernateProperties(getHibernateProperties());  
              
            return sessionFactory;  
        }  
          
        @Bean  
        @Autowired  
        public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {  
                
            HibernateTransactionManager txManager = new HibernateTransactionManager();  
            txManager.setSessionFactory(sessionFactory);  
  
            return txManager;  
        }     
    
}
