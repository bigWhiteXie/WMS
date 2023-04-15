package com.tjut.auth.model.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * InnoDB free: 600064 kB; (`parentfunctionid`) REFER `jeecg/t_
 * </p>
 *
 * @author codeXie
 */
@Data
@TableName("t_s_function")
public class TSFunction implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId("ID")
    private String id;

    /**
     * 菜单地址打开方式
     */
    private Integer functioniframe;

    /**
     * 菜单等级
     */
    private Integer functionlevel;

    /**
     * 菜单名字
     */
    private String functionname;

    /**
     * 排序
     */
    private String functionorder;

    /**
     * URL
     */
    private String functionurl;

    /**
     * 父菜单ID
     */
    private String parentfunctionid;

    /**
     * 图标ID
     */
    private String iconid;

    /**
     * 桌面图标ID
     */
    private String deskIconid;

    /**
     * 菜单类型
     */
    private Integer functiontype;

    /**
     * ace图标样式
     */
    private String functionIconStyle;

    /**
     * 创建人id
     */
    private String createBy;

    /**
     * 创建人
     */
    private String createName;

    /**
     * 修改人id
     */
    private String updateBy;

    /**
     * 修改时间
     */
    private LocalDateTime updateDate;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createDate;

    /**
     * 修改人
     */
    private String updateName;


}
