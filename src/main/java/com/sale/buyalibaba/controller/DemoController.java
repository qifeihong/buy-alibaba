package com.sale.buyalibaba.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Auther: qfh
 * @Date: 2022/4/21 17:02
 * @Description:
 */
@RestController
public class DemoController {

    @GetMapping("/hello")
    public String hello(){
        System.out.println(new Date());
        System.out.println("=====================return hello world=======================");
        return "hello world" ;
    }

}
