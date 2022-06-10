package com.k19.controllers;
import java.io.IOException;
import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
import com.k19.DAO.UserDAO;
import com.k19.models.Users;
import com.k19.utils.EmailUtility;

@WebServlet(name = "registerController", urlPatterns = { "/member/sign-up/verify" })
public class RegisterController extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private String host;
    private String port;
    private String username;
    private String pass;
    public void init() {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        username = context.getInitParameter("username");
        pass = context.getInitParameter("pass");
    }     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     // reads form fields
        System.out.println("Start register---------------------------------");
        String action = request.getParameter("action");
        String url = null;
        if (action == null) {
            System.out.println("action null");

            action = "cancel";
        }
        if(action.equals("submit"))
        {
            String firstName=request.getParameter("firstName");
            String lastName=request.getParameter("lastName");
            String gentle=request.getParameter("gentle");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String contact=request.getParameter("contact");
            String resultMessage = "";
            String code = EmailUtility.getRandom();
            //find email
            try {
                System.out.println("111111111111111111111111111111");
                Users checkUser= UserDAO.selectUser(email);
                System.out.println("---------------------------------------------");
                if(checkUser==null)
                {
                    //create new user using all information
                    Users user = new Users(code,firstName,lastName,gentle, email, password,contact);
                    boolean test;
                    try {
                         test = EmailUtility.sendEmail(host, port, username, pass, email, "Email Verification",
                                "Registered successfully.Please verify your account using this code: " + user.getCode());
                    } catch (MessagingException e) {
                        // TODO Auto-generated catch block
                         e.printStackTrace();
                         test = false;
                    }
                    //call the send email method
           
                    //check if the email send successfully
                    if(test){
                        url="/verify.jsp";
                        HttpSession session  = request.getSession();
                        session.setAttribute("user", user);
                        resultMessage = "We already send a verification  code to your email.";
                    } else{
                        resultMessage = "There were an error. Please try again!";
                        }
                    getServletContext().getRequestDispatcher("/WEB-INF/views" + url).forward((ServletRequest) request,
                                (ServletResponse) response);
                }
                else{
                    url="/regs.jsp";
                    resultMessage="Email is invalid or already taken";
                    request.setAttribute("mess", resultMessage);
                    getServletContext().getRequestDispatcher("/WEB-INF/views" +url).forward(request, response);
                }
            } catch (ClassNotFoundException | SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }  
	}
}
