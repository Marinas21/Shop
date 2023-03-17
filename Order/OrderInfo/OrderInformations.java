package com.Andrei.ShopWebService.Order.OrderInfo;

public class OrderInformations {
    private int id;
    private int orderId;
    private String county;
    private String city;
    private String adress;
    private String phoneNumber;

    public OrderInformations(int id, int orderId, String county, String city, String adress, String phoneNumber) {
        this.id = id;
        this.orderId = orderId;
        this.county = county;
        this.city = city;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
    }

    public OrderInformations(int orderId, String county, String city, String adress, String phoneNumber) {
        this.orderId = orderId;
        this.county = county;
        this.city = city;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
    }

    public OrderInformations() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "OrderInformations{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", county='" + county + '\'' +
                ", city='" + city + '\'' +
                ", adress='" + adress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
