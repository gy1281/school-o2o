package com.oligay.o2o.service.impl;

import java.util.List;

import com.oligay.o2o.dao.ShopCategoryDao;
import com.oligay.o2o.entity.ShopCategory;
import com.oligay.o2o.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {

    @Autowired
    private ShopCategoryDao shopCategoryDao;

    @Override
    public List<ShopCategory> getShopCategoryList(ShopCategory shopCategory) {
        return shopCategoryDao.queryShopCategoryList(shopCategory);
    }

}
