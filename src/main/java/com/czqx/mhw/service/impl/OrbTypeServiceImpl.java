package com.czqx.mhw.service.impl;

import com.czqx.mhw.domain.OrbTypeDO;
import com.czqx.mhw.mapper.OrbTypeMapper;
import com.czqx.mhw.service.OrbTypeService;
import com.czqx.utils.QueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrbTypeServiceImpl implements OrbTypeService {

    @Autowired
    OrbTypeMapper orbTypeMapper;
    @Override
    public List<OrbTypeDO> getList(QueryUtil query) {
        return orbTypeMapper.getList(query);
    }

    @Override
    public int count(QueryUtil query) {
        return orbTypeMapper.count(query);
    }

    @Override
    public int insert(OrbTypeDO orbTypeDO) {
        return orbTypeMapper.insert(orbTypeDO);
    }
}
