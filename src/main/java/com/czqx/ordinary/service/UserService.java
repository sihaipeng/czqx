package com.czqx.ordinary.service;

import com.czqx.ordinary.domain.UserDO;
import com.czqx.utils.QueryUtil;

import java.util.List;

public interface UserService {
    List<UserDO> getAll();
    int insert(UserDO userDO);
    UserDO get(long id);
    int remove(long id);
    List<UserDO> getList(QueryUtil query);
    int getCount(QueryUtil query);
    int update(UserDO userDO);

    UserDO getByName(String name);
}
