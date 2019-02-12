package lv.visitorreg.visitors;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/addVisitor")
public class Filter1 implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        RequestDispatcher rdObj = null;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        request.getSession().getAttribute("UserID");
        System.out.println("-");
        System.out.println("filter 1");
        System.out.println("-");
        if(request.getSession().getAttribute("UserID")== null) {
            rdObj = servletRequest.getRequestDispatcher("/login");

            rdObj.forward(servletRequest, servletResponse);
        }else {
            rdObj = servletRequest.getRequestDispatcher("/index");

            rdObj.forward(servletRequest, servletResponse);
        }





    }

    @Override
    public void destroy() {

    }
}
