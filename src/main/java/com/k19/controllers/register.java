package com.k19.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

import com.k19.models.member;
import com.k19.models.memberJPA;
import com.k19.DAO.memberDAO;
import com.k19.DAO.memberJPADAO;

// servlet mapping
@WebServlet(name = "registerConfirmServlet", urlPatterns = { "/member/sign-up/confirm" })

public class register extends HttpServlet {
    private memberDAO mdao;
    private memberJPADAO mjdao;

    // init edao when Servlet init
    public register() {
        // this.mdao = new memberDAO();
        this.mjdao = new memberJPADAO();
    }

    // [GET] /member/sign-up/confirm
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
            throws ServletException, IOException {
        this.doPost(req, resp);
    }

    // [POST] /member/sign-up/confirm
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("Start register---------------------------------");

        String action = req.getParameter("action");
        String url = null;
        if (action == null) {
            System.out.println("action null");

            action = "cancel";
        }
        if (action.equals("submit")) {
            // get value
            System.out.println("start submit===---------------------------");

            final String firstName = req.getParameter("firstName");
            final String lastName = req.getParameter("lastName");
            final String fullName = firstName + " " + lastName;
            final String username = req.getParameter("username");
            final String password = req.getParameter("password");
            final String email = req.getParameter("email");
            final String contact = req.getParameter("contact");
            final String gentle = req.getParameter("gentle");
            // final member member = new member();
            final memberJPA member = new memberJPA();
            member.setFirstName(firstName);
            member.setLastName(lastName);
            member.setFullName(fullName);
            member.setUsername(username);
            member.setPassword(password);
            member.setEmail(email);
            member.setContact(contact);
            member.setGentle(gentle);

            // Halo Data
            try {// try to insert value
                 // this.mdao.insertMember(member);
                 // req.setAttribute("user", (member) member);
                this.mjdao.insertMember(member);
                req.setAttribute("user", (memberJPA) member);

                url = "/thanks.jsp";
                System.out.println("insert");

                getServletContext().getRequestDispatcher("/WEB-INF/views" + url).forward((ServletRequest) req,
                        (ServletResponse) resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (action.equals("cancel")) {
            System.out.println("cancel");
            resp.sendRedirect(req.getContextPath() + "/member/sign-up");
        }
    }
}
