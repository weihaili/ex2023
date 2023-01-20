package ex20230111.createpattern;

import leetcdoe.creaetpattern.multifactorymethodmodel.Fly;
import leetcdoe.creaetpattern.multifactorymethodmodel.FlyFactory;
import org.junit.jupiter.api.Test;

public class FlyFactoryTest {

    private FlyFactory factory = new FlyFactory();

    @Test
    public void testPlaneCreate() {
        Fly fly = factory.producePlane();
        fly.flyTo();
    }

    @Test
    public void testUfoCreate() {
        Fly fly = factory.produceUfo();
        fly.flyTo();
    }

    @Test
    public void testSuperManCreate() {
        Fly fly = factory.produceSuperMan();
        fly.flyTo();
    }
}
