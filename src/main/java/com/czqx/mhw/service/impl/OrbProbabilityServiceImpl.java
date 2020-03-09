package com.czqx.mhw.service.impl;

import com.czqx.mhw.domain.OrbProbabilityDO;
import com.czqx.mhw.mapper.OrbProbabilityMapper;
import com.czqx.mhw.service.OrbProbabilityService;
import com.czqx.utils.QueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrbProbabilityServiceImpl implements OrbProbabilityService {

    @Autowired
    OrbProbabilityMapper orbProbabilityMapper;
    @Override
    public List<OrbProbabilityDO> getList(QueryUtil query) {
        return orbProbabilityMapper.getList(query);
    }

    @Override
    public int count(QueryUtil query) {
        return orbProbabilityMapper.count(query);
    }

    @Override
    public int insert(OrbProbabilityDO orbProbabilityDO) {
        return orbProbabilityMapper.insert(orbProbabilityDO);
    }
}
