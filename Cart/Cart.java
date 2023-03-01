package com.Andrei.ShopWebService.Cart;

//This class it's a template for Cart
//Cart-placeholer for items that users might want to buy
public class Cart {

    private int id;
    private int userId;

    public Cart(int id, int userId) {
        this.id = id;
        this.userId = userId;
    }

    public Cart(int userId) {
        this.userId = userId;
    }

    public Cart() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", userId=" + userId +
                '}';
    }
}
