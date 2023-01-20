package com.aismall.testaop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HellowController {

    @RequestMapping("/helloAop")
    public Object hello() {
        return "hellow aop";
    }

    @RequestMapping("/helloError")
    public Object helloError() {
        return 1 / 0;
    }
}
