/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fullstack.webshop.dao;

/**
 *
 * @author dorcs
 */
import java.util.List;
import com.fullstack.webshop.entity.User;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin("http://localhost:4200")
public interface UserRepository{
    public int saveUser(User user);
    
    public int userLogin(String username, String password);
    
    public List<User> getUserData();
}
