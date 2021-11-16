package com.heqing.mybatisplus.multinodular.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heqing.mybatisplus.multinodular.test.mapper.TestUserMapper;
import com.heqing.mybatisplus.multinodular.test.model.po.TestUserPO;
import com.heqing.mybatisplus.multinodular.test.service.ITestUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author heqing
 * @since 2021-07-21
 */
@Service("testUserService")
public class TestUserServiceImpl extends ServiceImpl<TestUserMapper, TestUserPO> implements ITestUserService {

}
