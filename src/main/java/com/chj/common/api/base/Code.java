package com.chj.common.api.base;

public enum Code {
	SUCCESS("200", "成功"), AUTH_ERROR("E0000", "认证授权相关错误"), DATA_ERROR("E1000", "数据处理相关错误"), BUSINESS_ERROR("E2000", "业务处理相关错误"), IG_ERROR("E3000", "IG相关错误"), SYSTEM_ERROR("E9000", "SGW Internal API Error");

	private String code;
	private String message;

	private Code(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
