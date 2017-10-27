package com.yh.st.base.config.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * 
 * @author Administrator
 * 
 */
public class UsernamePasswordCaptchaToken extends UsernamePasswordToken {

	private static final long serialVersionUID = 1L;

	private String captcha;

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public UsernamePasswordCaptchaToken() {
		super();

	}

	public UsernamePasswordCaptchaToken(String username, char[] password,
			String captcha) {
		super(username, password);
		this.captcha = captcha;
	}

}
