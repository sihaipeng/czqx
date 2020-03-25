package com.czqx.coupon.couponenum;

public enum CouponConstant {

    TOBEUSED(100010,"待使用"),
    BEUSED(100020,"已使用"),
    EXPIRED(100030,"已过期"),
    RECEIVESUCCESS(100040,"领取成功"),
    RECEIVEFAILD(100050,"领取失败"),
    NOTPICKUPTIME(100060,"未在领取时间"),
    NOTUSEDTIME(100070,"未在使用时间"),
    UNDERUSAGETHRESHOLD(100080,"未达到使用门槛"),
    WRITEOFFSUCCESS(100090,"核销成功"),
    WRITEOFFFAILED(100100,"核销失败");

    int code;
    String msg;

    CouponConstant(int code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
