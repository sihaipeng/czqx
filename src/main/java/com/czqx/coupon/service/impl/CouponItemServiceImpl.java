package com.czqx.coupon.service.impl;

import com.czqx.coupon.domain.CouponVO;
import com.czqx.coupon.mapper.CouponItemMapper;
import com.czqx.coupon.service.CouponItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponItemServiceImpl implements CouponItemService {

    @Autowired
    CouponItemMapper couponItemMapper;
    @Override
    public CouponVO getByBarCode(String barCode) {
        return couponItemMapper.getByBarCode(barCode);
    }
}
