package com.czqx.ordinary.controller;

import com.czqx.ordinary.domain.MenuDO;
import com.czqx.ordinary.exception.BaseException;
import com.czqx.ordinary.service.MenuService;
import com.czqx.utils.PageUtil;
import com.czqx.utils.QueryUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
    @RequiresPermissions("sys:menu:list")
    public PageUtil getList(@RequestParam Map<String,Object> map){
        QueryUtil query = new QueryUtil(map);
        List<MenuDO> list = menuService.getList(query);
        int count = menuService.getCount(query);
        return new PageUtil(list,count);
    }

    @GetMapping("/get/{id}")
    @RequiresPermissions("sys:menu:get")
    public MenuDO getById(@PathVariable("id") long id){
        return menuService.get(id);
    }

    @PostMapping("/insert")
    @RequiresPermissions("sys:menu:insert")
    public boolean insert(MenuDO menuDO){
        if (menuService.insert(menuDO) < 0){
            throw new BaseException();
        }
        return true;
    }

    @PostMapping("/remove/{id}")
    @RequiresPermissions("sys:menu:remove")
    public boolean remove(@PathVariable("id") long id){
        if (menuService.remove(id) < 0){
            throw new BaseException();
        }
        return true;
    }

    @PostMapping("/update")
    @RequiresPermissions("sys:menu:update")
    public boolean update(MenuDO menuDO){
        if (menuService.update(menuDO) < 0){
            throw new BaseException();
        }
        return true;
    }

    @GetMapping("/list/{pId}")
    public List<MenuDO> getAllByPId(@PathVariable("pId") long pId){
        return menuService.getAllByPId(pId);
    }

    @GetMapping("/getAll")
    public List<MenuDO> getAll(){
        return menuService.getAll();
    }
}
