package com.fullstack.webshop.entity;

/**
 *
 * @author dorcs
 */
import javax.persistence.*;

@Entity
@Table(name="Token")
public class Token {
    @Id  
    @GeneratedValue(strategy=GenerationType.AUTO)  
    @Column(name="token_id")  
    private int tokenID;
    
    @Column(name="user_id" , unique=true)  
    private int userID;  
       
    @Column(name="authenticationToken")  
    private String authenticationToken;  
      
    @Column(name="secretKey")  
    private String secretKey; 
    
    @Column(name="username")
    private String username;
    
    public Token() { } 
    
    public Token(int tokenID,int userID, String authenticationToken, String secretKey, String username){
        super();  
        this.tokenID = tokenID;  
        this.userID = userID;  
        this.authenticationToken = authenticationToken;  
        this.secretKey = secretKey;  
        this.username = username;  
    }
    
     public int getTokenID() {  
        return tokenID;  
    }  
  
    public void setTokenID(int tokenID) {  
        this.tokenID = tokenID;  
    }  
  
    public int getUserID() {  
        return userID;  
    }  
  
    public void setUserID(int userID) {  
        this.userID = userID;  
    }  
  
    public String getAuthenticationToken() {  
        return authenticationToken;  
    }  
  
    public void setAuthenticationToken(String authenticationToken) {  
        this.authenticationToken = authenticationToken;  
    }  
  
    public String getSecretKey() {  
        return secretKey;  
    }  
  
    public void setSecretKey(String secretKey) {  
        this.secretKey = secretKey;  
    }  
    
    public String getUsername() {  
        return username;  
    }  
  
    public void setUsername(String username) {  
        this.username = username;  
    }
    
    @Override  
    public String toString() {  
        return "Token [tokenID=" + tokenID + ", userID=" + userID + ", authenticationToken=" + authenticationToken  
                + ", secretKey=" + secretKey + ", username=" + username + "]";  
    }  
}
