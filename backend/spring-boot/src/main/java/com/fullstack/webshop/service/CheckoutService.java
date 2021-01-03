/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fullstack.webshop.service;

/**
 *
 * @author nzsom
 */
import com.fullstack.webshop.dto.*;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
