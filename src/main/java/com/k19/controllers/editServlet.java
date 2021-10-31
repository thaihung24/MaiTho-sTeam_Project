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
    memberJPADAO mjdao;

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
        int _id = Integer.parseInt(req.getParameter("_id"));
        // get entity need edit
        // error do thang session return null
        // memberJPA memberEdit = (memberJPA) session.getAttribute("memberEdit");
        System.out.println(session.getAttribute("memberEdit"));
        memberJPA memberEdit = this.mjdao.selectMemberbyId(_id);
        //
        if (memberEdit != null) {
            if (action.equals(null)) {
                action = "cancel";
            }
            if (action.equals("edit")) {
                // get data
                final String firstName = req.getParameter("firstName");
                final String lastName = req.getParameter("lastName");
                final String fullName = firstName + " " + lastName;
                final String email = req.getParameter("email");
                final String contact = req.getParameter("contact");
                final String gentle = req.getParameter("gentle");
                memberEdit.setFirstName(firstName);
                memberEdit.setLastName(lastName);
                memberEdit.setFullName(fullName);
                memberEdit.setEmail(email);
                memberEdit.setContact(contact);
                memberEdit.setGentle(gentle);
                try {
                    System.out.println("Update---------------");
                    this.mjdao.updateMember(memberEdit);
                    System.out.println("merge---------------");

                    req.setAttribute("username", (memberJPA) memberEdit);
                    System.out.println("updated------------");
                    // Get json
                    String jsonMember = new Gson().toJson(memberEdit);
                    session.setAttribute("memberJSON", jsonMember);

                    getServletContext().getRequestDispatcher("/index.jsp").forward((ServletRequest) req,
                            (ServletResponse) resp);
                } catch (NullPointerException e) {
                    e.printStackTrace();
                } finally {
                    // destroy old edit info
                    session.invalidate();
                }
            } else if (action.equals("cancel")) {
                resp.sendRedirect(req.getContextPath() + "/");
            }
        } else {
            System.out.println("Select member by id method return null");
        }
    }
}
