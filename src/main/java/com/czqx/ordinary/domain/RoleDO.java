package com.czqx.ordinary.domain;

import lombok.Data;

import java.io.Serializable;
@Data
public class RoleDO implements Serializable {
    private static final long serialVersionUID = -6862801164510911328L;
    private long id;
    private String name;
    private int delFlag;
    private String remark;
}
