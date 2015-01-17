import java.util.*;

public class Item {
    
    public String name;
    public double diningPrice;
    public double ralphsPrice;
    public double changeInPrice;
    public int type;
    
    public Item(String name) {
        this.name = name;
        
        Random r = new Random();
        this.diningPrice = Math.round(1 + (5 - 1) * r.nextDouble() * 100.0) / 100.0;
        this.ralphsPrice = Math.round(1 + (4 - 1) * r.nextDouble() * 100.0) / 100.0;
        this.changeInPrice = (Math.round(diningPrice * 100.0) / 100.0) - (Math.round(ralphsPrice * 100.0) / 100.0);
        this.type = 0;
    }
    
    // getters
    
    public String getName() {
        return this.name;
    }
    
    public double getDiningPrice() {
        return this.diningPrice;
    }
    
    public double getRalphsPrice() {
        return this.ralphsPrice;
    }
    
    public double getChangeInPrice() {
        return this.changeInPrice;
    }
    
    public int getType() {
        return this.type;
    }
    
    // setters
    
    public void setName(int type) {
        this.type = type;
    }
    
    public void setDiningPrice(double price) {
        this.diningPrice = price;
        this.changeInPrice = (this.diningPrice - this.ralphsPrice);
    }
    
    public void setRalphsPrice(double price) {
        this.ralphsPrice = price;
        this.changeInPrice = (this.diningPrice - this.ralphsPrice);
    }
    
    public void setChangeInPrice(double price) {
        this.changeInPrice = price;
    }
    
    public void setType(int type) {
        this.type = type;
    }
}