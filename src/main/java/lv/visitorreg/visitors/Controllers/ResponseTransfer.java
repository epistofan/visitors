package lv.visitorreg.visitors.Controllers;

public class ResponseTransfer {



    private String response;

    public ResponseTransfer(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
