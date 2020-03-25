package com.czqx.coupon.controller;

import com.czqx.coupon.domain.CouponDO;
import com.czqx.coupon.exception.CouponException;
import com.czqx.coupon.service.CouponService;
import com.czqx.utils.PageUtil;
import com.czqx.utils.QueryUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/coupon")
public class CouponController {

    @Autowired
    CouponService couponService;

    @GetMapping("/list")
    public PageUtil list(@RequestParam Map<String,Object> map){
        QueryUtil query = new QueryUtil(map);
        List<CouponDO> list = couponService.list(query);
        int count = couponService.count(query);
        return new PageUtil(list,count);
    }

    @PostMapping("/insert")
    @RequiresPermissions("coupon:insert")
    public boolean insert(CouponDO couponDO){
        if (couponService.insert(couponDO) < 1){
            throw new CouponException("添加失败");
        }
        return true;
    }

    @PostMapping("/pickUp/{couponId}")
    @RequiresPermissions("coupon:pickUp")
    public String pickUpCoupon(@PathVariable("couponId") long couponId){
        String barCode = couponService.pickUpCoupon(couponId);
        return barCode;
    }

    @PostMapping("/update")
    @RequiresPermissions("coupon:update")
    public boolean update(CouponDO couponDO){
        if (couponService.update(couponDO) < 1){
            throw new CouponException("修改失败");
        }
        return true;
    }

    @PostMapping("/writeOff/{barCode}")
    @RequiresPermissions("coupon:writeOff")
    public boolean writeOff(@PathVariable("barCode") String barCode){
        if (couponService.writeOff(barCode) < 1){
            throw new CouponException("核销失败");
        }
        return true;
    }

}
