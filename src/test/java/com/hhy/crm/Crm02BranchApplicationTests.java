package com.hhy.crm;

import com.hhy.crm.beans.MarketingActivities;
import com.hhy.crm.mapper.MarketingActivitiesMapper;
import com.hhy.crm.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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


}
