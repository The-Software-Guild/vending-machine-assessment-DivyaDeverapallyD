/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.vendingmachine.controller;

import java.math.BigDecimal;

/**
 *
 * @author DivyaDeverapally
 * 
 */
public enum Coin {
    
    
    PENNY(new BigDecimal("1")), NICKLE(new BigDecimal(5)), DIME(new BigDecimal(10)), QUARTER(new BigDecimal(25));
    //COIN.QUARTER.getDenomination
    private BigDecimal value;

    private Coin(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }
}


