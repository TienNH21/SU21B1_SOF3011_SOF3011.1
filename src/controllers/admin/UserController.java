package controllers.admin;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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
				// edit
				break;
			}
			
			case "/show": {
				// show
				break;
			}
			default:
				// index
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

	private void create(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		request.getRequestDispatcher("/views/admin/users/create.jsp")
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
