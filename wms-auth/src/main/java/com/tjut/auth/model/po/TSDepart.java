package com.tjut.auth.model.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author codeXie
 */
@Data
@TableName("t_s_depart")
public class TSDepart implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId("ID")
    private String id;

    /**
     * 部门名称
     */
    private String departname;

    /**
     * 描述
     */
    private String description;

    /**
     * 父部门ID
     */
    private String parentdepartid;

    /**
     * 机构编码
     */
    private String orgCode;

    /**
     * 机构类型
     */
    private String orgType;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 传真
     */
    private String fax;

    /**
     * 地址
     */
    private String address;

    /**
     * 排序
     */
    private String departOrder;


}
