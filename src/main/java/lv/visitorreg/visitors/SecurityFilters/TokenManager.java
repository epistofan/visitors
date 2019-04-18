package lv.visitorreg.visitors.SecurityFilters;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lv.visitorreg.visitors.Domain.AccessToken;
import lv.visitorreg.visitors.Domain.LoginUser;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class TokenManager {

protected Double secretDigit = 0.2545541578;


    public String generateToken(LoginUser loginUser){

        String jwtToken = "";


        //secretDigit = Math.random();

        String secret  = String.valueOf(secretDigit);

        jwtToken = Jwts.builder().setSubject("test").claim("user", loginUser).setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, secret).compact();

            System.out.print(secret);



        return jwtToken;
    }

        public HashMap parseToken(String token){



            String secretForDecrypt = String.valueOf(secretDigit);



            final Claims claims = Jwts.parser().setSigningKey(secretForDecrypt).parseClaimsJws(token).getBody();

            HashMap userInfoMap = (HashMap) claims.get("user");

        return userInfoMap;
}




}
