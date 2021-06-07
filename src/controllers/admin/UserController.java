package controllers.admin;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Session;

import dao.UserDAO;
import entity.User;
import utils.HashUtil;
import utils.HibernateUtil;

@WebServlet({
	"/users/",
	"/users/show",
	"/users/create",
	"/users/store",
	"/users/edit",
	"/users/update",
	"/users/delete"
})
public class UserController extends HttpServlet{
	private UserDAO userDao;
	
	public UserController()
	{
		super();
		this.userDao = new UserDAO();
	}
	
	@Override
	protected void doGet(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		String uriPath = request.getRequestURI()
			.replace(request.getContextPath() + "/users", "");

		switch (uriPath) {
			case "/create": {
				this.create(request, response);
				break;
			}
			
			case "/edit": {
				this.edit(request, response);
				break;
			}
			
			case "/show": {
				this.show(request, response);
				break;
			}
			default:
				this.index(request, response);
		}
		System.out.println("URI:" + uriPath);
	}
	
	protected void doPost(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		String uriPath = request.getRequestURI()
			.replace(request.getContextPath() + "/users", "");
		
		switch (uriPath) {
			case "/store": {
				this.store(request, response);
				break;
			}
			case "/update": {
				this.update(request, response);
				break;
			}
			case "/delete": {
				this.delete(request, response);
				break;
			}
			default:
				this.index(request, response);
				break;
		}
	}
	
	private void index(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		List<User> listUser = this.userDao.getAll();
		
		request.setAttribute("listUser", listUser);
		request.setAttribute("view", "/views/admin/users/index.jsp");
		request.getRequestDispatcher("/views/layout.jsp")
		.forward(request, response);
	}

	private void create(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		request.setAttribute("view", "/views/admin/users/create.jsp");
		request.getRequestDispatcher("/views/layout.jsp")
		.forward(request, response);
	}

	private void edit(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		String txtId = request.getParameter("id").toString();
		
		int id = Integer.parseInt(txtId);
		User user = this.userDao.findById(id);
		
		request.setAttribute("user", user);
		request.setAttribute("view", "/views/admin/users/edit.jsp");
		request.getRequestDispatcher("/views/layout.jsp")
		.forward(request, response);
	}

	private void show(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		
		User user = this.userDao.findById(id);

		request.setAttribute("user", user);
		request.setAttribute("view", "/views/admin/users/show.jsp");
		request.getRequestDispatcher("/views/layout.jsp")
		.forward(request, response);
	}
	
	private void store(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		User user = new User();
		Map<String, String[]> requestData = request.getParameterMap();
		try {
			BeanUtils.populate(user, requestData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String hashedPassword = HashUtil.hash( request.getParameter("password") );
		user.setPassword(hashedPassword);
		this.userDao.store(user);
		
		response.sendRedirect(
			request.getContextPath() + "/users/"
		);
	}
	
	private void update(
		HttpServletRequest request,
		HttpServletResponse response
	) throws IOException {
		User entity = new User();
		Map<String, String[]> requestData = request.getParameterMap();
		try {
			BeanUtils.populate(entity, requestData);
		} catch (Exception e) {
			e.printStackTrace();
		}

		 this.userDao.update(entity);
		 response.sendRedirect(request.getContextPath() + "/users/");
	}

	private void delete(
		HttpServletRequest request,
		HttpServletResponse response
	) throws IOException {
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		User entity = this.userDao.findById(id);
		this.userDao.delete(entity);
		response.sendRedirect(request.getContextPath() + "/users/");
	}
}
