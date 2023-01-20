package leetcdoe.creaetpattern.generalfactorymodel;

public class SmsSender implements Sender{
    @Override
    public void send() {
        System.out.println("I am SmsSender");
    }
}
