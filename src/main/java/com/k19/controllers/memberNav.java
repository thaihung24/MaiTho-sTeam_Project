package com.k19.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

// servlet mapping
@WebServlet(name = "memberNavServlet", urlPatterns = { "/sign-up", "/sign-in" })
public class memberNav extends HttpServlet {
    // [GET] /sign-up
    // [GET] /sign-in

    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
            throws ServletException, IOException {
        String url = "";
        String temp = req.getRequestURI().toString();
        String slug = temp.substring(8, temp.length());
        System.out.println(temp);

        System.out.println(slug);

        System.out.println(slug);
        // [GET] /sign-in
        if (slug.equals("sign-in")) {
            url = "/WEB-INF/views/login.jsp";
            System.out.println("Im 0");

        }
        // [GET] /sign-up
        else if (slug.equals("sign-up")) {
            url = "/WEB-INF/views/register.jsp";
            System.out.println("Im 1");

        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
        getServletContext().getRequestDispatcher(url).forward((HttpServletRequest) req, (HttpServletResponse) resp);

        // final RequestDispatcher rd =
        // req.getRequestDispatcher("/WEB-INF/views/register.jsp");
        // rd.forward((HttpServletRequest) req, (HttpServletResponse) resp);
    }
}
