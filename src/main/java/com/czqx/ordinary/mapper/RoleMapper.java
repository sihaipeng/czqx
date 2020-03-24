package com.czqx.ordinary.mapper;

import com.czqx.ordinary.domain.RoleDO;
import com.czqx.utils.QueryUtil;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {
    int insert(RoleDO roleDO);
    List<RoleDO> getList(QueryUtil query);
    int getCount(QueryUtil query);
    RoleDO get(long id);
    int remove(long id);
    int update(RoleDO roleDO);

    List<Long> getMenus(long id);
}
