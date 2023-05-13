package com.tjut.common.exception;

import lombok.Data;

/**
 * @author codeXie
 * @version 1.0
 * @description TODO
 * @date 2022/10/10 9:14
 */
@Data
public class WmsException extends RuntimeException {
    private int code;
    private String errMessage;

    public WmsException() {
        super();
    }

    public WmsException(int code,String message) {
        super(message);
        this.errMessage = message;
        this.code = code;
    }

    public String getErrMessage(){
        return errMessage;
    }

    public static void cast(int code,String errMessage){
        throw new WmsException(code,errMessage);
    }
    public static void cast(CommonError commonError){
        throw new WmsException(commonError.getCode(),commonError.getErrMessage());
    }
}
