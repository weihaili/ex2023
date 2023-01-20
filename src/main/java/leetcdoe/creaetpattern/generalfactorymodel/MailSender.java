package leetcdoe.creaetpattern.generalfactorymodel;

public class MailSender implements Sender {
    @Override
    public void send() {
        System.out.println("I am mailSender...");
    }
}
