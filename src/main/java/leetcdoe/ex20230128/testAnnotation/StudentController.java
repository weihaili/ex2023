package leetcdoe.ex20230128.testAnnotation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Authority(roles = {Role.STUDENT})
    @GetMapping("/test")
    public String hello() {
        return "how are you student?";
    }
}
