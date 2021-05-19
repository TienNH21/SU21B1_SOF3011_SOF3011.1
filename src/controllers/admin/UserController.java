package controllers.admin;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet({
	"/users/",
	"/users/create",
	"/users/store",
	"/users/edit",
	"/users/update",
	"/users/delete"
})
public class UserController extends HttpServlet{

}
