package Telkom.Challenge.Model.Data.TestObject;

public class DetailProduct{

    private String item;
    private int price;

    public DetailProduct(String items,int prices){
        this.item = items;
        this.price = prices;
    }
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}