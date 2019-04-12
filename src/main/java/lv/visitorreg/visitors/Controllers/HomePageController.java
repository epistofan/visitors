package lv.visitorreg.visitors.Controllers;


import lv.visitorreg.visitors.Domain.LoginUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

@Controller
public class HomePageController {



    @PostMapping("/home")
    public String homePage(ServletRequest servletRequest){


        HttpServletRequest request = (HttpServletRequest) servletRequest;

        LoginUser loginUser = (LoginUser) request.getAttribute("UserID");

        int userId = loginUser.getUserId();

        System.out.println("Welcome to homepage "+ userId);



        return "home";
    }




}
