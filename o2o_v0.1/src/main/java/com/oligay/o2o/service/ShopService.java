package com.oligay.o2o.service;

import com.oligay.o2o.dto.ImageHolder;
import com.oligay.o2o.dto.ShopExecution;
import com.oligay.o2o.entity.Shop;
import com.oligay.o2o.exception.ShopOperationException;

import java.io.InputStream;

public interface ShopService {

//    ShopExecution addShop(Shop shop, File shopFile);

    // 修改入参，将File类型的入参修改为InputStream,同时增加String类型的文件名称
    ShopExecution addShop(Shop shop, ImageHolder imageHolder);

    /**
     *
     *
     * @Title: getShopById
     *
     * @Description: 根据shopId查询商铺
     *
     * @param shopId
     * @return
     *
     * @return: Shop
     */
    Shop getShopById(long shopId);

    /**
     *
     *
     * @Title: modifyShop
     *
     * @Description: 编辑商铺信息
     *
     * @param shop
     * @return
     *
     * @return: ShopExecution
     */
    ShopExecution modifyShop(Shop shop, ImageHolder imageHolder) throws ShopOperationException;

    /**
     *
     *
     * @Title: getShopList
     *
     * @Description: 获取商铺列表. 在这一个方法中同样的会调用查询总数的DAO层方法，封装到ShopExecution中
     *
     * @param shopCondition
     * @param pageIndex
     *            前端页面 只有第几页 第几页 定义为pageIndex
     * @param pageSize
     *            展示的行数
     * @throws ShopOperationException
     *
     * @return: ShopExecution
     */
    ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize) throws ShopOperationException;;

}

