/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fullstack.webshop.dto;

import lombok.Data;
//import com.fullstack.webshop.entity.*;
import java.util.Set;
import com.fullstack.webshop.entity.Customer;
import com.fullstack.webshop.entity.Address;
import com.fullstack.webshop.entity.Order;
import com.fullstack.webshop.entity.OrderItem;

/**
 *
 * @author nzsom
 */
@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;

}
