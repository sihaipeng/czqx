package com.czqx.ordinary.controller;

import com.czqx.ordinary.domain.UserDO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sys")
public class LoginController {

    @PostMapping("/login")
    public String doLogin(@RequestBody UserDO userDO){
        System.out.println(userDO.getName());
        return "success";
    }
}
