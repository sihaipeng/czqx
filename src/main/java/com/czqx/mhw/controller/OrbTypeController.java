package com.czqx.mhw.controller;

import com.czqx.mhw.domain.OrbTypeDO;
import com.czqx.mhw.service.OrbTypeService;
import com.czqx.ordinary.exception.BaseException;
import com.czqx.utils.PageUtil;
import com.czqx.utils.QueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/mhw/orbType")
public class OrbTypeController {

    @Autowired
    OrbTypeService orbTypeService;

    @GetMapping("/list")
    public PageUtil getList(@RequestParam Map<String,Object> map){
        QueryUtil query = new QueryUtil(map);
        List<OrbTypeDO> list = orbTypeService.getList(query);
        int count = orbTypeService.count(query);
        return new PageUtil(list,count);
    }

    @PostMapping("/insert")
    public boolean insert(OrbTypeDO orbTypeDO){
        if (orbTypeService.insert(orbTypeDO) < 0){
            throw new BaseException();
        }
        return true;
    }

}
