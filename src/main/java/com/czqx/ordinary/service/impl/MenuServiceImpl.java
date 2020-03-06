package com.czqx.ordinary.service.impl;

import com.czqx.ordinary.domain.MenuDO;
import com.czqx.ordinary.mapper.MenuMapper;
import com.czqx.ordinary.service.MenuService;
import com.czqx.ordinary.utils.QueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuMapper menuMapper;
    @Override
    public List<MenuDO> getList(QueryUtil query) {
        return menuMapper.getList(query);
    }

    @Override
    public int getCount(QueryUtil query) {
        return menuMapper.getCount(query);
    }

    @Override
    public MenuDO get(long id) {
        return menuMapper.get(id);
    }

    @Override
    public int insert(MenuDO menuDO) {
        return menuMapper.insert(menuDO);
    }

    @Override
    public int update(MenuDO menuDO) {
        return menuMapper.update(menuDO);
    }

    @Override
    public int remove(long id) {
        return menuMapper.remove(id);
    }
}
