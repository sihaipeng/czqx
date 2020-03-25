package com.czqx.coupon.mapper;

import com.czqx.coupon.domain.CouponDO;
import com.czqx.utils.QueryUtil;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CouponMapper {
    int insert(CouponDO couponDO);

    CouponDO get(long id);

    int update(CouponDO couponDO);

    List<CouponDO> list(QueryUtil query);

    int count(QueryUtil query);
}
