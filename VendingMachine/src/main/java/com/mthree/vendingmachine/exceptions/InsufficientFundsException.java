/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.vendingmachine.exceptions;

import com.mthree.vendingmachine.dao.*;

/**
 *
 * @author DivyaDeverapally
 */
public class InsufficientFundsException  extends Exception{
    
    public InsufficientFundsException(String message){
      super(message);  
    }
     public InsufficientFundsException(String message, Throwable cause){
      super(message,cause);  
    }
}