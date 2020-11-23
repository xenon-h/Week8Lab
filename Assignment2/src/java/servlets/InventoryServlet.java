/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dataaccess.CategoryDB;
import dataaccess.ItemDB;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Category;
import models.Item;
import models.Item_;
import services.ItemService;

/**
 *
 * @author 759005
 */
public class InventoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ItemService itemService = new ItemService();
        CategoryDB categoryDB = new CategoryDB();
        List<Item> itemList;
        List<Category> categoryList;

        try {
            itemList = itemService.getAllItems();
            categoryList = categoryDB.getAll();
            request.setAttribute("itemList", itemList);
            request.setAttribute("categoryList", categoryList);
        } catch (Exception ex) {
            Logger.getLogger(InventoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/inventory.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ItemDB itemService = new ItemDB();
        String action = request.getParameter("action");
        String email = request.getParameter("email");

        if (action != null) {

            String itemId = request.getParameter("itemId");

            switch (action) {
                case "delete":
                    try {
                        if (itemService.get(itemId).getOwner().getEmail().equals(email)) {
                        Item toDelete = itemService.get(itemId);
                        itemService.delete(toDelete);
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "Add":

                    int category = Integer.parseInt(request.getParameter("category"));
                    String itemName = request.getParameter("itemName");
                    double price = Double.parseDouble(request.getParameter("price"));

                    try {
                        Item item = new Item(category, itemName, price);
                        itemService.insert(item);
                    } catch (Exception ex) {
                        Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
                        Item item = new Item(category, itemName, price);
                        request.setAttribute("newItem", item);
                    }
                    break;
            }

        }

        CategoryDB categoryDB = new CategoryDB();
        List<Item> itemList;
        List<Category> categoryList;

        try {
            itemList = itemService.getAll();
            categoryList = categoryDB.getAll();
            request.setAttribute("itemList", itemList);
            request.setAttribute("categoryList", categoryList);
        } catch (Exception ex) {
            Logger.getLogger(InventoryServlet.class.getName()).log(Level.SEVERE, null, ex);

            getServletContext().getRequestDispatcher("/WEB-INF/inventory.jsp").forward(request, response);

        }

        getServletContext()
                .getRequestDispatcher("/WEB-INF/inventory.jsp").forward(request, response);
    }
}
