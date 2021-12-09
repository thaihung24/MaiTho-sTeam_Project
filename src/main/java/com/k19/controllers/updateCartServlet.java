package com.k19.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.Index;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.k19.DAO.memberJPADAO;
import com.k19.DAO.productJPADAO;
import com.k19.models.cartJPA;
import com.k19.models.lineItemJPA;

import antlr.collections.List;

@WebServlet(urlPatterns = { "/cart/update" })
public class updateCartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //
        HttpSession session = req.getSession();
        cartJPA cart;
        //
        String action = req.getParameter("action");
        String[] productCode = req.getParameterValues("product_code");
        String[] qty = req.getParameterValues("qty");
        // if(action)
        if (action == null) {
            action = "cart";
        }
        if (action.equals("cart")) {
            cart = (cartJPA) session.getAttribute("cart");
            ArrayList<lineItemJPA> listItem = cart.getItems();
            boolean check = false;
            int index = 0;
            for (lineItemJPA item : listItem) {
                try {
                    // check if product in cart have existed in session yet
                    if (item.getProduct().getCode() == productJPADAO.selectProduct(productCode[index]).getCode()) {
                        item.setQuantity(Integer.parseInt(qty[index]));
                    }
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }
                index++;
            }
            session.setAttribute("cart", cart);
            // update JSON
            String jsonCart = new Gson().toJson(cart.getItems());
            session.setAttribute("cartJSON", jsonCart);
        }
        String tempurl = "/cart.jsp";
        getServletContext().getRequestDispatcher("/WEB-INF/views/member" + tempurl).forward((ServletRequest) req,
                (ServletResponse) resp);
    }
}
