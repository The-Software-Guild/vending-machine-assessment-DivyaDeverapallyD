/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.vendingmachine.dao;

import com.mthree.vendingmachine.dto.Item;
import java.util.List;

/**
 *
 * @author DivyaDeverapally
 */
public interface VendingMachineDao {
      List<Item> getAllItems();

    public boolean validateAmount(String itemId, double amount) ;

    public void updateItems(String itemId);
    
    public Item getItem(String itemId);
}
