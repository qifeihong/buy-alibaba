package com.sale.buyalibaba.controller;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sale.buyalibaba.po.BankBigData;
import com.sale.buyalibaba.service.BankBigDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther: qfh
 * @Date: 2022/4/21 17:02
 * @Description:
 */
@RestController
@Slf4j
public class DemoController {

    @Resource
    private BankBigDataService bankBigDataService;




    @ResponseBody
    @GetMapping("/test1")
    public List<BankBigData> test2(){
        List<Long> ids = new ArrayList<>();
        ids.add(10211L);
        ids.add(10212L);
        QueryWrapper<BankBigData> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().in(BankBigData::getId, ids);
        List<BankBigData> list = bankBigDataService.list(queryWrapper);
        return list;
    }


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
