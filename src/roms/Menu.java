/**
 * 
 */
package roms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
/**
 * @author pbj
 *
 */
public class Menu {
	
	private OfficeKVM ofkvm;
	
    public TreeMap<String, MenuItem> menuitems;   //for natural/lexicographic ordering of menuIDs
    /**
     * @param o
     */
    public void setO(OfficeKVM o){
    	ofkvm = o;                          
    }
    
    public void showMenu() {
   // 	String m = showMenu();
    	ofkvm.displayMenu(this);
    }
    
    /**
     * Format menu as list of strings, 3 strings per item for 
     * respectively:
     * - MenuID
     * - Description
     * - Price
     * 
     * Items are expected to be ordered by MenuID.
     * per menu item. Description and price are right-aligned.  
     * An example list is:
     * 
     * "D1", "Wine",        "2.50",
     * "D2", "Soft drink",  "1.50",
     * "M1", "Fish",        "7.95",
     * "M2", "Veg chili",   "6.70"
     * 
     * These lists of strings are used by TableDisplay and TicketPrinter
     * to produce formatted ticket output messages.
     * 
     * @return
     */  
    
  /*  public String showMenu(){
//      String ss = "";	
	  String ss = "\nID" + String.format("%18s", "Description") + String.format("%12s", "Price");         //creates menu list from the treemap
	  Set<Entry<String, MenuItem>> ents = menuitems.entrySet();
      for (Entry<String, MenuItem> menuitems : ents) {
    	  String id = menuitems.getKey();
    	  MenuItem item = menuitems.getValue();
         ss += "\n" + id + ", " + String.format("%15s", item.getDescription()) + ", " +  String.format("%10s", item.getPrice());
    	 //    ss += id + " " + item.getDescription() + " " +  item.getPrice();
        }
      return ss;
    } */
    public Menu(){ 
     menuitems = new TreeMap<String, MenuItem>(); 
    }
    /**
     * @param menuID
     * @return
     */
    public MenuItem getMenuItem(String menuID) {
    	return menuitems.get(menuID);
    }
    /**
     * @param item
     */
    public void addToMenu(MenuItem item) {
        menuitems.put(item.getmenuID(), item);      
    }

    /**
     * @param menuID
     */
    public void removeFromMenu(String menuID) {
    	assert menuitems.containsKey(menuID) : "item not on menu";
        menuitems.remove(menuID);
    }
    /**
     * Format menu as list of strings, with, per menu item, 3 strings for 
     * respectively:
     * - MenuID
     * - Description
     * - Price
     * 
     * Items are expected to be ordered by MenuID.
     * 
     * An example list is:
     * 
     * "D1", "Wine",        "2.50",
     * "D2", "Soft drink",  "1.50",
     * "M1", "Fish",        "7.95",
     * "M2", "Veg chili",   "6.70"
     * 
     * These lists of strings are used by TableDisplay and TicketPrinter
     * to produce formatted ticket output messages.
     * 
     * @return
     */
    public List<String> toStrings() {
      List<String> ss = new ArrayList<String>();
	   //creates menu list from the treemap
	  Set<Entry<String, MenuItem>> ents = menuitems.entrySet();
      for (Entry<String, MenuItem> menuitems : ents) {                          
    	  String id = menuitems.getKey();                                   //for each menuitem in menuitems, get the ID
    	  MenuItem item = menuitems.getValue();                             //now get the menuitem
          String[] stringArray ={id, item.getDescription(), String.format("%5s", item.getPrice())};  //add description and right-align price
          ss.addAll(Arrays.asList(stringArray));                         //all this is modified for toStrings in TicketItem.
          }
          return ss;
    	 //    ss += id + " " + item.getDescription() + " " +  item.getPrice();
        }
    
}
