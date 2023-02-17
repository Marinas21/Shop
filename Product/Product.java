package com.Andrei.ShopWebService.Product;

//This class it's a template for products
public class Product {

    private int id;
    private String name;
    private int categoryId;
    private double price;

    public Product() {
    }

    public Product(String name, int categoryId, double price) {
        this.name = name;
        this.categoryId = categoryId;
        this.price = price;
    }

    public Product(int id, String name, int categoryId, double price) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", categoryId=" + categoryId +
                ", price=" + price +
                '}';
    }
}
