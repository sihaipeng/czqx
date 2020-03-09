package com.czqx.mhw.service;

import com.czqx.mhw.domain.OrbRankDO;
import com.czqx.utils.QueryUtil;

import java.util.List;

public interface OrbRankService {
    List<OrbRankDO> getList(QueryUtil query);
    int count(QueryUtil query);
    int insert(OrbRankDO orbRankDO);
}
