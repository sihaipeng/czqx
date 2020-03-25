package com.czqx.coupon.service;

import com.czqx.coupon.domain.CouponDO;
import com.czqx.coupon.domain.CouponItemDO;
import com.czqx.utils.QueryUtil;

import java.util.List;

public interface CouponService {
    int insert(CouponDO couponDO);

    CouponDO get(long id);

    String pickUpCoupon(long couponId);

    int update(CouponDO couponDO);

    int writeOff(String barCode);

    List<CouponDO> list(QueryUtil query);

    int count(QueryUtil query);
}
