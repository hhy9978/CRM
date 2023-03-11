package com.hhy.crm.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hhy.crm.beans.MarketingActivities;
import com.hhy.crm.exception.MySqlException;
import com.hhy.crm.exception.MyTextException;
import com.hhy.crm.service.MarketingActivitiesService;
import com.hhy.crm.mapper.MarketingActivitiesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
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
    public Page<MarketingActivities> getPage(MarketingActivities marketingActivities, Long pageNumber) throws MyTextException, MySqlException {
        Page<MarketingActivities> page = new Page<>(pageNumber,6);
        try {
            marketingActivitiesMapper.getPage(
                    marketingActivities.getName(), marketingActivities.getCost(), marketingActivities.getOwnerUser().getName(),
                    marketingActivities.getCreateByUser().getName(), marketingActivities.getEditByUser().getName(),
                    marketingActivities.getStartDate(), marketingActivities.getEndDate(), page);
        } catch (Exception e) {
            throw new MySqlException(e.getMessage());
        }
        if (page.getRecords().size() == 0) {
            throw new MyTextException("没有数据");
        }
        return page;
    }

    //TODO 获取所有活动信息
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

    @Override
    public MarketingActivities get(String id) throws MyTextException, MySqlException {
        MarketingActivities marketingActivities = null;
        try {
            marketingActivities = marketingActivitiesMapper.get(id);
        } catch (Exception e) {
            throw new MySqlException(e.getMessage());
        }
        if (marketingActivities == null) {
            throw new MyTextException("没有数据");
        }
        return marketingActivities;
    }

    @Override
    public void add(MarketingActivities marketingActivities) throws MyTextException, MySqlException{
        //设置时间格式,获取现在时间
        String nowTime = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss").format(LocalDateTime.now());
        marketingActivities.setCreateTime(nowTime);
        try {
            save(marketingActivities);
        } catch (DataIntegrityViolationException e){
            throw new MySqlException("添加失败,活动创建者不存在!");
        }  catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void del(String... ids) throws MyTextException, MySqlException{
        boolean rows = true;
        try {
            rows = removeByIds(Arrays.asList(ids));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (!rows) {
            throw new MyTextException("删除失败,活动不存在!");
        }
    }

    @Override
    public void edit(MarketingActivities marketingActivities) throws MyTextException, MySqlException{
        boolean rows = true;
        try {
            rows = updateById(marketingActivities);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (!rows) {
            throw new MyTextException("修改失败");
        }
    }

}




