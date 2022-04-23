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

}
