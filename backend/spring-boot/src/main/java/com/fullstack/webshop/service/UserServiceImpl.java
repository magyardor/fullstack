package com.fullstack.webshop.service;

/**
 *
 * @author dorcs
 */

import java.util.List;  
import javax.transaction.Transactional;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  
import com.fullstack.webshop.dao.UserRepository;  
import com.fullstack.webshop.entity.User;  
import com.fullstack.webshop.service.UserService;

/**
 *
 * @author dorcs
 */
@Service("userService")
public class UserServiceImpl implements UserService{
    @Autowired  
    private UserRepository userrepo;  
  
    @Transactional  
    public int saveUser(User user) {  
        return userrepo.saveUser(user);  
    }  
      
    @Transactional  
    public int userLogin(String usernameID, String password) {  
        return userrepo.userLogin(usernameID, password);  
    }  
  
    @Transactional  
    public List<User> getUserData() {  
        return userrepo.getUserData();  
    }  
}
