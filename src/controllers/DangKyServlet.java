package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dang-ky")
public class DangKyServlet extends HttpServlet {
	protected void doGet(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		request.getRequestDispatcher("/views/dang_ky.jsp")
		.forward(request, response);
	}
	
	protected void doPost(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String genderStr = request.getParameter("gender");
		String[] hobbies = request.getParameterValues("hobbies");
		
		int gender = 1;
		try {
			gender = Integer.parseInt(genderStr);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.printf("%s - %s - %s - %d - ", name, email, password, gender);
		
		for (int i = 0; i < hobbies.length; i++) {
			System.out.printf("%s - ", hobbies[i]);
		}
		System.out.println("");
		System.out.println("ContextPath: " + request.getContextPath());
	}
}
