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
	
	public OfficeKVM ofkvm;
	
    public Menu menu;	
    public TreeMap<String, MenuItem> menuitems;
    
    public void setO(OfficeKVM o){
    	ofkvm = o;
    }
    public void showm() {
    	String m = showMenu();
    	ofkvm.dmenu(m);
    }
    
   public String showMenu(){
//      String ss = "";	
	  String ss = "\nID" + String.format("%18s", "Description") + String.format("%12s", "Price");
	  Set<Entry<String, MenuItem>> entrys = menuitems.entrySet();
      for (Entry<String, MenuItem> menuitems : entrys) {
    	  String id = menuitems.getKey();
    	  MenuItem item = menuitems.getValue();
         ss += "\n" + id + ", " + String.format("%15s", item.getDescription()) + ", " +  String.format("%10s", item.getPrice());
    	 //    ss += id + " " + item.getDescription() + " " +  item.getPrice();
  }
      return ss;
    }
    public Menu(){ 
     menuitems = new TreeMap<String, MenuItem>(); 
    }
    
    public MenuItem getMenuItem(String menuID) {
    	return menuitems.get(menuID);
    }
    public void addToMenu(MenuItem item) {
        menuitems.put(item.getmenuID(), item);   
    }

    public void removeFromMenu(String menuID) {
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
 
        // Dummy implementation. 
        String[] stringArray = 
            {"D1", "Wine",        "2.50",
             "D2", "Soft drink",  "1.50",
             "M1", "Fish",        "7.95",
             "M2", "Veg chili",   "6.70"
            };
        List<String> ss = new ArrayList<String>();
        ss.addAll(Arrays.asList(stringArray));
        return ss;
    }
    
}
