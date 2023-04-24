package com.tjut.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WmsResp<T> {
    int code;
    T data;

    public static  <R> WmsResp<R> success(R data){
        return new WmsResp<R>(200,data);
    }

    public static  WmsResp<String> fail(String info){
        return new WmsResp<String>(500,info);
    }
}
