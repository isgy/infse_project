package roms;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

public class Table {

    private Menu menu;
    private CardReader cr;
    private TableDisplay dsp;
    private Ticket ticket;
    private ReceiptPrinter rprint;
    private Rack rack;
    private OfficeKVM cmp;
    
    public void setM(Menu menu) {
    this.menu = menu;
    }
    public void setCr(CardReader cr) {
    this.cr = cr;
    }
    public void setTableDisplay(TableDisplay dsp) {
    this.dsp = dsp;
    }
    public void setTicket(Ticket ticket) {
    this.ticket = ticket;
    }
    public void setReceiptPrinter(ReceiptPrinter rprint) {
    	this.rprint = rprint;
    }
    public void setRack(Rack rack) {
    	this.rack = rack;
    }
    public void setCmp(OfficeKVM cmp) {
    	this.cmp = cmp;
    }
	public void showMenu(){
        String m = menu.showMenu();
        dsp.dTableMenu(m);
	}
	

	public void newTicket(){
	 ticket = new Ticket();	
	}
    /**
     * 
     */
    public void showTicket() {
        String t = ticket.showTicket();
        dsp.dTicket(t);
    }
    /**
     * @param menuID
     */
    public void addMenuItem(String menuID) {
    	MenuItem item = menu.getMenuItem(menuID);
        ticket.addToTicket(item);
    }
    /**
     * @param menuID
     */
    public void removeMenuItem(String menuID) {
    	MenuItem item = menu.getMenuItem(menuID);
        ticket.removeFromTicket(item);
    }
    public void submitOrder() {
        
    }
    public void payBill() {
       Money total = ticket.getTotal();
       dsp.displayBill(total);
       String cdetails = cr.waitForCardDetails();
       cmp.getBank().makePayment(cdetails, total);
       String auth = cmp.getBank().waitForAuthorisation();
       rprint.printReceipt(total, auth);     
    }
}
