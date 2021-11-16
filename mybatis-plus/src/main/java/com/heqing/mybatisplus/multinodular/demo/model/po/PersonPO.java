package com.heqing.mybatisplus.multinodular.demo.model.po;

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
 * 用户
 * </p>
 *
 * @author heqing
 * @since 2021-07-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("person")
public class PersonPO implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 姓名
     */
    @TableField("name")
    private String name;

    /**
     * 性别
     */
    @TableField("sex")
    private Integer sex;

    /**
     * 生日
     */
    @TableField("birthday")
    private Date birthday;

    /**
     * 省份
     */
    @TableField("addr_province")
    private String addrProvince;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;


}
