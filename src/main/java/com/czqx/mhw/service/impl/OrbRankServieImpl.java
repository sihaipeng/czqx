package com.czqx.mhw.service.impl;

import com.czqx.mhw.domain.OrbRankDO;
import com.czqx.mhw.mapper.OrbRankMapper;
import com.czqx.mhw.service.OrbRankService;
import com.czqx.utils.QueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrbRankServieImpl implements OrbRankService {

    @Autowired
    OrbRankMapper orbRankMapper;
    @Override
    public List<OrbRankDO> getList(QueryUtil query) {
        return orbRankMapper.getList(query);
    }

    @Override
    public int count(QueryUtil query) {
        return orbRankMapper.count(query);
    }

    @Override
    public int insert(OrbRankDO orbRankDO) {
        return orbRankMapper.insert(orbRankDO);
    }
}
