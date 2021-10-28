package Telkom.Challenge.Model.Data.TestObject;

import java.util.Vector;

public class Cart {

    private String name;
    private int orderNumber;
    private String courier;
    private Vector<DetailProduct> product;
    private int total;
    private int code;
    private String success;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCourier() {
        return courier;
    }

    public void setCourier(String courier) {
        this.courier = courier;
    }

    public Vector<DetailProduct> getProduct() {
        return product;
    }

    public void setProduct(Vector<DetailProduct> product) {
        this.product = product;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
