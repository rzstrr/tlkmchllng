package Telkom.Challenge.Model.Data.TestObject;

public class Transaction{

    private String transaction_id;
    private String address_ship;
    private String date_order;
    private String seller_name;
    private String delivery_service;

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getAddress_ship() {
        return address_ship;
    }

    public void setAddress_ship(String address_ship) {
        this.address_ship = address_ship;
    }

    public String getDate_order() {
        return date_order;
    }

    public void setDate_order(String date_order) {
        this.date_order = date_order;
    }

    public String getSeller_name() {
        return seller_name;
    }

    public void setSeller_name(String seller_name) {
        this.seller_name = seller_name;
    }

    public String getDelivery_service() {
        return delivery_service;
    }

    public void setDelivery_service(String delivery_service) {
        this.delivery_service = delivery_service;
    }
}