package com.heqing.mybatisplus.multinodular.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heqing.mybatisplus.multinodular.demo.model.po.PersonPO;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author heqing
 * @since 2021-07-21
 */
public interface IPersonService extends IService<PersonPO> {

    PersonPO selectPersonById(Long id);
}
