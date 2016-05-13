package com.chj.common.api.base;

import java.io.Serializable;

public class ResponseData implements Serializable {

	private static final long serialVersionUID = 1L;
	private Code code;
	private Object data;

	public ResponseData() {
	}

	public Code getCode() {
		return code;
	}

	public void setCode(Code code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public static ResponseData getSuccess(Object data) {
		ResponseData response = new ResponseData();
		response.setCode(Code.SUCCESS);
		response.setData(data);
		return response;
	}

}
