package com.oligay.o2o.service;

import com.oligay.o2o.BaseTest;
import com.oligay.o2o.entity.Area;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author guoyue
 * @date 2020-04-10
 */
public class AreaServiceTest extends BaseTest {

    @Autowired
    AreaService areaService;

    @Test
    public void testGetAreaList() {
        List<Area> areaList = areaService.getAreaList();
        Assert.assertEquals("上海", areaList.get(0).getAreaName());
    }
}
