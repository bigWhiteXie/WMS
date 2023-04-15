package com.tjut.auth.model;

import lombok.Data;

@Data
public class UserDto {
    private TSUser user;
    private TSDepart depart;

    public UserDto(TSUser user, TSDepart depart) {
        this.user = user;
        this.depart = depart;
    }
}
