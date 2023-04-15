package com.tjut.auth.model.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * InnoDB free: 599040 kB; (`id`) REFER `jeecg/t_s_base_user`(`
 * </p>
 *
 * @author codeXie
 */
@Data
@TableName("t_s_user")
public class TSUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    @TableField("mobilePhone")
    private String mobilephone;

    /**
     * 办公座机
     */
    @TableField("officePhone")
    private String officephone;

    /**
     * 签名文件
     */
    @TableField("signatureFile")
    private String signaturefile;

    /**
     * 修改人
     */
    private String updateName;

    /**
     * 修改时间
     */
    private LocalDateTime updateDate;

    /**
     * 修改人id
     */
    private String updateBy;

    /**
     * 创建人
     */
    private String createName;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createDate;

    /**
     * 创建人id
     */
    private String createBy;

    private String userType;


}
