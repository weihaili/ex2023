package leetcdoe.creaetpattern.singletonmodel;

public class CupForLazyModel {

    private static CupForLazyModel instance;

    private CupForLazyModel(){};

    public static CupForLazyModel getInstance() {
        if (instance == null) {
            instance = new CupForLazyModel();
        }
        return instance;
    }
}
