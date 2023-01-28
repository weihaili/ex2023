package leetcdoe.ex20230128.testAnnotation.sdaopredis;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {


    @RequestMapping("/add")
    @NoRepeatSubmit(lockTime = 10)
    public Object addProduct(String product) {
        return "success!";
    }
}
