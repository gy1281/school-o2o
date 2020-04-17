package com.oligay.o2o.service.impl;

import com.oligay.o2o.dao.AreaDao;
import com.oligay.o2o.entity.Area;
import com.oligay.o2o.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 *
 * @ClassName: AreaServiceImpl
 *
 * @Description: @Service标注的服务层
 *
 */
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    AreaDao areaDao;

    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }

}
