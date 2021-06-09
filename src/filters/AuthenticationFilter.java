package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.User;

@WebFilter({
	"/users/*",
	"/admin/*"
})
public class AuthenticationFilter implements Filter {
	@Override
	public void doFilter(
		ServletRequest request,
		ServletResponse response,
		FilterChain chain
	) throws IOException, ServletException {
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpSession session = servletRequest.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			String location = servletRequest.getContextPath() + "/login";
			HttpServletResponse servletResponse = (HttpServletResponse) response;
			servletResponse.sendRedirect(location);
		} else {
			chain.doFilter(request, response);
		}
	}
}
