package com.hhy.crm.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hhy.crm.beans.MarketingActivities;
import com.hhy.crm.dto.PageConditionQueryMarketingActivities;
import com.hhy.crm.dto.ResultDTO;
import com.hhy.crm.exception.MySqlException;
import com.hhy.crm.exception.MyTextException;
import com.hhy.crm.service.MarketingActivitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author hhy
 * @code 2023-03-07 19:21
 */

@RestController
@RequestMapping("/marketingActivities")
public class MarketingActivitiesController {

    @Autowired(required = false)
    private MarketingActivitiesService marketingActivitiesService;

    @RequestMapping("getPage.action")
    public ResultDTO getPage(@RequestBody PageConditionQueryMarketingActivities pageConditionQueryMarketingActivities) throws MySqlException, MyTextException {
        Long pageNumber = pageConditionQueryMarketingActivities.getPageIndex();
        MarketingActivities marketingActivities = pageConditionQueryMarketingActivities.getMarketingActivities();
        Page<MarketingActivities> page = marketingActivitiesService.getPage(marketingActivities, pageNumber);
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setResult(true);
        resultDTO.setData(page);
        return resultDTO;
    }

    @RequestMapping("getAll.action")
    public ResultDTO getAll() throws MySqlException, MyTextException {
        List<MarketingActivities> marketingActivitiesList = marketingActivitiesService.getAll();
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setResult(true);
        resultDTO.setData(marketingActivitiesList);
        return resultDTO;
    }

    @RequestMapping("get.action")
    public ResultDTO get(String id) throws MySqlException, MyTextException {
        MarketingActivities marketingActivities = marketingActivitiesService.get(id);
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setResult(true);
        resultDTO.setData(marketingActivities);
        return resultDTO;
    }

    @RequestMapping("add.action")
    public ResultDTO add(MarketingActivities marketingActivities) throws MySqlException, MyTextException {
        marketingActivitiesService.add(marketingActivities);
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setResult(true);
        resultDTO.setSuccessMsg("添加成功!");
        return resultDTO;
    }


    @RequestMapping("del.action")
    public ResultDTO del(@RequestBody String[] ids) throws MySqlException, MyTextException {
        marketingActivitiesService.del(ids);
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setResult(true);
        resultDTO.setSuccessMsg("删除成功!");
        return resultDTO;
    }

    @RequestMapping("edit.action")
    public ResultDTO edit(MarketingActivities marketingActivities) throws MySqlException, MyTextException {
        marketingActivitiesService.edit(marketingActivities);
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setResult(true);
        resultDTO.setSuccessMsg("修改成功!");
        return resultDTO;
    }

}
