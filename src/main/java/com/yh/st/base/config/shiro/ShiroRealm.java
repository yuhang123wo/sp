package com.yh.st.base.config.shiro;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.yh.st.base.domain.Userinfo;
import com.yh.st.base.exception.UserNotExistException;
import com.yh.st.base.service.UserinfoService;

public class ShiroRealm extends AuthorizingRealm {

	@Resource
	private UserinfoService userinfoService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		System.out.println(12345678);
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
			throws AuthenticationException {
		UsernamePasswordCaptchaToken token = (UsernamePasswordCaptchaToken) authcToken;
		try {
			Userinfo u = userinfoService.findUserByUserName(token.getUsername());
			if (u == null) {
				throw new UserNotExistException();
			}
			AuthenticationInfo info = new SimpleAuthenticationInfo(u, u.getPassword(),
					u.getUsername());
			return info;
		} catch (UserNotExistException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
