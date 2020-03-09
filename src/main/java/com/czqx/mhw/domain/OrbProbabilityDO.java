package com.czqx.mhw.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrbProbabilityDO implements Serializable {
    private static final long serialVersionUID = -1809880953041818567L;
    private long id;
    private long orbTypeId;
    private long orbRankId;
    private String probability;
}
