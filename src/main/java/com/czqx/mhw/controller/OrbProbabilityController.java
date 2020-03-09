package com.czqx.mhw.controller;

import com.czqx.mhw.domain.OrbProbabilityDO;
import com.czqx.mhw.service.OrbProbabilityService;
import com.czqx.ordinary.exception.BaseException;
import com.czqx.utils.PageUtil;
import com.czqx.utils.QueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/mhw/orbProbability")
public class OrbProbabilityController {

    @Autowired
    OrbProbabilityService orbProbabilityService;

    @GetMapping("/list")
    public PageUtil getList(@RequestParam Map<String,Object> map){
        QueryUtil query = new QueryUtil(map);
        List<OrbProbabilityDO> list = orbProbabilityService.getList(query);
        int count = orbProbabilityService.count(query);
        return new PageUtil(list,count);
    }

    @PostMapping("/insert")
    public boolean insert(OrbProbabilityDO orbProbabilityDO){
        if (orbProbabilityService.insert(orbProbabilityDO) < 0){
            throw new BaseException();
        }
        return true;
    }
}
