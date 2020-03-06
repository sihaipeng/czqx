package com.czqx.ordinary.mapper;

import com.czqx.ordinary.domain.UserDO;
import com.czqx.ordinary.utils.QueryUtil;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper{
    List<UserDO> getAll();
    int insert(UserDO userDO);
    UserDO get(long id);
    int remove(long id);
    List<UserDO> getList(QueryUtil query);
    int getCount(QueryUtil query);
    int update(UserDO userDO);
}
