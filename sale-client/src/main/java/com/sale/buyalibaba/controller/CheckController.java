package com.sale.buyalibaba.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sale.buyalibaba.po.BankBigData;
import com.sale.buyalibaba.service.BankBigDataService;
import lombok.extern.slf4j.Slf4j;
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
public class CheckController {

    @Resource
    private BankBigDataService bankBigDataService;

    @ResponseBody
    @GetMapping("/check")
    public List<BankBigData> check() {
        List<Long> ids = new ArrayList<>();
        long a = (long) (Math.random()*150000)+10211;
        ids.add(a);
        QueryWrapper<BankBigData> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().in(BankBigData::getId, ids);
        List<BankBigData> list = bankBigDataService.list(queryWrapper);
        return list;
    }

}
