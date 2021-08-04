/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.vendingmachine.service;

import com.mthree.vendingmachine.dao.VendingMachineAuditDao;
import com.mthree.vendingmachine.dao.VendingMachineAuditDaoImpl;
import com.mthree.vendingmachine.dao.VendingMachineDao;
import com.mthree.vendingmachine.dao.VendingMachineDaoFileImpl;
import com.mthree.vendingmachine.dto.Item;
import com.mthree.vendingmachine.exceptions.InsufficientFundsException;
import com.mthree.vendingmachine.exceptions.NoItemInventoryException;
import javax.activity.InvalidActivityException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author DivyaDeverapally
 */
public class VendingMachineServiceLayerImplTest {
    
    VendingMachineServiceLayer service;
    public VendingMachineServiceLayerImplTest() {
        VendingMachineDao dao= new VendingMachineDaoStubImpl();
        VendingMachineAuditDao auditDao= new VendingMachineAuditDaoStubImpl();
        service= new VendingMachineServiceLayerImpl(dao, auditDao);
    }
    
    
    
    
    @Test
    public void testGetAllItems(){
       Item item= new Item();
        item.setId("1");
        item.setCost(5.0);
        item.setName("Kitkat");
        item.setNumber_of_items(200);
        
        assertEquals(1, service.getAllItems().size(),"Shuld have only one Item");
        assertTrue(service.getAllItems().contains(item),"The should be Kitkat");
        
        
    }
    
    
    @Test 
    public void testGetItem(){
        Item item= new Item();
        item.setId("1");
        item.setCost(5.0);
        item.setName("Kitkat");
        item.setNumber_of_items(200);
        Item item1= new Item();
        item1.setId("2");
        
        Item newItem= service.getItem("1");
        
        assertEquals(newItem,item,"Bothe items should be same");
        assertNotNull(newItem, "Getting 1 should be not null.");
        assertNull(service.getItem(item1.getId()), "Getting 02 should be  null.");
    }
    
    
    @Test
    public void testValidateAmount()throws Exception{
        String itemId="1";
        double userAmount=10;
        assertTrue(service.validateAmount(itemId, userAmount),"Should return true");
        assertFalse(service.validateAmount(itemId, 1));
        
        
    }
    
    
      
   /* 
    @Test
    public void testUpdateItem(){
       
        Item item= new Item();
        item.setId("1");
        item.setCost(5.0);
        item.setName("Kitkat");
        item.setNumber_of_items(199);
        
       service.updateItems("1");
      
        Item item1= service.getItem("1");
      assertEquals(item1,item,"Both should be equal");
        
        
    }
    */
    
    
    
    
    
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

   
    
}
