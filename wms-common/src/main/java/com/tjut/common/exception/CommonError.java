
package com.tjut.common.exception;




/**
 * @description 通用错误信息
 * @author codeXie
 * @date 2022/9/6 11:29
 * @version 1.0
 */

public enum CommonError {

	UNKOWN_ERROR(101,"执行过程异常，请重试。"),
	PARAMS_ERROR(102,"非法参数"),
	OBJECT_NULL(103,"对象为空"),
	QUERY_NULL(104,"查询结果为空"),
	REQUEST_NULL(105,"请求参数为空");
	private int code;
	private String errMessage;

	public String getErrMessage() {
		return errMessage;
	}

	private CommonError( int code,String errMessage) {
		this.errMessage = errMessage;
		this.code = code;
	}

	public int getCode() {
		return code;
	}
}
