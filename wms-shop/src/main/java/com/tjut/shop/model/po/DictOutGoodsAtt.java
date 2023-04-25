package com.tjut.shop.model.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author codeXie
 */
@Data
@TableName("dict_out_goods_att")
public class DictOutGoodsAtt implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 枚举代码
     */
    private Integer code;

    /**
     * 名称
     */
    private String name;

    /**
     * 修改时间
     */
    private LocalDateTime updateDate;

    /**
     * 修改人
     */
    private String updateName;

    /**
     * 修改人账号
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
     * 创建人
     */
    private String createBy;


}
