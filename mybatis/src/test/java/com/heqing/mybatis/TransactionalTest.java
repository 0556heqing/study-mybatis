package com.heqing.mybatis;

import com.heqing.mybatis.service.TransactionaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        locations = {"classpath*:spring-core.xml","classpath:spring-mybatis.xml"}
)
public class TransactionalTest {

    @Autowired
    TransactionaService transactionaService;

    @Test
    public void testSave() {
        try {
            transactionaService.save(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
