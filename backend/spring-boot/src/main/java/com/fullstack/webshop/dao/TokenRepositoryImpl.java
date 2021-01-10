package com.fullstack.webshop.dao;

/**
 *
 * @author dorcs
 */
import java.util.List;  
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.query.Query;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Repository;  
import com.fullstack.webshop.dao.TokenRepository;  
import com.fullstack.webshop.entity.Token;  

@Repository("token")
public class TokenRepositoryImpl implements TokenRepository{
    @Autowired  
    SessionFactory sessionFactory;  
  
    public void saveUser(String username, int id) {  
        Session session = null;   
        try  
        {  
            session = sessionFactory.getCurrentSession();  
            Token t = new Token();  
            t.setUserID(id);  
            t.setUsername(username);  
            session.save(t);   
        }  
        catch(Exception exception)  
        {  
            System.out.println("Exception in saving Username In Token Table :: " + exception.getMessage());  
        }  
        finally  
        {  
            session.flush();  
        }  
          
    }  
  
    public boolean updateToken(String username, String authenticationToken, String secretKey) {  
        Session session = null;  
        try   
        {  
            session = sessionFactory.getCurrentSession();  
            Query theQuery = null;        
              
            theQuery = session.createQuery("Update Token set authenticationToken = :authenticationToken , secretKey = :secretKey where usernameID =:username ");  
                  
            theQuery.setParameter("authenticationToken", authenticationToken);  
            theQuery.setParameter("username", username);  
            theQuery.setParameter("secretKey", secretKey);  
  
            int result = theQuery.executeUpdate();  
                      
            if(result == 1)  
            {  
                return true;  
            }  
            else  
            {  
                return false;  
            }  
        }  
        catch(Exception exception)  
        {  
            System.out.println("Error while updating token :: " + exception.getMessage());  
            return false;  
        }  
        finally  
        {  
            session.flush();  
        }             
    }  
  
    public int getToken(String username) {  
        Session session = null;  
        try  
        {  
            session = sessionFactory.getCurrentSession();  
            Query<Token> query = session.createQuery("from Token where usernameID =:username");  
            query.setParameter("username", username);  
              
            List<Token> tokenDetails = query.list();  
              
            if(tokenDetails.size() > 0)  
            {  
                return tokenDetails.get(0).getTokenID();  
            }  
            else  
            {  
                return 0;  
            }  
              
        }  
        catch(Exception exception)  
        {  
            System.out.println("Exception while getting token ID :: " + exception.getMessage());          
        }  
        finally  
        {  
            session.flush();  
        }  
          
        return 0;  
    }  
  
    public int tokenAuthentication(String token, int usernameID) {  
        Session session = null;  
          
        try   
        {  
            session = sessionFactory.getCurrentSession();  
              
            Query query = session.createQuery("from Token where usernameID =:usernameID and authenticationToken = :token");  
            query.setParameter("usernameID", usernameID);  
            query.setParameter("token", token);  
            List<Token> tokenDetails = query.list();  
              
            if(tokenDetails.size() > 0)  
            {  
                return tokenDetails.get(0).getTokenID();  
            }  
            else  
            {  
                return 0;  
            }  
  
        }  
        catch(Exception exception)  
        {  
            System.out.println("Exception while Authenticating token :: "+ exception);  
            return 0;  
        }  
        finally  
        {  
            session.flush();  
        }  
          
          
    }  

}
