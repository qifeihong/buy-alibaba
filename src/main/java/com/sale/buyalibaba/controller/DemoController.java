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

//    @GetMapping("/hello")
//    public String hello(){
//        return "hello world";
//    }

    @GetMapping("/hello")
    public String test1(){
        String date = DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss");
        String remark= "<html>\n" +
                "<body style=\"background-color:PowderBlue;\">\n" +
                "\n" +
                "<h1>颜儿,你还不睡觉!</h1>\n" +
                "\n" +
                "<p style=\"font-family:verdana;color:red\">\n" +
                "这都几点了\uD83D\uDE20</p>\n" +
                "\n" +
                "<p style=\"font-family:verdana;color:green\">\n" +
                ""+date+"</p>\n" +
                "\n" +
                "<p style=\"font-size:30px\">这是该网站的第一行代码,后续功能,不断完善,敬请期待!</p>\n" +
                "</body>\n" +
                "</html>\n";
        return remark;
    }

}
