package ex20230111.createpattern;

import leetcdoe.creaetpattern.staticfactorymethodmodel.Holiday;
import leetcdoe.creaetpattern.staticfactorymethodmodel.HolidayFactory;
import org.junit.jupiter.api.Test;

public class HolidayFactoryTest {

    @Test
    public void testSpringFestivalCreate() {
        Holiday holiday = HolidayFactory.produceSpringFestival();
        holiday.celebrate();
    }

    @Test
    public void testDragonFestivalCreate() {
        Holiday holiday = HolidayFactory.produceDragonBoatFestival();
        holiday.celebrate();
    }

    @Test
    public void testChildrenDayCreate() {
        Holiday holiday = HolidayFactory.produceChildrensDay();
        holiday.celebrate();
    }
}
