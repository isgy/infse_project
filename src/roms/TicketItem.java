package roms;

public class TicketItem {
    private int count;
    private final MenuItem item;
    
    public TicketItem(MenuItem item){
    	count = 0;
    	this.item = item;
    }
    
    public String getmenuID() {
    	return item.getmenuID();
    }
    public String getDescription() {
    	return item.getDescription();
    }
    public Money getPrice() {
    	return item.getPrice();
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
