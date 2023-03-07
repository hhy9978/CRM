package com.hhy.crm.service;

import com.hhy.crm.beans.MarketingActivities;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hhy.crm.exception.MySqlException;
import com.hhy.crm.exception.MyTextException;

import java.util.List;

/**
* @author 24729
* @description 针对表【tbl_marketing_activities(市场活动表)】的数据库操作Service
* @createDate 2023-03-07 17:33:52
*/
public interface MarketingActivitiesService extends IService<MarketingActivities> {


    List<MarketingActivities> getAll() throws MyTextException, MySqlException;

}
