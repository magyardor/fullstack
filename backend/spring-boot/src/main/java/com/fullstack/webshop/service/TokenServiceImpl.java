package com.fullstack.webshop.service;

/**
 *
 * @author dorcs
 */
import javax.transaction.Transactional;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  
import com.fullstack.webshop.dao.TokenRepository;  
import com.fullstack.webshop.service.TokenService;  

@Service("tokenService")
public class TokenServiceImpl implements TokenService{
    @Autowired  
    private TokenRepository tokenrepo;  
      
    @Transactional  
    public void saveUser(String username, int id) {  
        tokenrepo.saveUser(username, id);  
    }  
  
    @Transactional  
    public boolean updateToken(String username, String authenticationToken, String secretKey) {  
        return tokenrepo.updateToken(username, authenticationToken, secretKey);  
    }  
  
    @Transactional  
    public int getToken(String username) {  
        return tokenrepo.getToken(username);  
    }  
  
    @Transactional  
    public int tokenAuthentication(String token, int usernameID) {  
        return tokenrepo.tokenAuthentication(token, usernameID);  
    }  
}
