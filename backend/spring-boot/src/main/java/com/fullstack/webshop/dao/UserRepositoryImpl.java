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
import com.fullstack.webshop.dao.UserRepository;  
import com.fullstack.webshop.entity.User;  

@Repository("userrepo")
public class UserRepositoryImpl implements UserRepository{  
    @Autowired  
    private SessionFactory sessionFactory;  
          
    /* 
     * Register User Details.  
    */  
    public int saveUser(User user) {  
          
        Session session = null;  
        try  
        {  
            session = sessionFactory.getCurrentSession();  
              
            int id = (Integer) session.save(user);  
            return id;  
        }  
        catch(Exception exception)  
        {  
            System.out.println("Excecption while saving admin Details : " + exception.getMessage());  
            return 0;  
        }  
        finally  
        {  
            session.flush();  
        }  
    }  
  
    public int userLogin(String usernameID, String password) {  
          
        Session session = null;  
        try  
        {  
            session = sessionFactory.getCurrentSession();  
              
            Query query = session.createQuery("from userDetail where username=:username and password=:password");  
            query.setParameter("usernameID", usernameID);  
            query.setParameter("password", password);  
            List<User> list = query.list();  
              
            int size = list.size();  
            if(size == 1)  
            {  
                return list.get(0).getID(); 
            }  
            else  
            {  
                return -1;  
            }  
        }  
        catch(Exception exception)  
        {  
            System.out.println("Excecption while saving user details : " + exception.getMessage());  
            return 0;  
        }  
        finally  
        {  
            session.flush();  
        }  
          
    }  
  
      
    public List<User> getUserData() {  
        Session session = null;  
        try  
        {  
            session = sessionFactory.getCurrentSession();  
              
            Query<User> query = session.createQuery("from userDetail");  
            List<User> list = query.list();  
              
            if(list.size() > 0)  
            {  
                return list;  
            }  
            else  
            {  
                return null;  
            }  
              
        }  
        catch(Exception exception)  
        {  
            System.out.println("Excecption while saving admin Details : " + exception.getMessage());  
            return null;  
        }  
        finally  
        {  
            session.flush();  
        }  
          
    }   

}
