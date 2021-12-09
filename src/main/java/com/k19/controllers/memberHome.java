package com.k19.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.k19.DAO.UserDAO;
import com.k19.DAO.memberJPADAO;
import com.k19.models.cartJPA;
import com.k19.models.memberJPA;
import com.k19.models.Users;
import com.k19.utils.cookieUtil;

@WebServlet(urlPatterns = { "/member", "/edit", "/cart","/product" })
public class memberHome extends HttpServlet {

    // [GET] /member
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //
        String temp = req.getRequestURI().toString();
        String slug = temp.substring(1, temp.length());// heroku 1 , tomcat 8
        System.out.println(slug);
        // handle slug
        if (slug.equals("member")) {
            Cookie[] allc = req.getCookies();
            HttpSession session = req.getSession();
            // get last value
            String c = cookieUtil.getCookieValue(allc, "usernameCookie");
            // first time
            if (c.equals("") || c.equals(null)) {
                getServletContext().getRequestDispatcher("/WEB-INF/views/member/member.jsp").forward(req, resp);

            }
            // come back
            else {
                String tempurl = "/WEB-INF/views/member/edit.jsp";
                Users User;
                try {
                    User = UserDAO.selectUser(c);
                    req.setAttribute("userEdit", User);
                    session.setAttribute("message", "Halo welcome back my friend");
                } catch (ClassNotFoundException | SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    tempurl="index.jsp";
                }
                getServletContext().getRequestDispatcher(tempurl).forward((ServletRequest) req, (ServletResponse) resp);
            }

        } else if (slug.equals("edit")) {
            Cookie[] allc = req.getCookies();
            // get last value
            // String c = cookieUtil.getCookieValue(allc, "usernameCookie");
            String c = cookieUtil.getCookieValue(allc, "userIdCookie");
            if (c.equals("") || c.equals(null)) {
                getServletContext().getRequestDispatcher("/WEB-INF/views/member/member.jsp").forward(req, resp);

            }
            // come back
            else {
                // memberJPA member = memberJPADAO.selectMember(c);
                memberJPA member = memberJPADAO.selectMemberbyId(Integer.parseInt(c));
                req.setAttribute("memberEdit", member);
                String tempurl = "/edit.jsp";
                getServletContext().getRequestDispatcher("/WEB-INF/views/member" + tempurl)
                        .forward((ServletRequest) req, (ServletResponse) resp);
            }
        } else if (slug.equals("cart")) {
            HttpSession session = req.getSession();
            cartJPA cart = null;
            // Need synchronize access to member's carts
            // final Object lock = req.getSession().getId().intern();
            cart = (cartJPA) session.getAttribute("cart");
            // Get json

            if (cart == null) {
                cart = new cartJPA();
                session.setAttribute("cart", cart);
            }
            // come back
            else {
                String jsonCart = new Gson().toJson(cart.getItems());
                session.setAttribute("cartJSON", jsonCart);
            }
            getServletContext().getRequestDispatcher("/products?action=display_products").forward((ServletRequest) req,
                    (ServletResponse) resp);
        }
        else if(slug.equals("product")){
        //     HttpSession session = req.getSession();
           
        //     // Need synchronize access to member's carts
        //     // final Object lock = req.getSession().getId().intern();
        //    cartJPA cart = (cartJPA) session.getAttribute("cart");
        //     // Get json

        //     if (cart == null) {
        //         cart = new cartJPA();
        //         session.setAttribute("cart", cart);
        //     }
        //     // come back
        //     else {
        //         String jsonCart = new Gson().toJson(cart.getItems());
        //         session.setAttribute("cartJSON", jsonCart);
        //     }
            getServletContext().getRequestDispatcher("/products").forward((ServletRequest) req,
                    (ServletResponse) resp);
        }
    }

    // [POST] /member
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
