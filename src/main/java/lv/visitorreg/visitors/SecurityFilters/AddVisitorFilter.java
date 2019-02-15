package lv.visitorreg.visitors.SecurityFilters;

import lv.visitorreg.visitors.Domain.LoginUser;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/addVisitor")
public class AddVisitorFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        RequestDispatcher rdObj = null;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        LoginUser loginUser;
        loginUser = (LoginUser) request.getSession().getAttribute("UserID");

        System.out.println("*");
        System.out.println("addVisitor filter");
        System.out.println("*");
        if (loginUser!=null) {
            System.out.println("session is active");
            rdObj = servletRequest.getRequestDispatcher("/addVisitor");

            rdObj.forward(servletRequest, servletResponse);
        } else {
            System.out.println("session ended");
            rdObj = servletRequest.getRequestDispatcher("/");

            rdObj.forward(servletRequest, servletResponse);
        }


    }

    @Override
    public void destroy() {

    }
}
