package com.czqx.ordinary.utils;

import java.util.LinkedHashMap;
import java.util.Map;

public class QueryUtil extends LinkedHashMap<String,Object> {
    public QueryUtil(Map<String,Object> map){
        this.putAll(map);
        if (map.get("page") == null){
            this.put("limit",0);
            this.put("pageSize",10);
        }else {
            int page = Integer.parseInt((String) map.get("page"));
            int pageSize = Integer.parseInt((String) map.get("pageSize"));
            this.put("limit",(page-1) * pageSize);
            this.put("pageSize",pageSize);
        }
    }
}
