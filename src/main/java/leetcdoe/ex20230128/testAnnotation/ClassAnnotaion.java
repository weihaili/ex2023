package leetcdoe.ex20230128.testAnnotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface ClassAnnotaion {

    String name() default "test";

    String version() default "1.1.0";
}
