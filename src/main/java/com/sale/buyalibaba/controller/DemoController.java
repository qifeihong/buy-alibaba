package com.sale.buyalibaba.controller;

import cn.hutool.core.date.DateUtil;
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

    @GetMapping("/getTime")
    public String hello(){
        System.out.println("=====================return hello world=======================");
        return "当前时间V2:" + DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss");
    }

}
