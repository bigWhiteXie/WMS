package com.tjut.auth.model.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * InnoDB free: 599040 kB; (`roleid`) REFER `jeecg/t_s_role`(`I
 * </p>
 *
 * @author codeXie
 */
@Data
@TableName("t_s_role_function")
public class TSRoleFunction implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId("ID")
    private String id;

    /**
     * 页面控件权限编码
     */
    private String operation;

    /**
     * 菜单ID
     */
    private String functionid;

    /**
     * 角色ID
     */
    private String roleid;

    /**
     * 数据权限规则ID
     */
    private String datarule;


}
