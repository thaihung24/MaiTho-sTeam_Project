package com.k19.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.k19.DAO.memberJPADAO;
import com.k19.models.memberJPA;
import com.k19.utils.cookieUtil;

@WebServlet(urlPatterns = { "/member", "/edit" })
public class memberHome extends HttpServlet {

    // [GET] /member
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //
        String temp = req.getRequestURI().toString();
        String slug = temp.substring(8, temp.length());// heroku 1 , tomcat 8
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
                String tempurl = "/index.jsp";
                session.setAttribute("message", "Halo welcome back my friend");
                getServletContext().getRequestDispatcher(tempurl).forward((ServletRequest) req, (ServletResponse) resp);
            }

        } else if (slug.equals("edit")) {
            Cookie[] allc = req.getCookies();
            // get last value
            String c = cookieUtil.getCookieValue(allc, "usernameCookie");
            if (c.equals("") || c.equals(null)) {
                getServletContext().getRequestDispatcher("/WEB-INF/views/member/member.jsp").forward(req, resp);

            }
            // come back
            else {
                memberJPA member = memberJPADAO.selectMember(c);
                req.setAttribute("memberEdit", member);
                String tempurl = "/edit.jsp";
                getServletContext().getRequestDispatcher("/WEB-INF/views/member" + tempurl)
                        .forward((ServletRequest) req, (ServletResponse) resp);
            }
        }
    }

    // [POST] /member
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
