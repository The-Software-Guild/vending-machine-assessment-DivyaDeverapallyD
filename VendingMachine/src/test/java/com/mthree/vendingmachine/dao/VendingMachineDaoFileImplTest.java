/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.vendingmachine.dao;

import com.mthree.vendingmachine.dto.Item;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
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
public class VendingMachineDaoFileImplTest {
    
    
    VendingMachineDao testDao;
    public VendingMachineDaoFileImplTest() {
    }
   
    @BeforeAll
    public static void setUpClass() {
    }
//   
    /*
    
    @AfterAll
    public static void tearDownClass() {
    }
    */
    @BeforeEach
    public void setUp() throws IOException {
        //testFile.txt
        String testFile="testFile.txt";
     
        testDao= new VendingMachineDaoFileImpl(testFile);
        testDao.getAllItems();
        
        
    }
    
    //1:Kitkat:5.0:200
///2:coke:20.0:0
    
    
    @Test
    public void testGetAllItems(){
        
        Item item1= new Item();
        item1.setId("1");
        item1.setCost(5.0);
        item1.setName("Kitkat");
        item1.setNumber_of_items(200);
        
        Item item2= new Item();
        item2.setId("2");
        item2.setCost(20.0);
        item2.setName("coke");
        item2.setNumber_of_items(0);
        
        List<Item> itemList= testDao.getAllItems();
        
        assertNotNull(itemList, "The list of items must not null");
        assertEquals(3, itemList.size(), "List of items  should have 3 items.");
        
        
         assertTrue(testDao.getAllItems().contains(item1),
                "The list of items should include Kitkat.");
        assertTrue(testDao.getAllItems().contains(item2),
                "The list of items should include Coke.");
        
        
        
        
        
        
    }
   
    
    @Test
    public void testGetItem(){
        Item item1= new Item();
        item1.setId("1");
        item1.setCost(5.0);
        item1.setName("Kitkat");
        item1.setNumber_of_items(200);
          List<Item> itemList= testDao.getAllItems();
        Item item= testDao.getItem("1");
          assertEquals(item1, item, "Both  items  should be same");
        
    }
         
    
   @Test
    public void testUpdateItem(){
        
        Item item1= new Item();
        item1.setId("3");
        item1.setCost(15.0);
        item1.setName("chips");
        item1.setNumber_of_items(6);
        
        
        testDao.updateItems(item1.getId());
        
        Item item= testDao.getItem(item1.getId());
        assertEquals(item1, item, "Both  items  should be same");
        
        
    }

    
    
    @Test    
    public void testValidateAmount(){
        
         Item item1= new Item();
        item1.setId("3");
        item1.setCost(15.0);
        item1.setName("chips");
        item1.setNumber_of_items(6);
        
        double userAmount=20;
        
        boolean result=testDao.validateAmount("3", userAmount);
        assertTrue(result);
        
        boolean result1=testDao.validateAmount("3", 10);
        
        assertFalse(result1);
        
        
        
        
        
    }
    
    
    @AfterEach
    public void tearDown() {
    }

 
    
}
