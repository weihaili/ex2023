package leetcdoe.creaetpattern.generalfactorymodel;

public enum SendType {

    MAIL("mail"),SMS("sms"),MSG("msg");

    SendType(String type) {
        this.type = type;
    }

    private String type;


}
