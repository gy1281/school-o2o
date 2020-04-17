package com.oligay.o2o.dao;

import com.oligay.o2o.entity.ProductCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductCategoryDao {

    List<ProductCategory> selectProductCategoryList(long shopId);

    /**
     *
     *
     * @Title: batchInsertProductCategory
     *
     * @Description: 批量增加roductCategory
     *
     * @param productCategoryList
     *
     * @return: int
     */
    int batchInsertProductCategory(List<ProductCategory> productCategoryList);

    /**
     *
     *
     * @Title: deleteProductCategory
     *
     * @Description: 删除特定shop下的productCategory
     *
     * @param productCategoryId
     * @param shopId
     *
     * @return: int
     */
    int deleteProductCategory(@Param("productCategoryId") Long productCategoryId, @Param("shopId") Long shopId);
}

