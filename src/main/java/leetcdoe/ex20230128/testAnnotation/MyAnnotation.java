package leetcdoe.ex20230128.testAnnotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyAnnotation {
    String mame() default "myAnnotation name";

    String value() default "myAnnotation value";
}
