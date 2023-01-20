package ex20230111.createpattern;

import leetcdoe.creaetpattern.generalfactorymodel.SendFactory;
import leetcdoe.creaetpattern.generalfactorymodel.SendType;
import leetcdoe.creaetpattern.generalfactorymodel.Sender;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class SendFactoryTest {

    private SendFactory factory = new SendFactory();

    @Test
    public void testSmsSenderCreate() {
        Sender smsSend = factory.produce(SendType.SMS);
        smsSend.send();
    }

    @Test
    public void testMailSenderCreate() {
        Sender mailSender = factory.produce(SendType.MAIL);
        mailSender.send();
    }

    @Test
    public void testMsgSenderCreate() {
        Sender msgSender = factory.produce(SendType.MSG);
        msgSender.send();
    }

    @Test
    public void testUnsupportedSendTypeCreate() {

        Sender nullSender = factory.produce(null);
        if (Objects.isNull(nullSender)) {
            System.out.println("unsupport send type");
            return;
        }
        nullSender.send();
    }
}
