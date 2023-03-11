package com.hhy.crm.mapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import org.apache.ibatis.annotations.Param;

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

    MarketingActivities get(@Param("id") String id);

    Page<MarketingActivities> getPage(@Param("name") String name,
                                      @Param("cost") Long cost,
                                      @Param("ownerUserName") String ownerUserName,
                                      @Param("createByUserName") String createByUserName,
                                      @Param("editByUserName") String editByUserNam,
                                      @Param("startDate") String startDate,
                                      @Param("endDate") String endDate,
                                      @Param("page") Page<MarketingActivities> page);

}




