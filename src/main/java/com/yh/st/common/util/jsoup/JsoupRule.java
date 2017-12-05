package com.yh.st.common.util.jsoup;

public class JsoupRule {
	private String url;// 请求的URL

	private String[] paramNames;// 请求的参数名称

	private String[] paramValues;// 请求的参数值

	private int requestMethod;// 请求的方式

	public JsoupRule() {
		super();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String[] getParamNames() {
		return paramNames;
	}

	public void setParamNames(String[] paramNames) {
		this.paramNames = paramNames;
	}

	public String[] getParamValues() {
		return paramValues;
	}

	public void setParamValues(String[] paramValues) {
		this.paramValues = paramValues;
	}

	public int getRequestMethod() {
		return requestMethod;
	}

	public void setRequestMethod(int requestMethod) {
		this.requestMethod = requestMethod;
	}

}
