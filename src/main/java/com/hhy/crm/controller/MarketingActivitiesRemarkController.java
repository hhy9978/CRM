package com.hhy.crm.controller;

import com.hhy.crm.beans.MarketingActivitiesRemark;
import com.hhy.crm.dto.ResultDTO;
import com.hhy.crm.service.MarketingActivitiesRemarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hhy
 * @code 2023-03-10 11:09
 */
@RestController
@RequestMapping("/marketingActivitiesRemark")
public class MarketingActivitiesRemarkController {

    @Autowired(required = false)
    private MarketingActivitiesRemarkService marketingActivitiesRemarkService;

    @RequestMapping("get.action")
    public ResultDTO get(Long id) {




        ResultDTO resultDTO = new ResultDTO();


        resultDTO.setResult(true);


        return resultDTO;
    }

}
