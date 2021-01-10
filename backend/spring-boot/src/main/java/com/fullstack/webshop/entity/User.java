/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fullstack.webshop.entity;

/**
 *
 * @author dorcs
 */
import javax.persistence.*;


@Entity
@Table(name = "admin")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "admin_id")
    private int id;
    
    @Column(name = "usernameID", nullable = false, unique = true, length = 45)
    private String usernameID;
          
    @Column(name = "password", nullable = false, length = 64)
    private String password;
     
    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;
     
    @Column(name = "last_name", nullable = false, length = 20)
    private String lastName;
    
    public User(int id, String usernameID, String password, String firstName, String lastName){
        super();
        this.id = id;
        this.usernameID = usernameID;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public int getID() {  
        return id;  
    }  
  
    public void setID(int id) {  
        this.id = id;  
    } 
    
    public String getUsernameID() {  
        return usernameID;  
    }  
  
    public void setUsername(String usernameID) {  
        this.usernameID = usernameID;  
    }
    
    public String getPassword() {  
        return password;  
    }  
  
    public void setPassword(String password) {  
        this.password = password;  
    }
    
    public String getFirstName() {  
        return firstName;  
    }  
  
    public void setFirstName(String firstName) {  
        this.firstName = firstName;  
    } 
    
    public String getLastName() {  
        return lastName;  
    }  
  
    public void setLastName(String lastName) {  
        this.lastName = lastName;  
    } 
    
    @Override
    public String toString(){
        return "User [id=" + id + ", usernameID=" + usernameID + ", firstName=" + firstName + ", lastName=" + lastName +  ", password=" + password + "]";
    }
    
}
