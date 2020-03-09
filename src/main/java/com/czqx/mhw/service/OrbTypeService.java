package com.czqx.mhw.service;

import com.czqx.mhw.domain.OrbTypeDO;
import com.czqx.utils.QueryUtil;

import java.util.List;

public interface OrbTypeService {
    List<OrbTypeDO> getList(QueryUtil query);

    int count(QueryUtil query);

    int insert(OrbTypeDO orbTypeDO);
}
