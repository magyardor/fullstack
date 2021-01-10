package com.fullstack.webshop.dao;

/**
 *
 * @author dorcs
 */

public interface TokenRepository {
    public void saveUser(String Username, int id);
    public boolean updateToken(String username, String authenticationToken, String secretKey);
    public int getToken(String Username);
    public int tokenAuthentication(String token, int usernameID);
}
