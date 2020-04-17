package com.oligay.o2o.service;

import com.oligay.o2o.dto.ProductCategoryExecution;
import com.oligay.o2o.entity.ProductCategory;
import com.oligay.o2o.exception.ProductCategoryOperationException;

import java.util.List;

/**
 * @author guoyue
 * @date 2020-04-16
 */
public interface ProductCategoryService {

    List<ProductCategory> queryProductCategoryList(long shopId);

    /**
     *
     *
     * @Title: addProductCategory
     *
     * @Description: 批量插入ProductCategory
     *
     * @param productCategoryList
     * @throws ProductCategoryOperationException
     *
     * @return: ProductCategoryExecution
     */
    ProductCategoryExecution addProductCategory(List<ProductCategory> productCategoryList) throws ProductCategoryOperationException;
    /**
     *
     *
     * @Title: deleteProductCategory
     *
     * @Description: TODO 需要先将该商品目录下的商品的类别Id置为空，然后再删除该商品目录， 因此需要事务控制
     *
     * @param productCategoryId
     * @param shopId
     * @throws ProductCategoryOperationException
     *
     * @return: ProductCategoryExecution
     */
    ProductCategoryExecution deleteProductCategory(long productCategoryId, long shopId) throws ProductCategoryOperationException;

}
