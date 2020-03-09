package com.czqx.mhw.controller;

import com.czqx.mhw.domain.OrbRankDO;
import com.czqx.mhw.service.OrbRankService;
import com.czqx.ordinary.exception.BaseException;
import com.czqx.utils.PageUtil;
import com.czqx.utils.QueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/mhw/orbRank")
public class OrbRankController {

    @Autowired
    OrbRankService orbRankService;

    @GetMapping("/list")
    public PageUtil getList(@RequestParam Map<String,Object> map){
        QueryUtil query = new QueryUtil(map);
        List<OrbRankDO> list = orbRankService.getList(query);
        int count = orbRankService.count(query);
        return new PageUtil(list,count);
    }

    @PostMapping("/insert")
    public boolean insert(OrbRankDO orbRankDO){
        if (orbRankService.insert(orbRankDO) < 0){
            throw new BaseException();
        }
        return true;
    }
}
