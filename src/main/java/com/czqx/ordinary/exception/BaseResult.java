package com.czqx.ordinary.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BaseResult {
    private int code;
    private String msg;
}
