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
@TableName("t_s_user_org")
public class TSUserOrg implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId("ID")
    private String id;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 部门id
     */
    private String orgId;


}
