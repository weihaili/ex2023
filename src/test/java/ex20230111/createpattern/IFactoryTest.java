package ex20230111.createpattern;

import leetcdoe.creaetpattern.abstactfactorymodel.*;
import org.junit.jupiter.api.Test;

public class IFactoryTest {

    @Test
    public void testManCreate() {
        IFactory factory = new ManFactory();
        Food man = factory.create();
        man.eat();
    }

    @Test
    public void testCowCreate() {
        IFactory factory = new CowFactory();
        Food cow = factory.create();
        cow.eat();
    }

    @Test
    public void testMosquitoCreate() {
        IFactory factory = new MosquitoFactory();
        Food mosquito = factory.create();
        mosquito.eat();
    }
}
