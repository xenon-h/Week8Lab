/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.CategoryDB;
import dataaccess.ItemDB;
import java.util.List;
import models.Category;
import models.Item;

/**
 *
 * @author 759005
 */
public class ItemService {

    public List<Item> getAllItems() throws Exception {
        ItemDB itemDB = new ItemDB();
        List<Item> resultSet = itemDB.getAll();
        return resultSet;
    }

    public void deleteItem(String item_id) throws Exception {
        ItemDB itemDB = new ItemDB();
        Item item;
        item = itemDB.get(item_id);
        itemDB.delete(item);
    }

    public void addItem(int category, String name, double price) throws Exception {
            ItemDB itemDB = new ItemDB();
            CategoryDB categoryDB = new CategoryDB();

            int size = getAllItems().size();

            Item item = new Item(size, name, price);
            Category cat = categoryDB.get(category);

            item.setCategory(cat);
            itemDB.insert(item);

    }
}
