/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.vendingmachine.service;

import com.mthree.vendingmachine.dao.VendingMachineDao;
import com.mthree.vendingmachine.dto.Item;
import com.mthree.vendingmachine.exceptions.InsufficientFundsException;
import com.mthree.vendingmachine.exceptions.NoItemInventoryException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DivyaDeverapally
 */
public class VendingMachineDaoStubImpl implements VendingMachineDao{
    
    
    
    private Item item;
    
    public VendingMachineDaoStubImpl(){
        item= new Item();
        item.setId("1");
        item.setCost(5.0);
        item.setName("Kitkat");
        item.setNumber_of_items(200);
    }
    
    public VendingMachineDaoStubImpl(Item testItem){
        this.item=testItem;
    }

    @Override
    public List<Item> getAllItems() {
        List<Item> itemList= new ArrayList<>();
        itemList.add(item);
        return itemList;
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean validateAmount(String itemId, double amount) {
        
        try{
            if(item.getNumber_of_items()==0)
            {
                throw new NoItemInventoryException("No Items in the inventory");
            }
             if(item.getCost() <= amount)
            return true;
        else
             throw new  InsufficientFundsException("Insuffieient Funds");
        }
        catch(InsufficientFundsException | NoItemInventoryException e){
            
        }
        if(item.getCost() <= amount)
            return true;
        else
            return false;
      
    }

    @Override
    public void updateItems(String itemId) {
        item.setNumber_of_items(item.getNumber_of_items()-1);
      
    }

    @Override
    public Item getItem(String itemId) {
        
        if(item.getId().equals(itemId))
            return item;
        else
            return null;
       
    }
    
}
