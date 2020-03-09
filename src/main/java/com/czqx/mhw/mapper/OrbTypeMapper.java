package com.czqx.mhw.mapper;

import com.czqx.mhw.domain.OrbTypeDO;
import com.czqx.utils.QueryUtil;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface OrbTypeMapper {
    List<OrbTypeDO> getList(QueryUtil query);
    int count(QueryUtil query);
    int insert(OrbTypeDO orbTypeDO);
}
