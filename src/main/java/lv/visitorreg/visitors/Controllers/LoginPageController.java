package lv.visitorreg.visitors.Controllers;


import lv.visitorreg.visitors.Domain.AccessToken;
import lv.visitorreg.visitors.Domain.LoginUser;
import lv.visitorreg.visitors.Domain.Visitor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@Controller
public class LoginPageController {

    @GetMapping("/")
    public String login1(HttpSession httpSession, Map<String, Object> model) {
    httpSession.invalidate();

        String jwtToken = "";
        LocalDate localDate = LocalDate.now();

        System.out.println("hello-LoginController");
        System.out.println(localDate.toString());



        jwtToken = Jwts.builder().setSubject("test").claim("roles", "user").setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "uldis").compact();

        model.put("date", localDate);



        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public AccessToken login(@RequestBody LoginUser loginUser) {

        System.out.print(loginUser.getUsername());
        System.out.print(loginUser.getPassword());


        String jwtToken = "";
        jwtToken = Jwts.builder().setSubject("test").claim("roles", "user").setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "uldis").compact();

        System.out.println("hello2-LoginController");
        AccessToken accessToken = new AccessToken();

        accessToken.setToken(jwtToken);

        return accessToken;
    }




}
