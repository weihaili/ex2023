package leetcdoe.creaetpattern.singletonmodel;

/**
 * hungry model
 */
public class CupForHungryModel {

    private CupForHungryModel() {}

    private static CupForHungryModel instance = new CupForHungryModel();

    public static CupForHungryModel getInstance() {
        return instance;
    }


}