package com.tjut.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tjut.auth.model.dto.MenuDto;
import com.tjut.auth.model.po.TSFunction;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * InnoDB free: 600064 kB; (`parentfunctionid`) REFER `jeecg/t_ Mapper 接口
 * </p>
 *
 * @author codeXie
 */
public interface TSFunctionMapper extends BaseMapper<TSFunction> {
    List<MenuDto> getMenuTree(@Param("list") List<String> list);

}
