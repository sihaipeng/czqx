package com.czqx.mhw.service;

import com.czqx.mhw.domain.OrbProbabilityDO;
import com.czqx.utils.QueryUtil;

import java.util.List;

public interface OrbProbabilityService {
    List<OrbProbabilityDO> getList(QueryUtil query);
    int count(QueryUtil query);
    int insert(OrbProbabilityDO orbProbabilityDO);
}
