package com.heqing.mybatisplus.multinodular.test.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heqing.mybatisplus.multinodular.test.model.po.TestUserPO;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author heqing
 * @since 2021-07-21
 */
@DS("test")
public interface TestUserMapper extends BaseMapper<TestUserPO> {

}
