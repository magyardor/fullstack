package com.fullstack.webshop.service;

/**
 *
 * @author dorcs
 */
import java.util.List;
import com.fullstack.webshop.entity.User;

public interface UserService {
    public int saveUser(User user);
    public int userLogin(String usernameID, String password);
    public List<User>getUserData();
}
