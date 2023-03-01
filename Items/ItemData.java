package com.Andrei.ShopWebService.Items;

import com.Andrei.ShopWebService.Category.Category;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
//This class hold all the methods that involves an item
public class ItemData {

    //This methode send a request to the database and return an Item based on its id
    //if the list of items has a size of 0 the item does not exist and if the size
    //is bigger than 1 there is a problem
    public static Item getSpecificItem(JdbcTemplate jdbcTemplate, String itemId){
        List<Item> list= jdbcTemplate.query("select * from shop.users where id="+itemId+"",(rs, rowNum) ->
                new Item(
                        rs.getInt("id"),
                        rs.getInt("cartId"),
                        rs.getInt("productId"),
                        rs.getInt("cuantity")
                )
        );
        if(list.size()==1){
            return list.get(0);
        }
        return null;
    }

    //This methode send a request to the database to get a list of items that are in the same cart
    //based on cart's id
    public static List<Item> getItemForSpecificCart(JdbcTemplate jdbcTemplate, String cartId){
        return jdbcTemplate.query("select * from shop.users where cartId="+cartId+"",(rs, rowNum) ->
                new Item(
                        rs.getInt("id"),
                        rs.getInt("cartId"),
                        rs.getInt("productId"),
                        rs.getInt("cuantity")
                )
        );
    }
    //This methode insert an item in the database
    public static String addItemToSpecificCart(JdbcTemplate jdbcTemplate, String cartId, String productId, String cuantity){
        jdbcTemplate.execute("insert into shop.item values(null,"+cartId+","+productId+","+cuantity+")");
        return "Product added";
    }

    //This methode deletes an item from the database
    public static String deleteItemFromSpecificCart(JdbcTemplate jdbcTemplate, String itemId){
        jdbcTemplate.execute("delete from shop.item whete id="+itemId+"");
        return "Product deleted";
    }
    //This methode deletes all the items that have the same cartId
    public static String deleteAllItemsFromSpecificCart(JdbcTemplate jdbcTemplate, String cartId){
        jdbcTemplate.execute("delete from shop.item whete cartId="+cartId+"");
        return "Products deleted";
    }
    //This methode updates an item quantity
    public static String updateItemCuantity(JdbcTemplate jdbcTemplate, String itemId,String newQuantity){
        jdbcTemplate.execute("update shop.item set quantity= "+newQuantity+" where id="+itemId+"");
        return "done";
    }
    //This methode get an item quantity and then based on some listeners decide if we increment
    //or decrement that quantity
    public static String modifyCuantity(JdbcTemplate jdbcTemplate,String itemId, String action){
        Item item=ItemData.getSpecificItem(jdbcTemplate,itemId);
        if(action.equals("increment")){
            item.setQuantity(item.getQuantity()+1);
        }
        else {
            item.setQuantity(item.getQuantity()-1);
        }
        return updateItemCuantity(jdbcTemplate,itemId, item.getQuantity()+"");
    }
}
