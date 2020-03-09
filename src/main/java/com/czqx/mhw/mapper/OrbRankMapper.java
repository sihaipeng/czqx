package com.czqx.mhw.mapper;

import com.czqx.mhw.domain.OrbRankDO;
import com.czqx.utils.QueryUtil;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrbRankMapper {
    List<OrbRankDO> getList(QueryUtil query);
    int count(QueryUtil query);
    int insert(OrbRankDO orbRankDO);
}
