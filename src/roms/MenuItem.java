package roms;

public class MenuItem {
	
    private final String menuID;
    private final String description;
    private final Money price;
    public MenuItem(String menuID, String description, Money price) {
      this.menuID = menuID;
      this.description = description;
      this.price = price;
    }
    public String getmenuID() {
    	return menuID;
    }
    public String getDescription() {
    	return description;
    }
    public Money getPrice() {
    	return price;
    }
     
}
