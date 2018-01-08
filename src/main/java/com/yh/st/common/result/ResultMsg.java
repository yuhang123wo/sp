package com.yh.st.common.result;

public class ResultMsg {
	/** 返回信息码 */
	protected String rspCode = "0";
	/** 返回信息内容 */
	protected String rspMsg = "操作成功";

	public static String FAILCODE = "-1";

	public ResultMsg() {
	}

	public ResultMsg(ExceptionMsg msg) {
		this.rspCode = msg.getCode();
		this.rspMsg = msg.getMsg();
	}

	public ResultMsg(String rspCode) {
		this.rspCode = rspCode;
		this.rspMsg = "";
	}

	public ResultMsg(String rspCode, String rspMsg) {
		this.rspCode = rspCode;
		this.rspMsg = rspMsg;
	}

	public String getRspCode() {
		return rspCode;
	}

	public void setRspCode(String rspCode) {
		this.rspCode = rspCode;
	}

	public String getRspMsg() {
		return rspMsg;
	}

	public void setRspMsg(String rspMsg) {
		this.rspMsg = rspMsg;
	}

	@Override
	public String toString() {
		return "Response{" + "rspCode='" + rspCode + '\'' + ", rspMsg='" + rspMsg + '\'' + '}';
	}
}
