package com.Andrei.ShopWebService.Order.OrderInfo;

import com.Andrei.ShopWebService.User.User;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class OrderInfromationsUtility {

    public static String createOrderInformation(JdbcTemplate jdbcTemplate,String orderId,String country,
                                                String city, String adress, String phoneNumber){
        jdbcTemplate.execute("insert into shop.order_informations values(null,"+orderId+",'"+country+"'," +
                "'"+city+"','"+adress+"','"+phoneNumber+"'");
        return "Order information created";
    }

    public static OrderInformations getOrderInformationById(JdbcTemplate jdbcTemplate,String id){
        List<OrderInformations> list=new ArrayList<>();
        list=jdbcTemplate.query("select * from shop.order_informations where id="+id+"",(rs, rowNum) ->
                new OrderInformations(
                        rs.getInt("id"),
                        rs.getInt("orderId"),
                        rs.getString("county"),
                        rs.getString("city"),
                        rs.getString("adress"),
                        rs.getString("phone_number")
                )
        );
        if(list.size()==1){
            return list.get(0);
        }
        return null;
    }

    public static String deleteOrderInformationsById(JdbcTemplate jdbcTemplate,String id){
        jdbcTemplate.execute("delete from shop.order_informations where id="+id+"");
        return "Done";
    }

    public static String updateOrderInformationById(JdbcTemplate jdbcTemplate,String id,String country,
                                                    String city, String adress, String phoneNumber){
        jdbcTemplate.execute("update shop.order_informations set country='"+country+"' ,city='"+city+"'" +
                " , adress='"+adress+"' , phone_number='"+phoneNumber+"' where id="+id+" ");
        return "Item updated";
    }
}
