package leetcdoe.creaetpattern.staticfactorymethodmodel;

public class HolidayFactory {

    public static Holiday produceSpringFestival() {
        return new SpringFestival();
    }

    public static Holiday produceChildrensDay() {
        return new ChildrensDay();
    }

    public static Holiday produceDragonBoatFestival() {
        return new DragonBoatFestival();
    }
}
