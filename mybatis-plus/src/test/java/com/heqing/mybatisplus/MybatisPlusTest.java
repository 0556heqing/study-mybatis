package com.heqing.mybatisplus;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heqing.mybatisplus.multinodular.demo.model.po.PersonPO;
import com.heqing.mybatisplus.multinodular.demo.service.IPersonService;
import com.heqing.mybatisplus.multinodular.test.model.po.TestUserPO;
import com.heqing.mybatisplus.multinodular.test.service.ITestUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * @author heqing
 * @date 2021/7/20 19:33
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlusTest {

    @Autowired
    private IPersonService personService;

    @Autowired
    private ITestUserService testUserService;

    @Test
    public void testList() {
        Page page = new Page<>(1,10);
        LambdaQueryWrapper<PersonPO> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(PersonPO::getName, "小白");
        IPage<PersonPO> personPage = personService.page(page, wrapper);
        System.out.println("--> " + JSONObject.toJSONString(personPage));

        PersonPO person = personService.selectPersonById(1L);
        System.out.println("--> " + JSONObject.toJSONString(person));
    }

    @Test
    public void testDataSource() {
        List<PersonPO> personList = personService.list();
        System.out.println(" ------- demo ------- ");
        personList.stream().map(personPO -> personPO.getName()).forEach(System.out::println);

        System.out.println(" ------- test ------- ");
        List<TestUserPO> userList = testUserService.list();
        userList.stream().map(userPO -> userPO.getName()).forEach(System.out::println);
    }

    @Test
    public void testPersonCreate() {
        PersonPO po = new PersonPO();
        po.setName("贺小黑");
        po.setSex(2);
        po.setBirthday(new Date());
        po.setAddrProvince("上海");
        po.setRemark("{\"num\":1,\"test\":\"demo\"}");
        boolean result = personService.save(po);
        System.out.println("--> " + result);
    }

}
