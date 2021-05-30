package controllers.admin;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import entity.User;

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
			}
			default:
		}
	}
	
	private void index(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
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
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/j4_demo",
				username = "root", password = "Aa@123456";
			
			Connection conn = DriverManager.getConnection(url, username, password);
			String sql = "SELECT * FROM users WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			String name = rs.getString("name");
			String email = rs.getString("email");
			String pwd = rs.getString("password");
			
			System.out.println(name + " - " + email + " - " + pwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		
		System.out.println("Họ Tên: " + user.getHoTen());
		System.out.println("Email: " + user.getEmail());
		System.out.println("Chuyên ngành: " + user.getChuyenNganh());
	}
}
