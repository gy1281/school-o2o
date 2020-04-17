package com.oligay.o2o.dto;

import com.oligay.o2o.entity.Shop;
import com.oligay.o2o.enums.ShopStateEnum;

import java.util.List;

/**
 * DTO概述
 * Data Transfer Object，数据传送对象 .
 *
 * DTO是一个普通的Java类，它封装了要传送的批量的数据。
 * 当客户端需要读取服务器端的数据的时候，服务器端将数据封装在DTO中，
 * 这样客户端就可以在一个网络调用中获得它需要的所有数据。
 *
 * Shop实体类包含了Shop的基本属性，但是在前端操作时，
 * 我们希望可以返回操作的结果等信息，这个时候Shop实体类就不能满足需求了，
 * 我们将操作结果和Shop等信息统一放到DTO中处理，即可满足当前的需求。
 *
 * @ClassName: ShopExecution
 *
 * @Description: DTO中还要包含操作商铺的返回结果,单个的实体类无法满足，所以封装到dto中，便于操作
 *
 */
public class ShopExecution {

    /**
     * 操作结果状态
     */
    private int state ;

    /**
     * 操作结果状态说明
     */
    private String stateInfo;

    /**
     * 店铺数量
     */
    private int count;

    /**
     * 店铺 （增删改店铺的时候用，用于保存shop，就是换了个载体）
     */
    private Shop shop;

    /**
     * 店铺集合 (查询店铺列表的时候用)
     */
    private List<Shop> shopList;

    /**
     *
     *
     * @Title:ShopExecution
     *
     * @Description: 无参构造函数
     */
    public ShopExecution() {
        super();
    }

    /**
     *
     * @Title:ShopExecution
     *
     * @Description: 构造函数,店铺操作失败的时候使用的构造函数
     *
     * @param shopStateEnum
     */
    public ShopExecution(ShopStateEnum shopStateEnum) {
        this.state = shopStateEnum.getState();
        this.stateInfo = shopStateEnum.getStateInfo();
    }

    /**
     *
     *
     * @Title:ShopExecution
     *
     * @Description:构造函数,店铺操作成功的时候使用的构造函数
     *
     * @param stateEnum
     * @param shop
     */
    public ShopExecution(ShopStateEnum stateEnum, Shop shop) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.shop = shop;
    }

    /**
     *
     *
     * @Title:ShopExecution
     *
     * @Description:构造函数,店铺操作成功的时候使用的构造函数
     *
     * @param stateEnum
     * @param shopList
     */
    public ShopExecution(ShopStateEnum stateEnum, List<Shop> shopList) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.shopList = shopList;
    }


    /**
     *
     * setter/getter
     *
     */

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public List<Shop> getShopList() {
        return shopList;
    }

    public void setShopList(List<Shop> shopList) {
        this.shopList = shopList;
    }

    @Override
    public String toString() {
        return "ShopExecution{" +
                "state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", count=" + count +
                ", shop=" + shop +
                ", shopList=" + shopList +
                '}';
    }
}

