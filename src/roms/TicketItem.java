package roms;

public class TicketItem {
    private int count;
    private final MenuItem item;
    private final String id;
    private final String desc;
    private final Money price;
    
    public TicketItem(MenuItem item){
    	count = 0;
    	this.item = item;
    	id = item.getmenuID();
    	desc = item.getDescription();
    	price = item.getPrice();
    }
    
    public String getmenuID() {
    	return id;
    }
    public String getDescription() {
    	return desc;
    }
    public Money getPrice() {
    	return price;
    }
    
    public void add() {
    	count ++;
    }
    
    public void rem() {
    	count --;
    }
    
    public int getCount() {
    	return count;
    }

}
