package lv.visitorreg.visitors.Controllers;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lv.visitorreg.visitors.SecurityFilters.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomePageController {


    @Autowired
    TokenManager tokenManager;

    @PostMapping("/home")
    @ResponseBody
    public String homePage(){



        return "http://192.168.40.100:8888/home";
    }

    @GetMapping("/home")
    public String getHome(@RequestParam String token, Map<String, Object> model){

        System.out.print(token);

        HashMap userInfo = tokenManager.parseToken(token);

       /*final Claims claims = Jwts.parser().setSigningKey("uldis").parseClaimsJws(token).getBody();

        Map<String, String> newMap = (Map<String, String>) claims.get("user");

        newMap.get("password");*/

        System.out.print(userInfo.get("password"));


        System.out.println("Welcome to homepage,  user id ");

        model.put("token", token);

        return "home";
    }

}
