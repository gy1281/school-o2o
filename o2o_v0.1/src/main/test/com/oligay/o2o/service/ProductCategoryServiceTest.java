package com.oligay.o2o.service;

import com.oligay.o2o.BaseTest;
import com.oligay.o2o.entity.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author guoyue
 * @date 2020-04-16
 */
public class ProductCategoryServiceTest extends BaseTest {

    @Autowired
    private ProductCategoryService productCategoryService;

    @Test
    public void testQueryProductCategoryList() {
        long shopId = 1L;
        List<ProductCategory> productCategories = productCategoryService.queryProductCategoryList(shopId);
        Assert.assertNotNull(productCategories);
        Assert.assertEquals(1, productCategories.size());

        for (ProductCategory productCategory : productCategories) {
            System.out.println(productCategory.toString());
        }
    }
}
