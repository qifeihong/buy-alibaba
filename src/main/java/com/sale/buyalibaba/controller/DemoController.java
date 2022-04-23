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

    @GetMapping("/hello")
    public String hello(){
        return "颜儿,万丈高楼的第一块基石已经搭建成功.......后续功能,敬请期待,但今天请早点睡觉,因为现在已经是:"+DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss");
    }

    @GetMapping("/test1")
    public String test1(){
        String remark= "<html>\n" +
                "\n" +
                "<body>\n" +
                "\n" +
                "<h1>This is heading 1</h1>\n" +
                "<h2>This is heading 2</h2>\n" +
                "<h3>This is heading 3</h3>\n" +
                "<h4>This is heading 4</h4>\n" +
                "<h5>This is heading 5</h5>\n" +
                "<h6>This is heading 6</h6>\n" +
                "\n" +
                "<p>请仅仅把标题标签用于标题文本。不要仅仅为了产生粗体文本而使用它们。请使用其它标签或 CSS 代替。</p>\n" +
                "\n" +
                "</body>\n" +
                "</html>\n";
        return remark;
    }

}
