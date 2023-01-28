package leetcdoe.ex20230128.testAnnotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ConstructorAnnotaion {
    String constructorName() default "";

    String remark() default "contructor";
}
