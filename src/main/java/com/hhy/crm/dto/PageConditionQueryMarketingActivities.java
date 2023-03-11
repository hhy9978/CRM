package com.hhy.crm.dto;


import com.hhy.crm.beans.MarketingActivities;
import lombok.Data;

/**
 * @author hhy
 * @code 2023-03-10 21:01
 */
@Data
public class PageConditionQueryMarketingActivities {

    private Long pageIndex;

    private MarketingActivities marketingActivities;

}
