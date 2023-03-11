package com.hhy.crm;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;

import com.hhy.crm.beans.MarketingActivities;
import com.hhy.crm.mapper.MarketingActivitiesMapper;
import com.hhy.crm.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.List;

@SpringBootTest
class Crm02BranchApplicationTests {


    @Autowired(required = false)
    private MarketingActivitiesMapper marketingActivitiesMapper;


    @Autowired(required = false)
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        List<MarketingActivities> all = marketingActivitiesMapper.getAll();

        all.forEach(System.out::println);


    }

    @Test
    void test01() throws Exception {
        System.out.println(userMapper.selectById(1));
    }

    @Test
    void testPage() throws Exception {





    }



}
