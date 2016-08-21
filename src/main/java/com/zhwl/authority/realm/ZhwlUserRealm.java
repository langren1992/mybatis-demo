package com.zhwl.authority.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhwl.basis.model.TsUser;
import com.zhwl.basis.service.TsUserService;


/**
 * @ClassName: UserRealm
 * @Description: 用户的权限管理(这里用一句话描述这个类的作用)
 * @author Administrator
 * @date 2016年2月28日 下午4:53:21
 * 
 */
public class ZhwlUserRealm extends AuthorizingRealm {

	@Autowired
	private TsUserService tsUserService;

	/**
	 * 登陆后的权限校验
	 * */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		String username = (String) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//		authorizationInfo.setRoles(userService.findRoles(username));
//		authorizationInfo.setStringPermissions(userService
//				.findPermissions(username));
//		System.out.println(userService.findPermissions(username));
		return authorizationInfo;
	}

	/**
	 * 登陆时的权限校验及密码注入
	 * */
	@SuppressWarnings("unused")
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		TsUser user= tsUserService.findByUsername(new TsUser(username));
		if (user == null) {
			throw new UnknownAccountException();// 没找到帐号
		}
		if (Boolean.TRUE.equals(user.getUserStatus())) {
			throw new LockedAccountException(); // 帐号锁定
		}
		return new SimpleAuthenticationInfo(user.getUserNo(), // 用户名
				user.getUserPassword(), // 密码
				ByteSource.Util.bytes(user.getUserNo()+user.getUserSalt()),// salt=username+salt
				this.getName() // realm name
		);
	}

	@Override
	public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
		super.clearCachedAuthorizationInfo(principals);
	}

	@Override
	public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
		super.clearCachedAuthenticationInfo(principals);
	}

	@Override
	public void clearCache(PrincipalCollection principals) {
		super.clearCache(principals);
	}

	public void clearAllCachedAuthorizationInfo() {
		getAuthorizationCache().clear();
	}

	public void clearAllCachedAuthenticationInfo() {
		getAuthenticationCache().clear();
	}

	public void clearAllCache() {
		clearAllCachedAuthenticationInfo();
		clearAllCachedAuthorizationInfo();
	}
}
