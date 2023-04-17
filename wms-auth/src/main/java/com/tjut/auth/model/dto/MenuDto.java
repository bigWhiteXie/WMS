package com.tjut.auth.model.dto;

import com.tjut.auth.mapper.TSFunctionMapper;
import com.tjut.auth.model.po.TSFunction;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MenuDto extends TSFunction{
    private List<MenuDto> childNodes = new ArrayList<>();
}
