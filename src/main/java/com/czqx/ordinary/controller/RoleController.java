package com.czqx.ordinary.controller;

import com.czqx.ordinary.domain.RoleDO;
import com.czqx.ordinary.exception.BaseException;
import com.czqx.ordinary.service.RoleService;
import com.czqx.utils.PageUtil;
import com.czqx.utils.QueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sys/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping("/list")
    public PageUtil getList(@RequestParam Map<String,Object> map){
        QueryUtil query = new QueryUtil(map);
        List<RoleDO> list = roleService.getList(query);
        int count = roleService.getCount(query);
        return new PageUtil(list,count);
    }

    @GetMapping("/get/{id}")
    public RoleDO getById(@PathVariable("id") long id){
        return roleService.get(id);
    }

    @PostMapping("/remove/{id}")
    public boolean remove(@PathVariable("id") long id){
        if (roleService.remove(id) < 0){
            throw new BaseException();
        }
        return true;
    }

    @PostMapping("/insert")
    public boolean insert(RoleDO roleDO){
        if (roleService.insert(roleDO) < 0){
            throw new BaseException();
        }
        return true;
    }

    @PostMapping("/update")
    public boolean update(RoleDO roleDO){
        if (roleService.update(roleDO) < 0){
            throw new BaseException();
        }
        return true;
    }
}
