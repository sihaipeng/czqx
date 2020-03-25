package com.czqx.coupon.mapper;

import com.czqx.coupon.domain.CouponItemDO;
import com.czqx.coupon.domain.CouponVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CouponItemMapper {

    int insert(CouponItemDO couponItemDO);

    CouponVO getByBarCode(String barCode);

    int writeOff(String barCode);
}
