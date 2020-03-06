package com.czqx.ordinary.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class ProductDO implements Serializable {
    private long id;
    private String name;
    private String img;
    private BigDecimal price;
    private int status;
    private int delFlag;
}
