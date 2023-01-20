package leetcdoe.creaetpattern.generalfactorymodel;

import java.util.Objects;

public class SendFactory {

    public Sender produce(SendType type) {
        if (Objects.isNull(type)) {
            return null;
        }
        switch (type) {
            case SMS:
                return new SmsSender();
            case MAIL:
                return new MailSender();
            case MSG:
                return new MsgSender();
            default:
                System.out.println("please match the unsupported type.");
                return null;
        }
    }

}
