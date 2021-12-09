package com.k19.controllers;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.k19.DAO.UserDAO;
import com.k19.models.Users;


@WebServlet(name = "registerVerify", urlPatterns = { "/member/sign-up/verify_confirm" })
public class RegisterVerify extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDao;
    public void init() {
        userDao = new UserDAO();
    }
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterVerify() {
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
		 try (PrintWriter out = response.getWriter()) {
			HttpSession session = request.getSession();
	        Users user= (Users) session.getAttribute("user");
	        
	        String code = request.getParameter("authcode");
	        
	        if(code.equals(user.getCode())){
			//	String url="/thanks.jsp";
	            userDao.saveUser(user);
	            session.setAttribute("newUser", user);
				response.sendRedirect(request.getContextPath() + "/member/sign-in");
	        }else{
	            out.println("Incorrect verification code");
	        }
		}
	}
}
