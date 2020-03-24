package com.czqx.ordinary.service.impl;

import com.czqx.ordinary.domain.UserDO;
import com.czqx.ordinary.mapper.UserMapper;
import com.czqx.ordinary.service.UserService;
import com.czqx.utils.QueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public List<UserDO> getAll() {
        return userMapper.getAll();
    }

    @Override
    public int insert(UserDO userDO) {
        return userMapper.insert(userDO);
    }

    @Override
    public UserDO get(long id) {
        return userMapper.get(id);
    }

    @Override
    public int remove(long id) {
        return userMapper.remove(id);
    }

    @Override
    public List<UserDO> getList(QueryUtil query) {
        return userMapper.getList(query);
    }

    @Override
    public int getCount(QueryUtil query) {
        return userMapper.getCount(query);
    }

    @Override
    public int update(UserDO userDO) {
        return userMapper.update(userDO);
    }

    @Override
    public UserDO getByName(String name) {
        return userMapper.getByName(name);
    }
}
