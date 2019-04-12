package lv.visitorreg.visitors.Domain;

import org.springframework.stereotype.Component;

@Component
public class AccessToken {

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
