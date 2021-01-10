package com.fullstack.webshop.controller;

/**
 *
 * @author dorcs
 */
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.http.HttpHeaders;  
import org.springframework.http.HttpStatus;  
import org.springframework.http.ResponseEntity;  
import org.springframework.web.bind.annotation.CrossOrigin;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.PostMapping;  
import org.springframework.web.bind.annotation.RequestBody;  
import org.springframework.web.bind.annotation.RequestHeader;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RestController;  
  
import com.fullstack.webshop.entity.User;
import com.fullstack.webshop.service.UserService;
import com.fullstack.webshop.service.TokenService;  
import com.fullstack.webshop.Generate.GenerateToken;  

@RestController  
@RequestMapping("/api/register")  
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", exposedHeaders = "Authorization")
public class UserController {
     @Autowired  
    private UserService userService;  
      
    @Autowired  
    private TokenService tokenService;  
      
    GenerateToken generateToken = new GenerateToken();  
      
    @PostMapping("/saveUser")  
    public int saveUser(@RequestBody User user) {  
        return userService.saveUser(user);  
    }  
      
    @PostMapping("/login")  
    public ResponseEntity<Integer> login(@RequestBody User user)  
    {  
        int status;  
        HttpHeaders httpHeader = null;  
      
        status = userService.userLogin(user.getUsernameID(), user.getPassword());  

        if (status > 0)   
        {  

            String tokenData[] = generateToken.createJWT(user.getUsernameID(), "JavaTpoint", "JWT Token", 43200000);  
               
            String token = tokenData[0];  
              
            System.out.println("Authorization :: " + token);  
  
            httpHeader = new HttpHeaders();  
  
            httpHeader.add("Authorization", token);  
  
            long isUsernameExists = tokenService.getToken(user.getUsernameID());  
              
            /* 
             * If token exist then update Token else create and insert the token. 
             */  
            if (isUsernameExists > 0)   
            {  
                tokenService.updateToken(user.getUsernameID(), token, tokenData[1]);  
            }   
            else   
            {  
                tokenService.saveUser(user.getUsernameID(), status);  
                tokenService.updateToken(user.getUsernameID(), token, tokenData[1]);  
            }  
  
            return new ResponseEntity<Integer>(status, httpHeader, HttpStatus.OK);  
        }   
          
        // if not authenticated return  status what we get.  
        else   
        {  
            return new ResponseEntity<Integer>(status, httpHeader, HttpStatus.OK);  
        }  
          
  
    }  
      
      
    @GetMapping("/getIserData/{id}")  
    public List<User> getUserData(@PathVariable int id, @RequestHeader("Authorization") String authorizationToken)  
    {  
        String token[] = authorizationToken.split(" ");  
        int result = tokenService.tokenAuthentication(token[1], id);  
          
        if (result > 0) {  
            return userService.getUserData();  
        } else {  
            return null;  
        }  
    }  
}
