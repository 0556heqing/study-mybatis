package com.heqing.mybatisplus.multinodular.demo.controller;

import com.heqing.mybatisplus.multinodular.demo.model.po.PersonPO;
import com.heqing.mybatisplus.multinodular.demo.service.IPersonService;
import com.heqing.mybatisplus.dto.ResponseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author heqing
 * @since 2021-07-21
 */
@RestController
@RequestMapping("/person-po")
public class PersonController {

    @Autowired
    private IPersonService personService;

    /**
     * 获取全部数据
     */
    @RequestMapping("/all")
    @ResponseBody
    public ResponseInfo<?> findAll(){
        List<PersonPO> models = personService.list();
        return ResponseInfo.buildSuccess(models);
    }


    /**
     * 根据ID查找数据
     */
    @RequestMapping("/find")
    @ResponseBody
    public ResponseInfo<?> find(@RequestParam("id") Long id){
        PersonPO po = personService.getById(id);
        if(po==null){
            return ResponseInfo.buildError("尚未查询到此ID");
        }
        return ResponseInfo.buildSuccess(po);
    }


    /**
     * 添加数据
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseInfo<?> addItem(@RequestBody PersonPO requestVo){
        if(personService.save(requestVo)){
            return ResponseInfo.buildSuccess();
        }
        return ResponseInfo.buildError("数据添加失败");
    }


    /**
     * 批量添加数据
     */
    @RequestMapping(value = "/batchAdd", method = RequestMethod.POST)
    @ResponseBody
    public ResponseInfo<?> addItem(@RequestBody List<PersonPO> requestVo){
        if(personService.saveBatch(requestVo)){
            return ResponseInfo.buildSuccess();
        }
        return ResponseInfo.buildError("数据添加失败");
    }


    /**
     * 更新数据
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseInfo<?> updateItem(@RequestBody PersonPO requestVo){
        if(personService.updateById(requestVo)){
            return ResponseInfo.buildSuccess();
        }
        return ResponseInfo.buildError("数据更改失败");
    }


    /**
     * 删除数据
     */
    @RequestMapping("/del")
    @ResponseBody
    public ResponseInfo<?> deleteItems(@RequestParam("ids") List<Long> ids){
        if(personService.removeByIds(ids)){
            return ResponseInfo.buildSuccess();
        }
        return ResponseInfo.buildError("数据删除失败");
    }
}

