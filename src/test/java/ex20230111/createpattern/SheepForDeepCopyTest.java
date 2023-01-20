package ex20230111.createpattern;

import leetcdoe.creaetpattern.prototypemodel.SheepForDeepCopy;
import org.junit.jupiter.api.Test;

public class SheepForDeepCopyTest {

    @Test
    public void testDeepCopy() {
        SheepForDeepCopy sheep = new SheepForDeepCopy("lazy sheep", 4, "white");
        SheepForDeepCopy msheep = new SheepForDeepCopy("beautiful sheep", 4, "white");
        sheep.setFriend(msheep);

        SheepForDeepCopy sheep1 = sheep.deepCopy();
        System.out.println(sheep);
        System.out.println(sheep1);

    }
}
