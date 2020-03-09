package com.czqx.mhw.service;

import com.czqx.mhw.domain.OrbDO;
import com.czqx.utils.QueryUtil;

import java.util.List;

public interface OrbService {
    List<OrbDO> getList(QueryUtil query);
    int count(QueryUtil query);
    int insert(OrbDO orbDO);
}
