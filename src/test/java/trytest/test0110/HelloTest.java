package trytest.test0110;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloTest {

    @Test
    public void testShow() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Hello hello = (Hello)ac.getBean("hello");

        Hello hello2 = (Hello)ac.getBean("hello");
        hello.show();

        System.out.println(hello == hello2);
    }
}
