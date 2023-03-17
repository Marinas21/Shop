package com.Andrei.ShopWebService.Order;

import com.Andrei.ShopWebService.Order.OrderInfo.OrderInformations;
import com.Andrei.ShopWebService.Order.OrderItem.OrderItems;

import java.util.Date;
import java.util.List;

public class Order {

    private int id;
    private int userId;
    private Date date;
    private String status;
    private OrderInformations orderInformations;
    private List<OrderItems> orderItems;

    public Order(int id, int userId, Date date, String status, OrderInformations orderInformations, List<OrderItems> orderItems) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.status = status;
        this.orderInformations = orderInformations;
        this.orderItems = orderItems;
    }

    public Order(int userId, Date date, String status, OrderInformations orderInformations, List<OrderItems> orderItems) {
        this.userId = userId;
        this.date = date;
        this.status = status;
        this.orderInformations = orderInformations;
        this.orderItems = orderItems;
    }

    public Order() {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public OrderInformations getOrderInformations() {
        return orderInformations;
    }

    public void setOrderInformations(OrderInformations orderInformations) {
        this.orderInformations = orderInformations;
    }

    public List<OrderItems> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItems> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", orderInformations=" + orderInformations +
                ", orderItems=" + orderItems +
                '}';
    }
}
