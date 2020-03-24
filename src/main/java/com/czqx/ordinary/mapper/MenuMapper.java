package com.czqx.ordinary.mapper;

import com.czqx.ordinary.domain.MenuDO;
import com.czqx.utils.QueryUtil;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {
    List<MenuDO> getList(QueryUtil query);
    int getCount(QueryUtil query);
    MenuDO get(long id);
    int insert(MenuDO menuDO);
    int update(MenuDO menuDO);
    int remove(long id);
    List<MenuDO> getAllByPId(long pId);
    List<MenuDO> getAll();
    List<MenuDO> getByType(int value);

    List<Long> getMenus(long roleId);
}
