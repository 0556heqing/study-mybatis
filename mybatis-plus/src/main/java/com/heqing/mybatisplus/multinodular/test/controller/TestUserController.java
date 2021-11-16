package com.heqing.mybatisplus.multinodular.test.controller;

import com.heqing.mybatisplus.multinodular.test.model.po.TestUserPO;
import com.heqing.mybatisplus.multinodular.test.service.ITestUserService;
import com.heqing.mybatisplus.dto.ResponseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author heqing
 * @since 2021-07-21
 */
@RestController
@RequestMapping("/test-user-po")
public class TestUserController {


	@Autowired
    private ITestUserService testUserService;


    /**
     * 获取全部数据
     */
    @RequestMapping("/all")
    @ResponseBody
    public ResponseInfo<?> findAll(){
        List<TestUserPO> models = testUserService.list();
        return ResponseInfo.buildSuccess(models);
    }


    /**
     * 根据ID查找数据
     */
    @RequestMapping("/find")
    @ResponseBody
    public ResponseInfo<?> find(@RequestParam("id") Long id){
        TestUserPO po = testUserService.getById(id);
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
    public ResponseInfo<?> addItem(@RequestBody TestUserPO requestVo){
        if(testUserService.save(requestVo)){
            return ResponseInfo.buildSuccess();
        }
        return ResponseInfo.buildError("数据添加失败");
    }


    /**
     * 批量添加数据
     */
    @RequestMapping(value = "/batchAdd", method = RequestMethod.POST)
    @ResponseBody
    public ResponseInfo<?> addItem(@RequestBody List<TestUserPO> requestVo){
        if(testUserService.saveBatch(requestVo)){
            return ResponseInfo.buildSuccess();
        }
        return ResponseInfo.buildError("数据添加失败");
    }


    /**
     * 更新数据
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseInfo<?> updateItem(@RequestBody TestUserPO requestVo){
        if(testUserService.updateById(requestVo)){
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
        if(testUserService.removeByIds(ids)){
            return ResponseInfo.buildSuccess();
        }
        return ResponseInfo.buildError("数据删除失败");
    }
}

