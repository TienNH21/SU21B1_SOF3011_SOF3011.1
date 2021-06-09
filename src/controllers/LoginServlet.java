package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import entity.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private UserDAO userDao;
	
	public LoginServlet() {
		super();
		
		this.userDao = new UserDAO();
	}
	
	@Override
	protected void doGet(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		request.setAttribute("view", "/views/auth/login.jsp");
		request.getRequestDispatcher("/views/layout.jsp")
			.forward(request, response);
	}

	@Override
	protected void doPost(
		HttpServletRequest request,
		HttpServletResponse response
	) throws IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User entity = this.userDao.login(email, password);
		
		if (entity == null) {
			String error = "Sai email hoặc mật khẩu";
			request.getSession().setAttribute("error", error);
			String location = request.getContextPath() + "/login";
			response.sendRedirect(location);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("user", entity);
			response.sendRedirect(request.getContextPath() + "/admin/users/");
		}
	}
}
