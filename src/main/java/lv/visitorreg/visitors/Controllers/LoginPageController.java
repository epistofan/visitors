package lv.visitorreg.visitors.Controllers;


import lv.visitorreg.visitors.DAL.UserCheckRepo;
import lv.visitorreg.visitors.Domain.AccessToken;
import lv.visitorreg.visitors.Domain.LoginUser;
import lv.visitorreg.visitors.SecurityFilters.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.Map;

@Controller
public class LoginPageController {

    @Autowired
    UserCheckRepo userCheckRepo;
    @Autowired
    TokenManager tokenManager;

    @GetMapping("/")
    public String login1() {


        LocalDate localDate = LocalDate.now();

        System.out.println("hello-LoginController");
        System.out.println(localDate.toString());


        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public AccessToken login(ServletRequest servletRequest) {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        request.getHeader("Authorization");

        String authHeader[] = request.getHeader("Authorization").split(",");

        LoginUser loginUser;

        loginUser = userCheckRepo.checkLoginUser(authHeader[0], authHeader[1]);
        if (loginUser == null) {
            AccessToken accessToken = new AccessToken();
            accessToken.setHomeUrl("http://192.168.40.100:8888");

            return accessToken;

        } else {



            System.out.println("hello2-LoginController");
            AccessToken accessToken = new AccessToken();

            accessToken.setToken(tokenManager.generateToken(loginUser));

            accessToken.setHomeUrl("http://192.168.40.100:8888/home");

            return accessToken;
        }

    }


}
