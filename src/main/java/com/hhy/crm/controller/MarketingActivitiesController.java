package com.hhy.crm.controller;

import com.hhy.crm.beans.MarketingActivities;
import com.hhy.crm.dto.ResultDTO;
import com.hhy.crm.exception.MySqlException;
import com.hhy.crm.exception.MyTextException;
import com.hhy.crm.service.MarketingActivitiesService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping("getAll.action")
    public ResultDTO getAll() throws MySqlException, MyTextException {
        List<MarketingActivities> marketingActivitiesList = marketingActivitiesService.getAll();
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setResult(true);
        resultDTO.setData(marketingActivitiesList);
        return resultDTO;
    }

}
