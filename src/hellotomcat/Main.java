package hellotomcat;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class Main
 */
@WebFilter("/*")
public class Main implements Filter {

	/**
	 * Default constructor.
	 */
	public Main() {
		System.out.println("Main:	" + this);
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("destroy:	" + this);
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			response.getWriter().append("Served at: ").append(request.getServletContext().getContextPath());
		} catch (Exception e) {
			e.printStackTrace();
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("init:	" + fConfig);
	}

}
