package com.k19.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.k19.DAO.productJPADAO;
import com.k19.models.cartJPA;
import com.k19.models.lineItemJPA;
import com.k19.models.productJPA;

import antlr.collections.List;

@WebServlet(urlPatterns = { "/cart/changecart" })
public class changeCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // default
        int quantity = 1;
        cartJPA cart;
        String productCode = req.getParameter("productID");
        if (productCode != null) {
            try {
                productJPA product = productJPADAO.selectProduct(productCode);
                if (product != null) {
                    HttpSession session = req.getSession();
                    cart = (cartJPA) session.getAttribute("cart");
                    if (cart == null) {
                        cart = new cartJPA();
                        ArrayList<lineItemJPA> list = new ArrayList<lineItemJPA>();
                        lineItemJPA item = new lineItemJPA();
                        item.setQty(quantity);
                        item.setProduct(product);
                        list.add(item);
                        cart.setItems(list);
                        session.setAttribute("cart", cart);
                    } else {
                        ArrayList<lineItemJPA> list = cart.getItems();
                        boolean check = false;
                        for (lineItemJPA item : list) {
                            if (item.getProduct().getCode() == product.getCode()) {
                                item.setQty(item.getQty() + quantity);
                                // update quantity
                                check = true;
                            }
                        }
                        if (!check) {
                            lineItemJPA item = new lineItemJPA();
                            item.setQty(quantity);
                            item.setProduct(product);
                            list.add(item);
                        }
                        session.setAttribute("cart", cart);
                    }
                }
                resp.sendRedirect(req.getContextPath() + "/cart");
            } catch (ClassNotFoundException | SQLException e) {
                // TODO Auto-generated catch block
                resp.sendRedirect(req.getContextPath() + "/cart");

                e.printStackTrace();
            }
        } else {// không có parameter
            resp.sendRedirect(req.getContextPath() + "/cart");

        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);

    }
}
