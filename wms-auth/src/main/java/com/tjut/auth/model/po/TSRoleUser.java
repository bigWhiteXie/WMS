package com.tjut.auth.model.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * InnoDB free: 599040 kB; (`userid`) REFER `jeecg/t_s_user`(`i
 * </p>
 *
 * @author codeXie
 */
@Data
@TableName("t_s_role_user")
public class TSRoleUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId("ID")
    private String id;

    /**
     * 角色ID
     */
    private String roleid;

    /**
     * 用户ID
     */
    private String userid;


}
