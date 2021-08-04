/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.vendingmachine.controller;

import com.mthree.vendingmachine.dto.Item;
import com.mthree.vendingmachine.exceptions.InsufficientFundsException;
import com.mthree.vendingmachine.service.VendingMachineServiceLayer;
import com.mthree.vendingmachine.service.VendingMachineServiceLayerImpl;
import com.mthree.vendingmachine.ui.VendingMachineView;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

/**
 *
 * @author DivyaDeverapally
 */
public class VendingMachineController {
    VendingMachineView view;
    VendingMachineServiceLayer service;

    public VendingMachineController(VendingMachineServiceLayer service, VendingMachineView view) {
        this.service=service;
        this.view=view;
    }
   
    public void run(){
       // System.out.println("In controller Run Method");
        displayItems();
        displayExitOption();
        requestUserInput();
               //diaplay all items
        //want to exit?
        
    }
    
    void displayItems(){
        //serice call to get all items and then pass to view to display
        
        List<Item> items=service.getAllItems();
        view.displayAllItems(items);
        
    }

    private void displayExitOption() {
       String option=view.displayExitOption();
       if(option.equalsIgnoreCase("y")){
           view.displayExitBanner();
        System.exit(0);
       }
      
       
    }

    private void requestUserInput() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   double amount;
           amount= view.getUserAmount();
    String itemId = view.getUserEnternedItemId();
  boolean isEnoughAmount= service.validateAmount(itemId, amount);
  //
  /*
  try
  {
      if(!isEnoughAmount){
          throw new InsufficientFundsException("Insuffieint funds Mad Divya");
      }
      else{
          
      System.out.println("You entered suffient amount");
     
      
      service.updateItems(itemId);
        displayChange(itemId,amount);
          
      }
  }
  catch(InsufficientFundsException e){
      System.out.println( e.getMessage());
      requestUserInput();
    //  throw new InsufficientFundsException("Insufficinet expcetion");
      
  }
  */
  
  
  
  //
 
  if(!isEnoughAmount)
  {
     
  //   view.displayInSufficientAmountMessage("Insufficient Funds ");
      requestUserInput();
     
  }
  else{
      
    
    //  System.out.println("You entered suffient amount");
     
      
      service.updateItems(itemId);
        displayChange(itemId,amount);
      //update inverntory(itemid)//this updates otems list ad save to file
  }
   
    
    }

    private void displayChange(String itemId, double amount) {
        
        Item item= service.getItem(itemId);
         Change change= new Change();
        double itemCost= item.getCost();
        double remAmount= amount- itemCost;
        BigDecimal bc= new BigDecimal(String.valueOf(remAmount));
        String remainingChange= change.getChange(bc.multiply(new BigDecimal(100)));
        view.displayString("Item is processed and Please collect the remaining Change");
        view.displayString("**********************************************************");
        view.displayString("Quarters : "+change.getQuarter().intValue()+"\t"+"Dimes : "+ 
                 change.getDime().intValue()+ "\t"+"Nickles : "+
                 change.getNickle().intValue()+"\t"+"Pennis : "+
                 change.getPenni().intValue());
        run();
      /*   System.out.println("Quarters : "+change.getQuarter().intValue()+"\t"+"Dimes : "+ 
                 change.getDime().intValue()+ "\t"+"Nickles : "+
                 change.getNickle().intValue()+"\t"+"Pennis : "+
                 change.getPenni().intValue());*/
        //System.out.println("Quarters : "+change.getQuarter().setScale(0, BigDecimal.ROUND_HALF_UP)+"\t"+"Dimes : "+ change.getDime().setScale(0, BigDecimal.ROUND_HALF_UP)+ "\t"+"Nickles : "+ change.getNickle().setScale(0, BigDecimal.ROUND_HALF_UP)+"\t"+"Pennis : "+change.getPenni().setScale(0, BigDecimal.ROUND_HALF_UP));
    }

   
    
}
