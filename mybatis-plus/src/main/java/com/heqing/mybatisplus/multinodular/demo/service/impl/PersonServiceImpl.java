package com.heqing.mybatisplus.multinodular.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heqing.mybatisplus.multinodular.demo.mapper.PersonMapper;
import com.heqing.mybatisplus.multinodular.demo.model.po.PersonPO;
import com.heqing.mybatisplus.multinodular.demo.service.IPersonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author heqing
 * @since 2021-07-21
 */
@Service("personService")
public class PersonServiceImpl extends ServiceImpl<PersonMapper, PersonPO> implements IPersonService {

    @Resource
    PersonMapper personMapper;

    @Override
    public PersonPO selectPersonById(Long id) {
        return personMapper.selectPersonById(id);
    }
}
