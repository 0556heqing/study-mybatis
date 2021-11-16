package com.heqing.mybatisplus.multinodular.test.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author heqing
 * @since 2021-07-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("test_user")
public class TestUserPO implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 姓名
     */
    @TableField("name")
    private String name;

    /**
     * 年龄
     */
    @TableField("age")
    private Integer age;

    /**
     * 出生日期
     */
    @TableField("birthday")
    private Date birthday;

    /**
     * 最后修改时间
     */
    @TableField("last_update_time")
    private Date lastUpdateTime;


}
