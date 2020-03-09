package com.czqx.mhw.service.impl;

import com.czqx.mhw.domain.OrbDO;
import com.czqx.mhw.mapper.OrbMapper;
import com.czqx.mhw.service.OrbService;
import com.czqx.utils.QueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrbServiceImpl implements OrbService {

    @Autowired
    OrbMapper orbMapper;
    @Override
    public List<OrbDO> getList(QueryUtil query) {
        return orbMapper.getList(query);
    }

    @Override
    public int count(QueryUtil query) {
        return orbMapper.count(query);
    }

    @Override
    public int insert(OrbDO orbDO) {
        return orbMapper.insert(orbDO);
    }
}
