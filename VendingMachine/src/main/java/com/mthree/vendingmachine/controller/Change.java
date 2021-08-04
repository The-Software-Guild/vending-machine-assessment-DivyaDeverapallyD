/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.vendingmachine.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author DivyaDeverapally
 */
public class Change {
    
   private BigDecimal quarter, remainingQuarter, dime, remainingDime,nickle, remainingNickle, penni;
   
   
   public String getChange(BigDecimal change){
       
       String rem="Divya";
      // System.out.println("Quarter ENUM "+ Coin.QUARTER.getValue());
       quarter= change.divide(Coin.QUARTER.getValue());
      // System.out.println("Division quater "+ quarter);
       remainingQuarter=change.remainder(Coin.QUARTER.getValue());
      // System.out.println("Quarters remainder "+ remainingQuarter);
       rem += getQuarter().intValue() + " quarters\n";
       
       if(remainingQuarter!=new BigDecimal(0)){
         //  System.out.println("Inside dime if"+ remainingQuarter);
           dime=remainingQuarter.divide(Coin.DIME.getValue());
       //    System.out.println("Division Dime "+ dime);
           remainingDime=remainingQuarter.remainder(Coin.DIME.getValue());
           rem += getDime().intValue() + " Dimes\n";
       }
       
       if(remainingDime != new BigDecimal(0)){
           nickle=remainingDime.divide(Coin.NICKLE.getValue());
           remainingNickle=remainingDime.remainder(Coin.NICKLE.getValue());
           rem += getNickle().intValue() + " Nickle\n";
           
       }
       if(remainingNickle != new BigDecimal(0)){
           penni=remainingNickle;
             rem += getPenni().intValue() + " Pennies\n";
       }
       
       
       
       
       
       return rem;
   }
   
   
   
   

    /**
     * @return the qarter
     */
    public BigDecimal getQuarter() {
        return quarter;
    }



    /**
     * @return the dime
     */
    public BigDecimal getDime() {
        return dime;
    }

  

    /**
     * @return the nickle
     */
    public BigDecimal getNickle() {
        return nickle;
    }

 
    /**
     * @return the penni
     */
    public BigDecimal getPenni() {
        return penni;
    }

 
    
    
    
}
