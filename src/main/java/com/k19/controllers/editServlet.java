package com.k19.controllers;

import java.io.IOException;

import javax.persistence.Entity;
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
import com.k19.models.memberJPA;

@WebServlet(urlPatterns = { "/edit/confirm" })
public class editServlet extends HttpServlet {
    memberJPADAO mjdao = null;

    // init
    public editServlet() {
        this.mjdao = new memberJPADAO();
    }

    // [GET] /edit/confirm
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    // [POST] /edit/confirm
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        // get action
        String action = req.getParameter("action");
        // get data
        final String firstName = req.getParameter("firstName");
        final String lastName = req.getParameter("lastName");
        final String fullName = firstName + " " + lastName;
        final String email = req.getParameter("email");
        final String contact = req.getParameter("contact");
        final String gentle = req.getParameter("gentle");
        //
        if (action.equals(null)) {
            action = "cancel";
        }
        if (action.equals("edit")) {
            final memberJPA member = new memberJPA();
            member.setFirstName(firstName);
            member.setLastName(lastName);
            member.setFullName(fullName);
            member.setEmail(email);
            member.setContact(contact);
            member.setGentle(gentle);

            try {
                this.mjdao.updateMember(member);
                req.setAttribute("user", (memberJPA) member);
                System.out.println("updated");
                // Get json
                String jsonMember = new Gson().toJson(member);
                session.setAttribute("memberJSON", jsonMember);

                getServletContext().getRequestDispatcher("/index.jsp").forward((ServletRequest) req,
                        (ServletResponse) resp);
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        } else if (action.equals("cancel")) {
            resp.sendRedirect(req.getContextPath() + "/");
        }

    }
}
