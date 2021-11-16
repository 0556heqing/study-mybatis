package com.heqing.mybatisplus.multinodular.demo.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heqing.mybatisplus.multinodular.demo.model.po.PersonPO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户 Mapper 接口
 * </p>
 *
 * @author heqing
 * @since 2021-07-21
 */
@DS("demo")
@Repository
public interface PersonMapper extends BaseMapper<PersonPO> {

    PersonPO selectPersonById(@Param("id") Long id);
}
