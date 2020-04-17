package com.oligay.o2o.service;

import java.util.List;

import com.oligay.o2o.BaseTest;
import com.oligay.o2o.entity.ShopCategory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;



public class ShopServiceCategoryTest extends BaseTest {

    @Autowired
    ShopCategoryService shopCategoryService;

    @Test
    public void testQueryShopCategory() {
        ShopCategory shopCategory = new ShopCategory();
        List<ShopCategory> shopCategories = shopCategoryService.getShopCategoryList(shopCategory);
        Assert.assertEquals(1, shopCategories.size());
        for (ShopCategory shopCategory2 : shopCategories) {
            System.out.println(shopCategory2);
        }
    }
}

