package br.com.fiap.store.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class ControllerFilter
 */
@WebFilter("/*")
public class ControllerFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public ControllerFilter() {
        super();
        // TODO Auto-generated constructor stub
    }	

	public void doFilter(ServletRequest requestServlet, ServletResponse responseServlet, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) requestServlet;
		HttpServletResponse response = (HttpServletResponse) responseServlet;
		
		HttpSession session = request.getSession();
		String url = request.getRequestURI();
		
		if(session.getAttribute("user") == null && !url.contains("home") && !url.contains("menu") && !url.endsWith("login")) {
			request.setAttribute("erro", "Entre com usuario e senha");
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
		else {
		
		chain.doFilter(request, response);
		}
	}


}
