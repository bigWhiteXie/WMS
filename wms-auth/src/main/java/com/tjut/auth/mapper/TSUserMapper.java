package com.tjut.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tjut.auth.model.po.TSFunction;
import com.tjut.auth.model.po.TSUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * InnoDB free: 599040 kB; (`id`) REFER `jeecg/t_s_base_user`(` Mapper 接口
 * </p>
 *
 * @author codeXie
 */
public interface TSUserMapper extends BaseMapper<TSUser> {
    List<String> getFunIds(@Param("userid") String userid);

    List<TSFunction> getFunctionByIds(@Param("list") List<String> list);
}
