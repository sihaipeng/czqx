package com.czqx.ordinary.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class PageUtil<T> {
    private List<T> list;
    private int count;
}
