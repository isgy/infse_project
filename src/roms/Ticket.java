/**
 * 
 */
package roms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Iterator;
import java.lang.Boolean;
/**
 * @author pbj
 *
 */
public class Ticket {
 
    private String tableID;
    public TreeMap<String, TicketItem> ticket;
    public String getTableID() { 
        return tableID; 
    }
    public Ticket(){ 
    TreeMap<String, TicketItem> ticket = new TreeMap<>();
    }
    public void addToTicket(MenuItem item){
    	String menuID = item.getmenuID();
    	if (ticket.containsKey(menuID)){
    		ticket.get(menuID).add();
    	} else {
    	ticket.put(menuID, new TicketItem(item));
    	}
    }
    public void removeFromTicket(MenuItem item){
    	String menuID = item.getmenuID();
    	if (ticket.containsKey(menuID)){
    		ticket.get(menuID).rem();
    	}
    }
    public Money getTotal(){
    	Set<Entry<String, TicketItem>> ents = ticket.entrySet();
    	Money total = new Money();
        for (Entry<String, TicketItem> tk : ents) {
      	  Money price = tk.getValue().getPrice();            //price per item
      	  int countnum = tk.getValue().getCount();           //quantity of the item in ticket
      	  Money itemtotal = price.multiply(countnum);        //total for the item
          total.add(itemtotal);                              //added to ticket total
        }
        return total;
    }
    public String showTicket(){
//      String ss = "";	
	  String ss = "\nID" + String.format("%18s", "Description") + String.format("%12s", "Count");
	  Set<Entry<String, TicketItem>> ents = ticket.entrySet();
      for (Entry<String, TicketItem> tk : ents) {
    	  String id = tk.getKey();
    	  TicketItem item = tk.getValue();
         ss += "\n" + id + ", " + String.format("%15s", item.getDescription()) + ", " +  String.format("%10s", item.getCount());
      }
      return ss;
    	 //    ss += id + " " + item.getDescription() + " " +  item.getCount();
  }
    /*public int contains(String menuID){
    	if (ticket.containsKey(menuID)){
    		return 1;
    	}
    	else return 0;
    }
  */ 
    /**
     * Format ticket as list of strings, with, per ticket item, 3 strings for 
     * respectively:
     * - MenuID
     * - Description
     * - Count
     * 
     * Items are expected to be ordered by MenuID.
     * 
     * An example list is:
     * 
     * "D1", "Wine",        "1",
     * "D2", "Soft drink",  "3",
     * "M1", "Fish",        "2",
     * "M2", "Veg chili",   "2"
     * 
     * These lists of strings are used by TableDisplay and TicketPrinter
     * to produce formatted ticket output messages.
     * 
     * @return
     */
    public List<String> toStrings() {
 
        // Dummy implementation. 
        String[] stringArray = 
            {"D1", "Wine",        "1",
             "D2", "Soft drink",  "3",
             "M1", "Fish",        "2",
             "M2", "Veg chili",   "2"
            };
        List<String> ss = new ArrayList<String>();
        ss.addAll(Arrays.asList(stringArray));
        return ss;
    }
    
    
}
