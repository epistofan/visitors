package lv.visitorreg.visitors.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomePageController {



    @PostMapping("/home")
    public String homePage(){

        System.out.println("Welcome to homepage");



        return "home";
    }




}
