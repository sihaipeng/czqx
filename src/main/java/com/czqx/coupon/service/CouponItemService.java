package com.czqx.coupon.service;

import com.czqx.coupon.domain.CouponVO;

public interface CouponItemService {
    CouponVO getByBarCode(String barCode);
}
