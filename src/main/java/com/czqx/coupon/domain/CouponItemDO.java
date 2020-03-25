package com.czqx.coupon.domain;

import lombok.Data;

import java.io.Serializable;
@Data
public class CouponItemDO implements Serializable {
    private static final long serialVersionUID = 2736097444790710620L;
    private long id;
    private long couponId;
    private String barCode;
    private int status;
    private int delFlag;
}
