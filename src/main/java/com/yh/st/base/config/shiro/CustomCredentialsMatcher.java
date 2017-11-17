package com.yh.st.base.config.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

import com.yh.st.base.Constant;
import com.yh.st.common.util.MD5;
/**
 * 
 * @author yh
 * @Date 2017年10月27日
 * @desc
 */
public class CustomCredentialsMatcher extends SimpleCredentialsMatcher {
	@Override
	public boolean doCredentialsMatch(AuthenticationToken authcToken,
			AuthenticationInfo info) {
		UsernamePasswordCaptchaToken token = (UsernamePasswordCaptchaToken) authcToken;
		Object accountCredentials = getCredentials(info);
		try {
			String password = String.valueOf(token.getPassword());
			return equals(MD5.md5Encode(Constant.PWD_PRFIX+password), accountCredentials);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
