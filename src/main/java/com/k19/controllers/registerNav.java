package com.k19.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

// servlet mapping
@WebServlet(name = "registerNavServlet", urlPatterns = { "/sign-up", "sign-in" })
public class registerNav extends HttpServlet {
    // [GET] /sign-up
    // [GET] /sign-in

    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
            throws ServletException, IOException {
        String url = "/WEB-INF/views/register.jsp";
        String temp = "/" + req.getRequestURI().toString();
        String slug[] = temp.split("/");
        System.out.println(slug[1]);
        // [GET] /sign-in
        if (slug[1] == "sign-in") {
            url = "/WEB-INF/views/login.html";
        }
        // [GET] /sign-up
        else if (slug[1] == "sign-up") {
            url = "/WEB-INF/views/register.jsp";
        }
        getServletContext().getRequestDispatcher(url).forward((HttpServletRequest) req, (HttpServletResponse) resp);

        // final RequestDispatcher rd =
        // req.getRequestDispatcher("/WEB-INF/views/register.jsp");
        // rd.forward((HttpServletRequest) req, (HttpServletResponse) resp);
    }
}
