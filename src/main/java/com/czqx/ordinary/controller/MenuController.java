package com.czqx.ordinary.controller;

import com.czqx.ordinary.domain.MenuDO;
import com.czqx.ordinary.exception.BaseException;
import com.czqx.ordinary.service.MenuService;
import com.czqx.ordinary.utils.PageUtil;
import com.czqx.ordinary.utils.QueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sys/menu")
public class MenuController {

    @Autowired
    MenuService menuService;

    @GetMapping("/list")
    public PageUtil getList(@RequestParam Map<String,Object> map){
        QueryUtil query = new QueryUtil(map);
        List<MenuDO> list = menuService.getList(query);
        int count = menuService.getCount(query);
        return new PageUtil(list,count);
    }

    @GetMapping("/get/{id}")
    public MenuDO getById(@PathVariable("id") long id){
        return menuService.get(id);
    }

    @PostMapping("/insert")
    public boolean insert(MenuDO menuDO){
        if (menuService.insert(menuDO) < 0){
            throw new BaseException();
        }
        return true;
    }

    @PostMapping("/remove/{id}")
    public boolean remove(@PathVariable("id") long id){
        if (menuService.remove(id) < 0){
            throw new BaseException();
        }
        return true;
    }

    @PostMapping("/update")
    public boolean update(MenuDO menuDO){
        if (menuService.update(menuDO) < 0){
            throw new BaseException();
        }
        return true;
    }
}
