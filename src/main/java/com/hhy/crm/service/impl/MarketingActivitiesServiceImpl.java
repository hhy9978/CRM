package com.hhy.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hhy.crm.beans.MarketingActivities;
import com.hhy.crm.exception.MySqlException;
import com.hhy.crm.exception.MyTextException;
import com.hhy.crm.service.MarketingActivitiesService;
import com.hhy.crm.mapper.MarketingActivitiesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 24729
* @description 针对表【tbl_marketing_activities(市场活动表)】的数据库操作Service实现
* @createDate 2023-03-07 17:33:52
*/
@Service
public class MarketingActivitiesServiceImpl extends ServiceImpl<MarketingActivitiesMapper, MarketingActivities>
    implements MarketingActivitiesService{

    @Autowired(required = false)
    private MarketingActivitiesMapper marketingActivitiesMapper;

    @Override
    public List<MarketingActivities> getAll() throws MyTextException, MySqlException {



        List<MarketingActivities> marketingActivitiesList = null;
        try {
            marketingActivitiesList = marketingActivitiesMapper.getAll();
        } catch (Exception e) {
            throw new MySqlException(e.getMessage());
        }
        if (marketingActivitiesList == null) {
            throw new MyTextException("没有数据");
        }
        return marketingActivitiesList;
    }
}




