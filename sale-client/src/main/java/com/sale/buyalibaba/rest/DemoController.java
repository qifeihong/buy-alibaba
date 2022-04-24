package com.sale.buyalibaba.rest;

import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Auther: qfh
 * @Date: 2022/4/21 17:02
 * @Description:
 */
@RestController
@Slf4j
public class DemoController {

//    @GetMapping("/hello")
//    public String hello(){
//        return "hello world";
//    }

    @GetMapping("/hello")
    public String test1(){
        log.info("打印日志>>>>>>>>>>>>>>>>>>>>>>>>>>");
        String date = DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss");
        String remark= "<html>\n" +
                "<body style=\"background-color:PowderBlue;\">\n" +
                "\n" +
                "<h1>颜儿,你还不睡觉!</h1>\n" +
                "\n" +
                "<h1><p style=\"font-family:verdana;color:red\">\n" +
                "这都几点了\uD83D\uDE20</p></h1>\n" +
                "\n" +
                "<h1><p style=\"font-family:verdana;color:green\">\n" +
                "" + date + "</p></h1>\n" +
                "\n" +
                "<p style=\"font-size:30px\">这是该网站的第一行代码,后续功能,不断完善,敬请期待!</p>\n" +
                "</body>\n" +
                "</html>\n";

        try {
            int i = 1 / 0;
        } catch (Exception e) {
            log.error("打印错误:", e);
        }
        return remark;
    }

}
