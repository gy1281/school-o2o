package com.oligay.o2o.dao;

import com.oligay.o2o.BaseTest;
import com.oligay.o2o.entity.ProductCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author guoyue
 * @date 2020-04-16
 */
public class ProductCategoryDaoTest extends BaseTest {

    @Autowired
    ProductCategoryDao productCategoryDao;

    @Test
    public void testSelectProductCategoryList() {
        long shopId = 1L;
        List<ProductCategory> productCategories = productCategoryDao.selectProductCategoryList(shopId);
        // shopId = 1 有1条测试数据,期望list中有1条
        assertEquals(1, productCategories.size());
        // SQL中按照权重排序, product1 priority 99 ,期望第一条数据是 product1
        assertEquals("p1", productCategories.get(0).getProductCategoryName());

        for (ProductCategory productCategory : productCategories) {
            System.out.println(productCategory.toString());
        }

        productCategories = productCategoryDao.selectProductCategoryList(6L);
        assertEquals(0, productCategories.size());

    }
}
