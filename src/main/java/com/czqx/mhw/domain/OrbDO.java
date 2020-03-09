package com.czqx.mhw.domain;

import lombok.Data;

import java.io.Serializable;
@Data
public class OrbDO implements Serializable {
    private static final long serialVersionUID = -2878796109974307212L;
    private long id;
    private String name;
    private String rareRank;
    private int occupied;
}
