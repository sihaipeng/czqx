package com.czqx.coupon.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class CouponVO implements Serializable {
    private String name;
    private BigDecimal discountPrice;
    private BigDecimal UseThreshold;
    private Date useStartTime;
    private Date useEndTime;
}
