package com.tjut.auth.model.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * InnoDB free: 599040 kB; (`iconid`) REFER `jeecg/t_s_icon`(`I
 * </p>
 *
 * @author codeXie
 */
@Data
@TableName("t_s_operation")
public class TSOperation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId("ID")
    private String id;

    /**
     * 页面控件code
     */
    private String operationcode;

    /**
     * 图标
     */
    private String operationicon;

    /**
     * 页面名字
     */
    private String operationname;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 菜单ID
     */
    private String functionid;

    /**
     * 图标ID
     */
    private String iconid;

    /**
     * 规则类型：1/禁用 0/隐藏
     */
    private Integer operationtype;


}
