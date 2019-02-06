package lv.visitorreg.visitors.Controllers;


import lv.visitorreg.visitors.Domain.Visitor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Controller
public class LoginPageController {

    @GetMapping("/")
    public String login1(Map<String, Object> model) {


        LocalDate localDate = LocalDate.now();

        System.out.println("hello");
        System.out.println(localDate.toString());


        model.put("date", localDate);

        return "login";
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String userName, String passWord) {


        System.out.println("hello2");


        return "login";
    }




}
