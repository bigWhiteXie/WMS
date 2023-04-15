package com.tjut.auth.model.dto;

import com.tjut.auth.model.po.TSDepart;
import com.tjut.auth.model.po.TSFunction;
import com.tjut.auth.model.po.TSUser;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class UserDto {
    private String userId;
    private String username;
    private String departId;
    private String departName;

}
