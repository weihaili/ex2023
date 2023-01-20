package com.kkl.excerise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class ExceriseApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExceriseApplication.class, args);
    }

}
