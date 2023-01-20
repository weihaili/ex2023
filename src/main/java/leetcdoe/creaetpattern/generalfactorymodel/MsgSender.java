package leetcdoe.creaetpattern.generalfactorymodel;

public class MsgSender implements Sender {
    @Override
    public void send() {
        System.out.println("I am MsgSender...");
    }
}
