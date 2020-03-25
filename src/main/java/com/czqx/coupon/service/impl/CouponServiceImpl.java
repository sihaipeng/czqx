package com.czqx.coupon.service.impl;

import com.czqx.coupon.domain.CouponDO;
import com.czqx.coupon.domain.CouponItemDO;
import com.czqx.coupon.domain.CouponVO;
import com.czqx.coupon.exception.CouponException;
import com.czqx.coupon.mapper.CouponItemMapper;
import com.czqx.coupon.mapper.CouponMapper;
import com.czqx.coupon.service.CouponService;
import com.czqx.utils.QueryUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    CouponMapper couponMapper;
    @Autowired
    CouponItemMapper couponItemMapper;

    @Override
    public int insert(CouponDO couponDO) {
        return couponMapper.insert(couponDO);
    }

    @Override
    public CouponDO get(long id) {
        return couponMapper.get(id);
    }

    @Override
    @Transactional
    public String pickUpCoupon(long couponId) {
        CouponDO couponDO = get(couponId);
        int issueCount = couponDO.getIssueCount();
        int receiveCount = couponDO.getReceiveCount();
        if (issueCount - receiveCount < 1){
            throw new CouponException("券已发完");
        }
        long nowTime = System.currentTimeMillis();

        if (couponDO.getReceiveStartTime().getTime() > nowTime || couponDO.getReceiveEndTime().getTime() < nowTime){
           throw new CouponException("未在领取时间内");
        }
        couponDO.setReceiveCount(receiveCount + 1);
        update(couponDO);
        CouponItemDO couponItemDO = new CouponItemDO();
        couponItemDO.setCouponId(couponId);
        couponItemDO.setBarCode(getBarCode());
        couponItemMapper.insert(couponItemDO);
        return couponItemDO.getBarCode();
    }

    private String getBarCode() {
        String random = RandomStringUtils.random(13,false,true);
        CouponVO barCode = couponItemMapper.getByBarCode(random);
        if (null != barCode){
            return getBarCode();
        }
        return random;
    }

    @Override
    public int update(CouponDO couponDO) {
        return couponMapper.update(couponDO);
    }

    @Override
    public int writeOff(String barCode) {
        CouponVO couponVO = couponItemMapper.getByBarCode(barCode);
        if (null == couponVO){
            throw new CouponException("无效条形码");
        }
        return couponItemMapper.writeOff(barCode);
    }

    @Override
    public List<CouponDO> list(QueryUtil query) {
        return couponMapper.list(query);
    }

    @Override
    public int count(QueryUtil query) {
        return couponMapper.count(query);
    }

}
