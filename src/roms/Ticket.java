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
    private Money total;
    private TreeMap<String, TicketItem> ticketmap;
    
    public String getTableID() { 
        return tableID; 
    }
    
    public Ticket(String tableID){ 
    ticketmap = new TreeMap<>();
    this.tableID = tableID;
    total = new Money();
    }
    
    public void addToTicket(MenuItem item){
    	String menuID = item.getmenuID();
    	if (ticketmap.containsKey(menuID)){
    		ticketmap.get(menuID).add();
    		total.add(item.getPrice());
    	} else {
    	ticketmap.put(menuID, new TicketItem(item));
    	ticketmap.get(menuID).add();
        total.add(item.getPrice());
    	}
    }
    public void removeFromTicket(MenuItem item){
    	String menuID = item.getmenuID();
    	if (ticketmap.containsKey(menuID)){
    		if (ticketmap.get(menuID).getCount() == 1) {
    			ticketmap.remove(menuID);
    		}
    		else {
    		ticketmap.get(menuID).rem();
    		}
    	}
    }
    public Money getTotal(){
    	Money total = new Money();
        for (TicketItem t : ticketmap.values()) {
             total = total.add(t.getPrice().multiply(t.getCount())); 	
        }
        return total;
    }
 /*   public String showTicket(){
//      String ss = "";	
	  String ss = "\nID" + String.format("%18s", "Description") + String.format("%12s", "Count");
	  Set<Entry<String, TicketItem>> ents = ticketmap.entrySet();
      for (Entry<String, TicketItem> tk : ents) {
    	  String id = tk.getKey();
    	  TicketItem item = tk.getValue();
         ss += "\n" + id + ", " + String.format("%15s", item.getDescription()) + ", " +  String.format("%10s", item.getCount());
      }
      return ss;
    	 //    ss += id + " " + item.getDescription() + " " +  item.getCount();
  
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
 
      List<String> ss = new ArrayList<String>();
	   //creates menu list from the treemap
	  Set<Entry<String, TicketItem>> ents = ticketmap.entrySet();
      for (Entry<String, TicketItem> tk : ents) {                            
    	  String id = tk.getKey();                                        //for each ticketitem in ticketmap, get the ID
    	  TicketItem item = tk.getValue();                                //now get the ticketitem
          String[] stringArray ={id, item.getDescription(), String.format("%10s", item.getCount())};   //add description and right-align count
          ss.addAll(Arrays.asList(stringArray));                             //array of strings -> list -> arraylist
          }
          return ss;
    	 //    ss += id + " " + item.getDescription() + " " +  item.getPrice();
        }
    
    
}
