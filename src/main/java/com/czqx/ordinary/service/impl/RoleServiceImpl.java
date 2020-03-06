package com.czqx.ordinary.service.impl;

import com.czqx.ordinary.domain.RoleDO;
import com.czqx.ordinary.mapper.RoleMapper;
import com.czqx.ordinary.service.RoleService;
import com.czqx.ordinary.utils.QueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;
    @Override
    public int insert(RoleDO roleDO) {
        return roleMapper.insert(roleDO);
    }

    @Override
    public List<RoleDO> getList(QueryUtil query) {
        return roleMapper.getList(query);
    }

    @Override
    public int getCount(QueryUtil query) {
        return roleMapper.getCount(query);
    }

    @Override
    public RoleDO get(long id) {
        return roleMapper.get(id);
    }

    @Override
    public int remove(long id) {
        return roleMapper.remove(id);
    }

    @Override
    public int update(RoleDO roleDO) {
        return roleMapper.update(roleDO);
    }
}
