package com.czqx.ordinary.controller;

import com.czqx.ordinary.domain.UserDO;
import com.czqx.ordinary.exception.BaseException;
import com.czqx.ordinary.service.UserService;
import com.czqx.ordinary.shiro.JWTUtil;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/sys")
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public String doLogin(UserDO userDO){
        UserDO user = userService.getByName(userDO.getName());
        if (null == user){
            throw new BaseException();
        }
        if (!user.getPassword().equals(userDO.getPassword())){
            throw new BaseException();
        }
        return JWTUtil.sign(user.getId(), user.getPassword());
    }
}
