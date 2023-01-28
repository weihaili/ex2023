package leetcdoe.ex20230128.testAnnotation.sdaopredis;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface NoRepeatSubmit {

    int lockTime() default 5;
}
