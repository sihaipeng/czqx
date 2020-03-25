package com.czqx.coupon.controller;

import com.czqx.coupon.domain.CouponVO;
import com.czqx.coupon.service.CouponItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/couponItem")
public class CouponItemController {

    @Autowired
    CouponItemService couponItemService;

    @GetMapping("/getByBarCode/{barCode}")
    public CouponVO get(@PathVariable("barCode") String barCode){
        return couponItemService.getByBarCode(barCode);
    }
}
