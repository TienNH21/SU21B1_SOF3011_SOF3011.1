package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;

@WebServlet("/login")
public class HelloServlet extends HttpServlet {
    public HelloServlet() {
        super();
    }

    @Override
    public void service(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
    	// Ghi log

    	System.out.println("HelloServlet@service()");
    	super.service(request, response);
    }

	protected void doGet(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
//		response.getWriter().append("Hello Poly");
		String username = request.getParameter("username");
		
		String tuoiStr = request.getParameter("tuoi"); 
		int tuoi = tuoiStr == null || tuoiStr.length() == 0 ? 18 :
			Integer.parseInt(tuoiStr);

		String name = username == null ? "SOF3011.1" : username;
		request.setAttribute("myName", name);
		request.getContextPath();
		
		request.getRequestDispatcher("/views/welcome.jsp")
			.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username + "---" + password);
		
//		User user = new User();
//		user.setName( request.getParameter("name") );
		doGet(request, response);
	}

	public void init()
	{
		System.out.println("HelloServlet@init");
	}
	
	public void destroy()
	{
		System.out.println("HelloServlet@destroy");
	}
}
