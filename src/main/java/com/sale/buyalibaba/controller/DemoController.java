package com.sale.buyalibaba.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: qfh
 * @Date: 2022/4/21 17:02
 * @Description:
 */
@RestController
public class DemoController {

    @GetMapping("/hello")
    public String hello(){
        return "hello world" ;
    }

}
