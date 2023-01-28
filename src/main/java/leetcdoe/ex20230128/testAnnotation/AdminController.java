package leetcdoe.ex20230128.testAnnotation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@Authority(roles = {Role.ADMIN, Role.SADMIN})
public class AdminController {

    @GetMapping("/hello")
    public String hello() {
        return "how are you?";
    }
}
