/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.vendingmachine.ui;

import com.mthree.vendingmachine.dto.Item;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author DivyaDeverapally
 */
public class VendingMachineView {
     UserIO io= new UserIOConsoleImpl();
   
    
    public void displayAllItems(List<Item> items){
        System.out.println("************************ITEMS***********************************");
        items.stream()
                .forEach((item)->System.out.println("*"+"\t"+item.getId()+"\t\t"+item.getName()+
                                "\t\t"+item.getCost()+"\t\t"+"\t"+"*"));
      /*  for(Item item: items){
           System.out.print("*"+"\t");
            System.out.print("*"+"\t"+item.getId()+"\t\t"+item.getName()+"\t\t"+item.getCost()+"\t\t"+"\t"+"*");
            System.out.println("\t"+"*");
        }*/
          System.out.println("****************************************************************");
        
    }

    public String displayExitOption() {
      // io.print("Do you want to exit");
       String option= io.readString("Please enter  Y if you want to exit or Press Enter to continue");
       return option;
       
    }
    
    public void displayExitBanner() {
    io.print("Good Bye!!!");
}

    public double getUserAmount() {
        
        double amount= io.readDouble("Enter Amount you want to spend");
        return amount;
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getUserEnternedItemId() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    String id= io.readString("Enter Item Id");
    return id;    }
    
    public void displayString(String msg) {
   
    io.print(msg);
}

    public void updateItems(String itemId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
