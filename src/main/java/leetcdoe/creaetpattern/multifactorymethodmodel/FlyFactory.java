package leetcdoe.creaetpattern.multifactorymethodmodel;

public class FlyFactory {

    public Fly producePlane() {
        return new Plane();
    }

    public Fly produceUfo() {
        return new Ufo();
    }

    public Fly produceSuperMan() {
        return new SuperMan();
    }
}
