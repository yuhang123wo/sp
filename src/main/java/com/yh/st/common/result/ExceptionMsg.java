package com.yh.st.common.result;

public enum ExceptionMsg {
	SUCCESS("0", "操作成功"),
	FAILED("999999", "操作失败"),
	PARAMERROR("000001","参数错误！");
	private ExceptionMsg(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	private String code;
	private String msg;

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

}
