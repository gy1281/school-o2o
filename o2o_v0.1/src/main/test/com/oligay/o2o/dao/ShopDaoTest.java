package com.oligay.o2o.dao;

import java.util.Date;
import java.util.List;

import com.oligay.o2o.BaseTest;
import com.oligay.o2o.entity.Area;
import com.oligay.o2o.entity.PersonInfo;
import com.oligay.o2o.entity.Shop;
import com.oligay.o2o.entity.ShopCategory;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class ShopDaoTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(ShopDaoTest.class);

    @Autowired
    ShopDao shopDao;

    @Test
    public void testQueryArea() {

        Shop shop = new Shop();
        PersonInfo personInfo = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();

        // 因为tb_shop表中有外键约束,因此务必确保 设置的这几个id在对应的表中存在.
        // 我们提前在tb_person_inf tb_area
        // tb_shop_category分别添加了如下id的数据,以避免插入tb_shop时抛出如下异常
        // com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException:
        // Cannot add or update a child row: a foreign key constraint fails
        // (`o2o`.`tb_shop`, CONSTRAINT `fk_shop_area` FOREIGN KEY (`area_id`)
        // REFERENCES `tb_area` (`area_id`))
        personInfo.setUserId(1L);
        area.setAreaId(1);
        shopCategory.setShopCategoryId(1L);

        shop.setOwner(personInfo);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("Artisan");
        shop.setShopDesc("ArtisanDesc");
        shop.setShopAddr("NanJing");
        shop.setPhone("123456");
        shop.setShopImg("/xxx/xxx");
        shop.setPriority(99);
        shop.setCreateTime(new Date());
        shop.setLastEditTime(new Date());
        shop.setEnableStatus(0);
        shop.setAdvice("Waring");

        int effectNum = shopDao.insertShop(shop);

        Assert.assertEquals(effectNum, 1);
        logger.debug("insert  successfully");
    }

    @Test
    public void testUpdateShop() {
        // shop_id 不可更新 personInfo不可更新
        Shop shop = new Shop();

        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();

        // 模拟更新 shop_id=5的记录 。 因为目前数据库中只有一条shop_id=5的数据
        shop.setShopId(1L);

        // 将area_id更新成2
        area.setAreaId(2);
        // 为了防止因外键约束，导致更新异常，同时也能验证更新方法没有问题
        // 新增一条测试数据将shopCategoryId更新为2
        shopCategory.setShopCategoryId(2L);

        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("ArtisanUP");
        shop.setShopDesc("ArtisanDescUP");
        shop.setShopAddr("NanJingUP");
        shop.setPhone("123456UP");
        shop.setShopImg("/xxx/xxx/UP");
        shop.setPriority(66);
        shop.setCreateTime(new Date());
        shop.setLastEditTime(new Date());
        shop.setEnableStatus(1);
        shop.setAdvice("Waring UP");

        int effectNum = shopDao.updateShop(shop);

        Assert.assertEquals(effectNum, 1);
        logger.debug("update  successfully");

    }

    @Test
    public void testSelectShopById() {
        Shop shop = shopDao.selectShopById(1L);
        Assert.assertNotNull(shop);
        System.out.println(shop.toString());
    }

    @Test
    public void testSelectShopListAndCount() {

        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        PersonInfo personInfo = new PersonInfo();
        List<Shop> shopList = null;

        /**
         * 可输入的查询条件： 1.商铺名（要求模糊查询） 2.区域Id 3.商铺状态 4.商铺类别 5.owner
         *
         *
         * 首先按照单个条件进行单元测试，然后组合测试
         **/

        // 1.商铺名（要求模糊查询）
        Shop shopCondition = new Shop();
        shopCondition.setShopName("咖啡点");

        // 1.1 数据库中只有3条数据符合 ，我们分页条件 取出5条，即全部取出 验证rowIndex 和 pageSize
        shopList = shopDao.selectShopList(shopCondition, 0, 5);
        System.out.println(shopList.size());
    }
}

