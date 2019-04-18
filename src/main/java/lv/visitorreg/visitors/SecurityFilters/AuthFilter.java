package lv.visitorreg.visitors.SecurityFilters;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lv.visitorreg.visitors.DAL.UserCheckRepo;

import lv.visitorreg.visitors.Domain.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

//@WebFilter(urlPatterns = "/login")
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

System.out.print(request.getHeader("Authorization"));

        String authHeader[] = request.getHeader("Authorization").split(",");

        //System.out.println(servletRequest.getParameter("username"));
        //System.out.println(servletRequest.getParameter("psw"));

        LoginUser loginUser;

        loginUser = userCheckRepo.checkLoginUser(authHeader[0], authHeader[1]);

        if(loginUser == null) {
            rdObj = servletRequest.getRequestDispatcher("/login");


            rdObj.forward(servletRequest, servletResponse);

       }else{
            System.out.print("accepted");


            String token = Jwts.builder().setSubject("test").claim("roles", "loginUser").setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "uldis").compact();


            servletRequest.setAttribute("token", token);
            servletRequest.setAttribute("UserID", loginUser);

            rdObj = servletRequest.getRequestDispatcher("/home");


            rdObj.forward(servletRequest, servletResponse);

        }
    }

    @Override
    public void destroy() {

    }
}
