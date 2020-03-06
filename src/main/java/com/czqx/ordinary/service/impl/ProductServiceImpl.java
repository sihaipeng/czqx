package com.czqx.ordinary.service.impl;

import com.czqx.ordinary.domain.ProductDO;
import com.czqx.ordinary.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

//    @Autowired
//    ProductMapper productMapper;
    @Override
    public List<ProductDO> list() {
//        List<ProductDO> list = productMapper.selectAll();
        return null;
    }
}
