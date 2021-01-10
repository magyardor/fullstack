package com.fullstack.webshop.service;

/**
 *
 * @author dorcs
 */
public interface TokenService {
    public void saveUser(String username, int id);
    public boolean updateToken(String username, String authenticationToken, String secretKey);
    public int getToken(String username);
    public int tokenAuthentication(String token, int usernameID);
}
