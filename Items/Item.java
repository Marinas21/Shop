package com.Andrei.ShopWebService.Items;

//This class it's a template for items
//Items- placeholders for ptoducts that have cuantity in a cart
public class Item {

    private int id;
    private int cartId;
    private int productId;
    private int quantity;

    public Item() {
    }

    public Item(int cartId, int productId, int quantity) {
        this.cartId = cartId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public Item(int id, int cartId, int productId, int quantity) {
        this.id = id;
        this.cartId = cartId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int cuantity) {
        this.quantity = cuantity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", cartId=" + cartId +
                ", productId=" + productId +
                ", cuantity=" + quantity +
                '}';
    }
}
