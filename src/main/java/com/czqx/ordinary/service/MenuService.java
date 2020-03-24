package com.czqx.ordinary.service;

import com.czqx.ordinary.domain.MenuDO;
import com.czqx.utils.QueryUtil;

import java.util.List;

public interface MenuService {
    List<MenuDO> getList(QueryUtil query);
    int getCount(QueryUtil query);
    MenuDO get(long id);
    int insert(MenuDO menuDO);
    int update(MenuDO menuDO);
    int remove(long id);
    List<MenuDO> getAllByPId(long pId);
    List<MenuDO> getAll();
}
