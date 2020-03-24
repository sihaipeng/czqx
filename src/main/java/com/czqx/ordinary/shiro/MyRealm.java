package com.czqx.ordinary.shiro;

import com.czqx.ordinary.domain.MenuDO;
import com.czqx.ordinary.domain.RoleDO;
import com.czqx.ordinary.domain.UserDO;
import com.czqx.ordinary.mapper.MenuMapper;
import com.czqx.ordinary.mapper.RoleMapper;
import com.czqx.ordinary.mapper.UserMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MyRealm extends AuthorizingRealm {

    private static final Logger LOGGER = LogManager.getLogger(MyRealm.class);

    @Autowired
    UserMapper userMapper;
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    MenuMapper menuMapper;
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("进入shiro授权");
        Long id = JWTUtil.getId(principals.toString());
        long roleId = userMapper.getRole(id);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        Set<String> permSet = new HashSet<>();
        List<Long> menuIds = menuMapper.getMenus(roleId);
        for (long menuId : menuIds){
            String perm = menuMapper.get(menuId).getPerm();
            permSet.add(perm);
        }
        simpleAuthorizationInfo.setStringPermissions(permSet);
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        System.out.println("进入shiro认证");
        String token = (String) auth.getCredentials();
        // 解密获得username，用于和数据库进行对比
        Long id = JWTUtil.getId(token);
        if (id == null) {
            throw new AuthenticationException("token invalid");
        }
        UserDO userDO = userMapper.get(id);
        if (userDO == null) {
            throw new AuthenticationException("User didn't existed!");
        }

        if (! JWTUtil.verify(token, id, userDO.getPassword())) {
            throw new AuthenticationException("Username or password error");
        }

        return new SimpleAuthenticationInfo(token, token, "my_realm");
    }
}
