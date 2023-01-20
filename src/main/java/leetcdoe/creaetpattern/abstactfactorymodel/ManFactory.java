package leetcdoe.creaetpattern.abstactfactorymodel;

public class ManFactory implements IFactory {
    @Override
    public Food create() {
        return new Man();
    }
}
