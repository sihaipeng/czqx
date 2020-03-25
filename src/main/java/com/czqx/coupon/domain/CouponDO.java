package com.czqx.coupon.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class CouponDO implements Serializable {
    private static final long serialVersionUID = 744697454834905943L;
    private long id;
    private String name;
    private BigDecimal discountPrice;
    private BigDecimal useThreshold;
    private int receiveCount;
    private int issueCount;
    private Date receiveStartTime;
    private Date receiveEndTime;
    private Date useStartTime;
    private Date useEndTime;
    private int status;
    private int delFlag;
}
