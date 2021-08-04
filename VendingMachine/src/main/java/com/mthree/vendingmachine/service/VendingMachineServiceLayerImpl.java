/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.vendingmachine.service;

import com.mthree.vendingmachine.dao.VendingMachineAuditDao;
import com.mthree.vendingmachine.dao.VendingMachineDao;
import com.mthree.vendingmachine.dao.VendingMachineDaoFileImpl;
import com.mthree.vendingmachine.dto.Item;
import java.util.List;

/**
 *
 * @author DivyaDeverapally
 */
public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer{
    
    VendingMachineDao dao;
    VendingMachineAuditDao auditDao;

    public VendingMachineServiceLayerImpl(VendingMachineDao dao, VendingMachineAuditDao auditDao) {
      this.dao=dao;
      this.auditDao=auditDao;
    }

    @Override
    public List<Item> getAllItems() {
     return  dao.getAllItems();
    }
    @Override
       public boolean validateAmount(String itemId, double amount){
           boolean  isenoughAmount= dao.validateAmount(itemId,amount);
           return isenoughAmount;
           
       }

    @Override
    public void updateItems(String itemId) {
        dao.updateItems(itemId);
        auditDao.writeAuditEntry("Inventory updated for"+ itemId);
    }
    
    @Override
    public Item getItem(String itemId){
       return dao.getItem(itemId);
    }
}
