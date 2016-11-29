/**
 * 
 */
package roms;

import java.util.ArrayList;
import java.util.List;
import java.lang.String;
import org.junit.Test;

/**
 * @author pbj
 *
 */
public class SystemTest extends TestBasis {   

    /*
     ***********************************************************************
     * BEGIN MODIFICATION AREA
     ***********************************************************************
     * Add all your JUnit tests for your system below.
     */
    
     
    @Test 
    public void cancelReadyUpLight() {
        logger.info(makeBanner("cancelReadyUpLight"));
        input("1 18:00, PassButton, pb, press");
        expect("1 18:00, PassLight, pl, viewSwitchedOff");
        
        runAndCheck();
    } 
     
     @Test
    public void addshowMenu() {
    	logger.info(makeBanner("addshowMenu"));
     	input("1 12:00, OfficeKVM, okvm, addToMenu, M1, Fish, 7.95");
     	input("1 12:00, OfficeKVM, okvm, showMenu");
     	input("1 12:00, OfficeKVM, okvm, addToMenu, M2, Veg Chili, 6.70");
     	input("1 12:00, OfficeKVM, okvm, addToMenu, D1, Soft Drink, 1.50");
     	input("1 12:00, OfficeKVM, okvm, addToMenu, D2, Wine, 3.25");  	
        input("1 12:00, OfficeKVM, okvm, removeFromMenu, M2");	
     	input("1 12:00, OfficeKVM, okvm, showMenu");
        expect("1 12:00, OfficeKVM, okvm, viewMenu, tuples, 3");
   //  	expect("ID, Description,      Price,");
    // 	expect("D1,  Soft Drink,       1.50,");
    // 	expect("D2,        Wine,       3.25");
    // 	expect("M1,        Fish,       7.95;");
     	
 //    	String expected = "1 12:00, OfficeKVM, okvm, viewMenu, tuples, 3"
//                        + '\n' + 
 //    			        "ID" + String.format("%18s", "Description") + String.format("%12s", "Price")
 //                       + "\nD1" + String.format("%18s", "Soft Drink,") + String.format("%12s", "1.50")
 //                       + "\nD2" + String.format("%18s", "Wine,") + String.format("%12s", "3.25")
 //                       + "\nM1" + String.format("%18s", "Fish,") + String.format("%12s", "7.95");
 //                         
 //   	expect(expected);
    	runAndCheck(); 
 }
 
    
    @Test
    public void addshowTicket() {
    	logger.info(makeBanner("addshowTicket"));
        input("1 12:00, OfficeKVM, okvm, addToMenu, M1, Fish, 7.95");
        input("1 12:00, OfficeKVM, okvm, addToMenu, M2, Veg Chili, 6.70");
        input("1 12:00, OfficeKVM, okvm, addToMenu, D1, Soft Drink, 1.50");
        input("1 12:00, OfficeKVM, okvm, addToMenu, D2, Wine, 3.25");
        input("1 20:00, TableDisplay, td1, startOrder");
    	input("1 20:01, TableDisplay, td1, addMenuItem, M1");
        input("1 20:01, TableDisplay, td1, addMenuItem, M2");
    	input("1 20:01, TableDisplay, td1, addMenuItem, M1");
    	input("1 20:01, TableDisplay, td1, addMenuItem, D1");
    	input("1 20:01, TableDisplay, td1, showTicket");
   
    	expect("1 20:01, TableDisplay, td1, viewTicket,"
     	+ '\n'
        + "ID, Description, Count" 
		+ "\nD1,  Soft Drink,     1" 
		+ "\nM1,        Fish,     2" 
		+ "\nM2,   Veg Chili,     1");
    	runAndCheck();
 }
 
     @Test
    public void addTicketPayBill() {                                          //the same test provided in Data
    	logger.info(makeBanner("addTicketPayBill"));
    	input("1 12:00, OfficeKVM, okvm, addToMenu, M1, Fish, 7.95");
        input("1 12:00, OfficeKVM, okvm, addToMenu, M2, Veg Chili, 6.70");
        input("1 12:00, OfficeKVM, okvm, addToMenu, D1, Soft Drink, 1.50");
        input("1 12:00, OfficeKVM, okvm, addToMenu, D2, Wine, 3.25");
        input("1 20:00, TableDisplay, td1, startOrder");
        input("1 20:01, TableDisplay, td1, addMenuItem, M1");
        input("1 20:01, TableDisplay, td1, addMenuItem, M2");
        input("1 20:01, TableDisplay, td1, addMenuItem, M1");
        input("1 20:01, TableDisplay, td1, addMenuItem, D1");
        input("1 20:02, TableDisplay, td1, submitOrder");
        input("1 21:30, TableDisplay, td1, payBill");
        input("1 21:32, CardReader, cr1, acceptCardDetails, XYZ1234");
        input("1 21:33, BankClient, bc, acceptAuthorisationCode, ABCD");
   
<<<<<<< HEAD
    	expect("1 21:30, TableDisplay, td1, approveBill, Total:, 24.10");
        expect("1 21:32, BankClient, bc, makePayment, XYZ1234, 24.10");
        expect("1 21:33, ReceiptPrinter, rp1, takeReceipt, Total:, 24.10, AuthCode:, ABCD");
        runAndCheck();
 }
    @Test 
    public void addRemoveTicketPayBill() {
        logger.info(makeBanner("addRemoveTicketPayBill"));
        input("1 09:00, OfficeKVM, okvm, addToMenu, D4, Salad, 2.65");
        input("1 09:00, OfficeKVM, okvm, addToMenu, a3, Cheese, 4.25");
        input("1 09:30, OfficeKVM, okvm, addToMenu, B3, Chicken, 5.05");
        input("1 10:50, OfficeKVM, okvm, addToMenu, M1, Fish, 7.95");
        input("1 12:00, OfficeKVM, okvm, addToMenu, M2, Veg Chili, 6.70");
        input("1 12:00, OfficeKVM, okvm, addToMenu, D1, Soft Drink, 1.50");
        input("1 12:00, OfficeKVM, okvm, addToMenu, D2, Wine, 3.25");
    	input("1 19:00, TableDisplay, td1, startOrder");
    	input("1 19:30, TableDisplay, td1, showMenu");
    	input("1 20:00, TableDisplay, td1, showTicket");
        input("1 20:01, TableDisplay, td1, addMenuItem, B3");
        input("1 20:01, TableDisplay, td1, addMenuItem, M2");
        input("1 20:01, TableDisplay, td1, addMenuItem, M1");
        input("1 21:01, TableDisplay, td1, addMenuItem, M1");
        input("1 21:05, TableDisplay, td1, addMenuItem, M1");
        input("1 20:01, TableDisplay, td1, addMenuItem, a3");
        input("1 20:01, TableDisplay, td1, addMenuItem, D1");
        input("1 20:01, TableDisplay, td1, addMenuItem, D4");
        input("1 21:01, TableDisplay, td1, removeMenuItem, D1");
        input("1 23:00, TableDisplay, td1, showTicket");

      //  input("1 20:02, TableDisplay, td1, submitOrder");
        expect("1 19:30, TableDisplay, td1, viewMenu, tuples, 3,"
               + "\n    ID, Description,      Price,\n"
               + "\n    B3,     Chicken,       5.05,"
               + "\n    D1,  Soft Drink,       1.50,"
               + "\n    D2,        Wine,       3.25,"
               + "\n    D4,       Salad,       2.65,"
               + "\n    M1,        Fish,       7.95,"
               + "\n    M2,   Veg Chili,       6.70,"
               + "a3,      Cheese,       4.25");
        expect("1 20:00, TableDisplay, td1, viewTicket, tuples, 3,"
               + "\n    ID, Description,        Count");
        expect("1 23:00, TableDisplay, td1, viewTicket, tuples, 3,"
               + "\n    ID, Description,       Count,"
               + "\n    B3,     Chicken,          1, "
               + "\n    D4,       Salad,          1,"
               + "\n    M1,        Fish,          3,"
               + "\n    M2,   Veg Chili,          1,"
               + "\n    a3,      Cheese,          1");        
        runAndCheck();
=======
    	expect("1 21:30, TableDisplay, td1, approveBill, Total:, 24.10;"
        + '\n'
        + "1 21:32, BankClient, bc, makePayment, XYZ1234, 24.10;"
        + "\n1 21:33, ReceiptPrinter, rp1, takeReceipt, Total:, 24.10, AuthCode:, ABCD");
    	runAndCheck();
>>>>>>> refs/remotes/origin/master
 }
   
    /*   	input("1 12:00, OfficeKVM, okvm, addToMenu, M2, Veg Chili, 6.70;");
    	input("1 12:00, OfficeKVM, okvm, addToMenu, D1, Soft Drink, 1.50;");
    	input("1 12:00, OfficeKVM, okvm, addToMenu, D2, Wine, 3.25;");
    	input("1 19:15, OfficeKVM, okvm, showMenu");
    	expect("1 19:15, OfficeKVM, okvm, viewMenu, tuples, 3, ID, Description, Price,"); 
        runAndCheck(); 
    }
    */   
 
   /*
    * Put all your JUnit system-level tests above.
    ***********************************************************************
    * END MODIFICATION AREA
    ***********************************************************************
    */

    
    
   /**
    * Set up system to be tested and connect interface devices to 
    * event distributor and collector. 
    * 
    * Setup is divided into two parts:
    * 
    * 1. Where IO device objects are created and connected to event
    *    distributor and event collector.
    *    
    * 2. Where core system implementation objects are created and 
    *    links are added between all the implementation objects and
    *    the IO device objects.
    *    
    * The first part configures sufficient IO device objects for all 3
    * implementation phases defined in the Coursework 3 handout.  It should 
    * not be touched. 
    * 
    * The second part here only gives the configuration for the demonstration
    * design.  It has to be modified for the system implementation.
    *   
    * 
    */
    @Override
    protected void setupSystem() {

        /* 
         * PART 1: 
         * - IO Device creation.  
         * - Establishing links between IO device objects and test framework objects.
         */
        
        
        /*
         * IO DEVICES FOR KITCHEN AREA
         * ;
         * Create IO objects for kitchen.
         * Connect them to the event distributor and event collector.
         */
        
        KitchenDisplay display = new KitchenDisplay("kd");
        display.addDistributorLinks(distributor);
        display.setCollector(collector);
        
        Clock.initialiseInstance();
        Clock.getInstance().addDistributorLinks(distributor);
                
        TicketPrinter printer = new TicketPrinter("tp");
        printer.setCollector(collector);
      
        /* 
         * IO DEVICES FOR PASS
         */

        /*
         * Create IO objects for PASS
         * Connect them to the event distributor and event collector.
         */

        PassLight light = new PassLight("pl");
        light.setCollector(collector);
        
        PassButton button = new PassButton("pb");
        button.addDistributorLinks(distributor);
        
        
        // IO DEVICES FOR OFFICE
        
        // Create IO objects for office.
        // Connect them to the event distributor and event collector.
        
        OfficeKVM officeKVM = new OfficeKVM("okvm");
        officeKVM.addDistributorLinks(distributor);
        officeKVM.setCollector(collector);
        
        BankClient bankClient = new BankClient("bc");
        bankClient.addDistributorLinks(distributor);
        bankClient.setCollector(collector);
        
                
        // IO DEVICE FOR TABLES
        
        final int NUM_TABLES = 2;
        
        List<TableDisplay> tableDisplays = new ArrayList<TableDisplay>();
        List<ReceiptPrinter> receiptPrinters = new ArrayList<ReceiptPrinter>();
        List<CardReader> cardReaders = new ArrayList<CardReader>();
        
        for (int i = 1; i <= NUM_TABLES; i++) {
            
            String iString = Integer.toString(i);
            
            // Create IO objects for a table.
            // Connect to event distributor and collector
            
            TableDisplay tableDisplay = 
                    new TableDisplay("td" + iString);
            tableDisplay.addDistributorLinks(distributor);
            tableDisplay.setCollector(collector);
            tableDisplays.add(tableDisplay);
            
            
            ReceiptPrinter receiptPrinter = 
                    new ReceiptPrinter("rp" + iString);
            receiptPrinter.setCollector(collector);
            receiptPrinters.add(receiptPrinter);
            
            CardReader cardReader = 
                    new CardReader("cr" + iString);
            cardReader.addDistributorLinks(distributor);
            cardReaders.add(cardReader);
            
           
        }
        
        /* 
         * PART 2: 
         * - Implementation object creation. 
         * - Establishing links between different implementation 
         *   objects and IO Device objects and implementation objects.
         */

        /*
         ******************************************************************
         * BEGIN MODIFICATION AREA
         ******************************************************************
         * Put below code for creating implementation objects
         * and connecting them to the interface device objects.
         */

        // SYSTEM CORE
        // Create systemCore object and links between it and IO devices.
        
        SystemCore systemCore = new SystemCore();
       
        button.setSystemCore(systemCore);
        systemCore.setPassLight(light);
               
        Menu menu = new Menu();
        menu.setO(officeKVM);
        officeKVM.setMenu(menu);
        officeKVM.setBank(bankClient);
                
        List<Table> tables = new ArrayList<Table>();
        // TABLE-RELATED
        for (int i = 1; i <= NUM_TABLES; i++) {
            
            String iString = Integer.toString(i);

            // This tableID is for later printing on tickets at the pass, in 
            // order to show which table is to receive the order.
            // Go look at the ReceiptPrinter class.
            
            // DO NOT CHANGE this scheme for naming table IDs.
            
            String tableID = "Tab-" + iString;
            
            Table table = new Table(tableID);
            table.setCmp(officeKVM);
            table.setCr(cardReaders.get(i - 1));
            table.setM(menu);
            table.setReceiptPrinter(receiptPrinters.get(i - 1));
            table.setTableDisplay(tableDisplays.get(i - 1));
            tableDisplays.get(i - 1).setT(table);
            
            tables.add(table);
            
            // Create table-related core objects.
            // Connect these objects to table-related IO objects and to other system 
            // components.
            
                        
         }

        // GENERAL
        // Create implementation objects that link to more than one area
        // and add links between implementation objects and interface device
        // objects in different areas.
        
        
        /*
         * Put above code for creating implementation objects
         * and connecting them to the interface device objects.
         ******************************************************************
         * END MODIFICATION AREA
         ******************************************************************
         */

        
    }
    
    
   
    
}
