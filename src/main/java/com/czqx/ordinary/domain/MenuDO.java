package com.czqx.ordinary.domain;

import lombok.Data;

import java.io.Serializable;
@Data
public class MenuDO implements Serializable {
    private static final long serialVersionUID = -7261512423568272756L;
    private long id;
    private String name;
    private String url;
    private String icon;
    private int type;
    private int delFlag;
    private long pId;
}
