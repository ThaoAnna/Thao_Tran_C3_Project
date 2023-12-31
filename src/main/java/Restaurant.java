import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class Restaurant {
    private String name;
    private String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    private List<Item> menu;
    private List<Item> cart;

    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.menu = new ArrayList<Item>();
        this.cart = new ArrayList<Item>();
    }

    public boolean isRestaurantOpen() {
        LocalTime currentTime = getCurrentTime();
        if (currentTime.isAfter(openingTime) && currentTime.isBefore(closingTime)) {
            System.out.println("Currently Open");
            return true;
        } else {
            System.out.println("Currently Close");
            return false;
        }
    }

    public LocalTime getCurrentTime(){ return  LocalTime.now(); }

    public List<Item> getMenu() {
        return new ArrayList<Item>(menu);
        //DELETE ABOVE RETURN STATEMENT AND WRITE CODE HERE
    }

    private Item findItemByName(String itemName){
        for(Item item: menu) {
            if(item.getName().equals(itemName))
                return item;
        }
        return null;
    }

    public void addToMenu(String name, int price) {
        Item newItem = new Item(name,price);
        menu.add(newItem);
    }
    
    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }
    public void displayDetails(){
        System.out.println("Restaurant:"+ name + "\n"
                +"Location:"+ location + "\n"
                +"Opening time:"+ openingTime +"\n"
                +"Closing time:"+ closingTime +"\n"
                +"Menu:"+"\n"+getMenu());

    }

    public String getName() {
        return name;
    }

    public int selectItem(Item item) {
        if (!this.cart.contains(item)) {
            this.cart.add(item);
        } else {
            this.cart.remove(item);
        }
        int total = 0;
        for (Item el : this.cart) {
            total += el.getPrice();
        }
        return  total;
    }

}

