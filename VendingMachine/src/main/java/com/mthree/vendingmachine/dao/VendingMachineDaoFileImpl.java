/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.vendingmachine.dao;

import com.mthree.vendingmachine.dto.Item;
import com.mthree.vendingmachine.exceptions.InsufficientFundsException;
import com.mthree.vendingmachine.exceptions.NoItemInventoryException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DivyaDeverapally
 */
public class VendingMachineDaoFileImpl implements VendingMachineDao {

    public  final String ITEMS_FILE ;
    private Map<String, Item> itemsMap = new HashMap<>();
VendingMachineAuditDao auditDao= new VendingMachineAuditDaoImpl();


public VendingMachineDaoFileImpl(){
    ITEMS_FILE="items.txt";
}
public VendingMachineDaoFileImpl(String testFile){
     ITEMS_FILE=testFile;
}




    @Override
    public List<Item> getAllItems() {
        loadItems();
        return new ArrayList<Item>(itemsMap.values());
    }
    
    @Override
    public Item getItem(String itemId){
        return itemsMap.get(itemId);
        
    }
    
    

    public void loadItems() {

        Scanner scanner = null;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(ITEMS_FILE)));
        } catch (FileNotFoundException e) {
            e.getMessage();
            auditDao.writeAuditEntry(e.getMessage());
        }

        String currentLine;
        Item currentItem;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentItem = unmarshallItem(currentLine);
            itemsMap.put(currentItem.getId(), currentItem);

        }

    }

    private Item unmarshallItem(String itemStr) {
        Item item = new Item();
        String[] itemTokens = itemStr.split(":");
        item.setId(itemTokens[0]);
        item.setName(itemTokens[1]);
        item.setCost(Double.parseDouble(itemTokens[2]));
        item.setNumber_of_items(Integer.parseInt(itemTokens[3]));

        return item;
    }

    @Override
    public boolean validateAmount(String itemId, double amount) {
        try{
            for(Map.Entry<String,Item> entry:itemsMap.entrySet()){
        if(entry.getKey().equals(itemId)){
              if(entry.getValue().getNumber_of_items() ==0)
            {
                throw new NoItemInventoryException("Cannot be processed as No items left in the inventory");
            }
            if(entry.getValue().getCost() <= amount){
                return true;
            }
            else{
                throw new InsufficientFundsException("Item cannot be processes.Invalid amount.");
            }
          
        }
        }
        }
        catch(InsufficientFundsException | NoItemInventoryException e){
        //    e.getStackTrace();
            System.out.println(e);
            auditDao.writeAuditEntry(e.toString());
        }
        /*    for(Map.Entry<String,Item> entry:itemsMap.entrySet()){
        if(entry.getKey().equals(itemId)){
        if(entry.getValue().getCost() < amount){
        return true;
        }
        }
        }//
         */ 
    /*    for(Map.Entry<String,Item> entry:itemsMap.entrySet()){
        if(entry.getKey().equals(itemId)){
            if(entry.getValue().getCost() < amount){
                return true;
            }
        }
    }//
        */
       
  return false;
    }
        
    

    @Override
    public void updateItems(String itemId) {
         for(Map.Entry<String,Item> entry:itemsMap.entrySet()){
         if(entry.getKey().equals(itemId)){
            Item item= entry.getValue();
            item.setNumber_of_items(item.getNumber_of_items()-1);
            itemsMap.put(itemId, item);
            break;
         }
         
         }
       updateItemsFile();
    }

    private void updateItemsFile() {
        PrintWriter out = null;

        try {
            out = new PrintWriter(new FileWriter(ITEMS_FILE));
        } catch (IOException e) {

        }
        String itemAsText;
        for (Map.Entry<String, Item> entry : itemsMap.entrySet()) {

           
            Item currentItem = entry.getValue();
         //   System.out.println("current item---------------"+ currentItem);
            itemAsText = marshallStudent(currentItem);
         //     System.out.println("Item as text item---------------"+ itemAsText);
           
            out.println(itemAsText);
         
            out.flush();
        }
        auditDao.writeAuditEntry("Inventory upated with updated items Details");
        out.close();
       }

    // Clean up
   

    private String marshallStudent(Item currentItem) {
        //1:candy:10.5:200
        
        String itemAsText=currentItem.getId()+":"+currentItem.getName()+":"+currentItem.getCost()+":"+currentItem.getNumber_of_items();
        auditDao.writeAuditEntry("Item object is unmarshalled:  "+itemAsText);
        return itemAsText;
    }

}
