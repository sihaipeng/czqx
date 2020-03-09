package com.czqx.mhw.mapper;

import com.czqx.mhw.domain.OrbProbabilityDO;
import com.czqx.utils.QueryUtil;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrbProbabilityMapper {
    List<OrbProbabilityDO> getList(QueryUtil query);
    int count(QueryUtil query);
    int insert(OrbProbabilityDO orbProbabilityDO);
}
