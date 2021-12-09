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
@WebServlet(name = "VerifyEdit", urlPatterns = { "/editConfirm" })
public class VerifyEdit extends HttpServlet {
    private static final long serialVersionUID = 1L;
	private static final String String = null;
    private UserDAO userDao;
	private Object attribute;
    public void init() {
        userDao = new UserDAO();
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerifyEdit() {
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
			response.setCharacterEncoding("UTF-8");
        	request.setCharacterEncoding("UTF-8");
	        Users userEdit= (Users) session.getAttribute("userEdit");
            String authcode=request.getParameter("authcode");
	        if(authcode.equals(userEdit.getCode())){
				ServletContext sc=getServletContext();
				//	String url="/thanks.jsp";
	            // userDao.saveUser(user);
	            // session.setAttribute("newUser", user);
				// response.sendRedirect(request.getContextPath() + "/member/sign-in");
				this.userDao.updateUser(userEdit);
                session.setAttribute("newUser", userEdit);
                session.setAttribute("email", userEdit.getEmail());
                session.setAttribute("member", userEdit.getFirstName()+userEdit.getLastName());
				sc.getRequestDispatcher("/index.jsp").forward(request, response); 
				// response.sendRedirect("/");
	        }else{
	            out.println("Incorrect verification code");
	        }
		}
	}
}
