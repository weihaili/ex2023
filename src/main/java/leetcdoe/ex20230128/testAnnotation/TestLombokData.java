package leetcdoe.ex20230128.testAnnotation;

import lombok.Data;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class TestLombokData {
    public static void main(String[] args) {
        TestLombokData demo = new TestLombokData();
        demo.testRetentionRt();

        demo.testRetentionClass();

        demo.testRetentionSource();

    }

    private void testRetentionRt() {
        try {
            Class<?> cupClz = Class.forName("leetcdoe.ex20230128.testAnnotation.CupRuntime");
            Annotation[] ans = cupClz.getDeclaredAnnotations();
            for (Annotation an : ans) {
                System.out.println(an.annotationType().getTypeName());
            }
            Field[] fields = cupClz.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(FieldAnnotation.class)) {
                    FieldAnnotation fieldAt = field.getAnnotation(FieldAnnotation.class);
                    System.out.println(fieldAt.annotationType().getTypeName());
                }
            }

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void testRetentionClass() {
        try {
            Class<?> cupClz = Class.forName("leetcdoe.ex20230128.testAnnotation.CupClass");
            Annotation[] ans = cupClz.getAnnotations();
            for (Annotation an : ans) {
                System.out.println(an.annotationType().getTypeName());
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void testRetentionSource() {
        try {
            Class<?> cupClz = Class.forName("leetcdoe.ex20230128.testAnnotation.CupSource");
            Annotation[] ans = cupClz.getAnnotations();
            for (Annotation an : ans) {
                System.out.println(an.annotationType().getTypeName());
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}

@NoRepeatableRuntime
@Data
class CupRuntime{
    @FieldAnnotation
    private String name;

    @FieldAnnotation
    private String addr;


}

@NoRepeatableClass
class CupClass{

}

@NoRepeatableSource
class CupSource{

}




