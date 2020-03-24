package com.czqx.mhw.controller;

import com.czqx.mhw.domain.OrbDO;
import com.czqx.mhw.mapper.OrbMapper;
import com.czqx.mhw.service.OrbService;
import com.czqx.ordinary.exception.BaseException;
import com.czqx.utils.PageUtil;
import com.czqx.utils.QueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/mhw/orb")
@RestController
public class OrbController {

    @Autowired
    OrbService orbService;

    @Autowired
    OrbMapper orbMapper;

    @GetMapping("/list")
    public PageUtil getList(@RequestParam Map<String,Object> map){
        QueryUtil query = new QueryUtil(map);
        List<OrbDO> list = orbService.getList(query);
        int count = orbService.count(query);
        return new PageUtil(list,count);
    }

    @PostMapping("/insert")
    public boolean insert(OrbDO orbDO){
        if (orbService.insert(orbDO) < 0){
            throw new BaseException();
        }
        return true;
    }


}
