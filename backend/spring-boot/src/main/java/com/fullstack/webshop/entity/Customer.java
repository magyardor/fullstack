/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fullstack.webshop.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author nzsom
 */
@Entity
@Table(name="customer")
//@Data
@Getter
@Setter
public class Customer{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "firstName")
    private String firstName;
    
    @Column(name = "lastName")
    private String lastName;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "sCountry")
    private String sCountry;
    
    @Column(name = "sStreet")
    private String sStreet;
    
    @Column(name = "sCity")
    private String sCity;
    
    @Column(name = "sState")
    private String sState;
    
    @Column(name = "sZipCode")
    private int sZipCode;
    
    @Column(name = "bCountry")
    private String bCountry;
    
    @Column(name = "bStreet")
    private String bStreet;
    
    @Column(name = "bCity")
    private String bCity;
    
    @Column(name = "bState")
    private String bState;
    
    @Column(name = "bZipCode")
    private int bZipCode;
    
    @Column(name = "cardType")
    private String cardType;
    
    @Column(name = "nameOnCard")
    private String nameOnCard;
    
    @Column(name = "cardNumber")
    private int cardNumber;
    
    @Column(name = "securityCode")
    private int securityCode;
    
    @Column(name = "expMonth")
    private int expMonth;
    
    @Column(name = "expYear")
    private int expYear;
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "cutomertotag",
                joinColumns = { @JoinColumn(name = "customer_id")},
		inverseJoinColumns = { @JoinColumn (name = "tag_id")})
    private Set<Tag> tags = new HashSet<>();
}
