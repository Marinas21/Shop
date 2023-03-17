package com.Andrei.ShopWebService.Order.OrderItem;

import com.Andrei.ShopWebService.Order.OrderInfo.OrderInformations;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class OrderItemUtility {

    public static String createOrderItemUtilitys(JdbcTemplate jdbcTemplate, String orderId, String productId,int quality){
        jdbcTemplate.execute("insert into shop.order_items values(null,"+orderId+" ,"+productId+" ,'"+quality+"')");
        return "Item created";
    }

    public static List<OrderItems> getOrderItems(JdbcTemplate jdbcTemplate, String orderId){
         return jdbcTemplate.query("select * from shop.order_informations where orderId="+orderId+"",(rs, rowNum) ->
                new OrderItems(
                        rs.getInt("id"),
                        rs.getInt("orderId"),
                        rs.getInt("productId"),
                        rs.getInt("quantity")
                )
        );
    }
    }

