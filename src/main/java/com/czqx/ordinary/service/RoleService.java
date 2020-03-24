package com.czqx.ordinary.service;

import com.czqx.ordinary.domain.RoleDO;
import com.czqx.utils.QueryUtil;

import java.util.List;

public interface RoleService {
    int insert(RoleDO roleDO);
    List<RoleDO> getList(QueryUtil query);
    int getCount(QueryUtil query);
    RoleDO get(long id);
    int remove(long id);
    int update(RoleDO roleDO);
}
