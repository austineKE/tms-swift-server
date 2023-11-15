package co.sys.procurement.tmsswiftserver.dto;

public class Email {
    private String to;
    private String body;

    public Email(String to, String body){
        this.to=to;
        this.body=body;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
