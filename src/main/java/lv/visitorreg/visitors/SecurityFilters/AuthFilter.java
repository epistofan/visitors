package lv.visitorreg.visitors.SecurityFilters;

import lv.visitorreg.visitors.DAL.UserCheckRepo;

import lv.visitorreg.visitors.Domain.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/login")
public class AuthFilter implements Filter {

    @Autowired
    UserCheckRepo userCheckRepo;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        RequestDispatcher rdObj = null;
        System.out.println("**");
        System.out.println("Auth filter");
        System.out.println("**");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;



        System.out.println(servletRequest.getParameter("username"));
        System.out.println(servletRequest.getParameter("psw"));

        LoginUser loginUser;
        loginUser = userCheckRepo.checkLoginUser(servletRequest.getParameter("username"),servletRequest.getParameter("psw"));
        if(loginUser == null) {
            rdObj = servletRequest.getRequestDispatcher("/login");


            rdObj.forward(servletRequest, servletResponse);

       }else{

            loginUser.setUserId(loginUser.getUserId());
            loginUser.setUsername(servletRequest.getParameter("username"));
            request.getSession().setAttribute("UserID", loginUser);
            request.getSession().setMaxInactiveInterval(-1);
            rdObj = servletRequest.getRequestDispatcher("/index");


            rdObj.forward(servletRequest, servletResponse);

        }
    }

    @Override
    public void destroy() {

    }
}
