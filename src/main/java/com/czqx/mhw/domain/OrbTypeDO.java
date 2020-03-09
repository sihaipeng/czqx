package com.czqx.mhw.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrbTypeDO implements Serializable {
    private static final long serialVersionUID = -1295595598074719563L;
    private long id;
    private String name;
    private String rares;
}
