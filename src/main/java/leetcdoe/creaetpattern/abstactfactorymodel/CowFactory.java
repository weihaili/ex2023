package leetcdoe.creaetpattern.abstactfactorymodel;

public class CowFactory implements IFactory {
    @Override
    public Food create() {
        return new Cow();
    }
}
