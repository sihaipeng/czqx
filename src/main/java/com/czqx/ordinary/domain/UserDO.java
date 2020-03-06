package com.czqx.ordinary.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDO implements Serializable {
    private static final long serialVersionUID = 3829387402761426688L;
    private long id;
    private String name;
    private String password;
    private String nickName;
    private int status;
    private int delFlag;
}
