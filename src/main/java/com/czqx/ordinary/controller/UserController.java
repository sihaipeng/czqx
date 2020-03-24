package com.czqx.ordinary.controller;

import com.czqx.ordinary.domain.UserDO;
import com.czqx.ordinary.exception.BaseException;
import com.czqx.ordinary.service.UserService;
import com.czqx.utils.PageUtil;
import com.czqx.utils.QueryUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/sys/user")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/list")
    @RequiresPermissions("sys:user")
    public PageUtil getList(@RequestParam Map<String,Object> map){
        QueryUtil query = new QueryUtil(map);
        List<UserDO> list = userService.getList(query);
        int count = userService.getCount(query);
        return new PageUtil(list,count);
    }

    @GetMapping("/getAll")
    public List<UserDO> getAll(){
        return userService.getAll();
    }

    @PostMapping("/insert")
    public boolean insert(UserDO userDO){
        if (userService.insert(userDO) < 0){
            throw new BaseException("添加失败");
        }
        return true;
    }


    @GetMapping("/get/{id}")
    public UserDO getById(@PathVariable("id") long id){
        return userService.get(id);
    }

    @PostMapping("/update")
    public boolean update(UserDO userDO){
        if (userService.update(userDO) < 0){
            throw new BaseException();
        }
        return true;
    }

    @PostMapping("/remove/{id}")
    public boolean remove(@PathVariable("id") long id){
        if (userService.remove(id) < 0){
            throw new BaseException();
        }
        return true;
    }

}
