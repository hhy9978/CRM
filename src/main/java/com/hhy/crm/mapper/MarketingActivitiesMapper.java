package com.hhy.crm.mapper;

import com.hhy.crm.beans.MarketingActivities;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author 24729
* @description 针对表【tbl_marketing_activities(市场活动表)】的数据库操作Mapper
* @createDate 2023-03-07 17:33:52
* @Entity com.hhy.crm.beans.MarketingActivities
*/
public interface MarketingActivitiesMapper extends BaseMapper<MarketingActivities> {
    List<MarketingActivities> getAll();

}




