package com.czqx.mhw.mapper;

import com.czqx.mhw.domain.OrbDO;
import com.czqx.utils.QueryUtil;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrbMapper {
    List<OrbDO> getList(QueryUtil query);
    int count(QueryUtil query);
    int insert(OrbDO orbDO);
}
