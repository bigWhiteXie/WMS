package com.tjut.common.model;


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
public class TSDepart implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
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
