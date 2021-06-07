package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import entity.User;

@MultipartConfig()
@WebServlet({
	"/hello-upload"
})
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

//    	/Users/tiennh/eclipse-workspace/SOF3011.1/WebContent/storages
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

		if (request.getRequestURI().contains("hello-upload")) {
			this.upload(request, response);
		} else {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			System.out.println(username + "---" + password);

			doGet(request, response);
		}
	}
	
	private void upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String storagePath = "/Users/tiennh/eclipse-workspace/SOF3011.1/WebContent/storages/";
		try {
			Part uploadedFile = request.getPart("upload_file");
			
			String savedFilePath = storagePath + uploadedFile.getSubmittedFileName();
			uploadedFile.write(savedFilePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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
