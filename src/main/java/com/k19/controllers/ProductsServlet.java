package com.k19.controllers;

import javax.servlet.http.HttpServlet;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.k19.models.productJPA;
import com.k19.DAO.productJPADAO;

@WebServlet(urlPatterns = { "/products" })
public class ProductsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String url = "/category.jsp";

        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "display_products"; // default action
        }
        // perform action and set URL to appropriate page
        if (action.equals("display_products")) {
            // get list of products
            List<productJPA> products = productJPADAO.selectProducts();
            request.setAttribute("products", products);
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
