package ex20230111.createpattern;

import leetcdoe.creaetpattern.prototypemodel.Sheep;
import org.junit.jupiter.api.Test;

public class SheepTest {

    @Test
    public void testPrototypeClone() {
        Sheep slowSheep = new Sheep("slowly sheep", 10, "white");
        Sheep pleasantSheep = new Sheep("pleasant sheep", 5, "white");

        Sheep slowSheep1 = (Sheep)slowSheep.clone();
        Sheep slowSheep2 = (Sheep)slowSheep.clone();
        Sheep slowSheep3 = (Sheep)slowSheep.clone();

        System.out.println(slowSheep == slowSheep1);
        System.out.println(slowSheep == slowSheep2);
        System.out.println(slowSheep == slowSheep3);
    }
}
