/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.vendingmachine;

import com.mthree.vendingmachine.controller.VendingMachineController;
import com.mthree.vendingmachine.dao.VendingMachineAuditDao;
import com.mthree.vendingmachine.dao.VendingMachineAuditDaoImpl;
import com.mthree.vendingmachine.dao.VendingMachineDao;
import com.mthree.vendingmachine.dao.VendingMachineDaoFileImpl;
import com.mthree.vendingmachine.service.VendingMachineServiceLayer;
import com.mthree.vendingmachine.service.VendingMachineServiceLayerImpl;
import com.mthree.vendingmachine.ui.UserIO;
import com.mthree.vendingmachine.ui.UserIOConsoleImpl;
import com.mthree.vendingmachine.ui.VendingMachineView;

/**
 *
 * @author DivyaDeverapally
 */
public class App {
    
      public static void main(String[] args) {
          UserIO myIo = new UserIOConsoleImpl();
          VendingMachineView view= new VendingMachineView();
          VendingMachineDao dao = new VendingMachineDaoFileImpl();
          VendingMachineAuditDao auditDao= new VendingMachineAuditDaoImpl();
          VendingMachineServiceLayer service = new VendingMachineServiceLayerImpl(dao,auditDao);
          
    VendingMachineController controller= new VendingMachineController(service,view);
    controller.run();
      }
}
