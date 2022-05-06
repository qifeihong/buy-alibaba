package com.sale.buyalibaba.controller;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sale.buyalibaba.po.BankBigData;
import com.sale.buyalibaba.service.BankBigDataService;
import com.sale.buyalibaba.utils.JsonTransferUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: qfh
 * @Date: 2022/4/21 17:02
 * @Description:
 */
@RestController
@Slf4j
@Configuration
public class CheckController {

    @Value("${demo.key}")
    private String demoKey;

    @Resource
    private BankBigDataService bankBigDataService;

    @ResponseBody
    @GetMapping("/check")
    public String check() {
        log.info("获取Apollo配置信息:{}", demoKey);
        List<Long> ids = new ArrayList<>();
        long a = (long) (Math.random() * 150000) + 10211;
        ids.add(a);
        QueryWrapper<BankBigData> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().in(BankBigData::getId, ids);
        List<BankBigData> list = bankBigDataService.list(queryWrapper);
        for (BankBigData data : list) {
            data.setCreateName(demoKey);
        }
        String originJson = JSONUtil.toJsonStr(list);
        System.out.println(originJson);
        String formatJson = JsonTransferUtil.formatJson(originJson);
        System.out.println(formatJson);
        return formatJson;
    }

}
