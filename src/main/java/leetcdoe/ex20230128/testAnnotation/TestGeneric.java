package leetcdoe.ex20230128.testAnnotation;

import io.swagger.models.auth.In;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TestGeneric<T> {

    public static <T> T add(T x, T y) {
        return y;
    }

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<Integer>();
        List<String> strList = new ArrayList<String>();
        System.out.println(integerList.getClass() == strList.getClass());

        List<? extends Number> numList = new ArrayList<Integer>();

        List<? super Number> numList2 = new ArrayList<Number>();
        numList2.add(1);
        numList2.add(1.3f);
    }

    public static <S> S show(S name) {
        System.out.println();
        return name;
    }
}
