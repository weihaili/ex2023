package leetcdoe.creaetpattern.abstactfactorymodel;

public class MosquitoFactory implements IFactory {

    @Override
    public Food create() {
        return new Mosquito();
    }
}
