package com.zhwl.authority.realm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cas.CasAuthenticationException;
import org.apache.shiro.cas.CasRealm;
import org.apache.shiro.cas.CasToken;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.util.StringUtils;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.validation.Assertion;
import org.jasig.cas.client.validation.TicketValidationException;
import org.jasig.cas.client.validation.TicketValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhwl.authority.service.UserService;
import com.zhwl.common.util.Constants;

/**
 * @ClassName: ZhwlCasRealm
 * @Description: 整合CAS单点登陆时的Realm(这里用一句话描述这个类的作用)
 * @author Administrator
 * @date 2016年6月11日 下午3:52:05
 * 
 */
public class ZhwlCasRealm extends CasRealm {

	private UserService userService;

	@Autowired
	private CacheManager cacheManager;

	private final static Logger log = LoggerFactory
			.getLogger(ZhwlCasRealm.class);

	public ZhwlCasRealm() {
		super();
		setCacheManager(cacheManager);
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		CasToken casToken = (CasToken) token;
		if (token == null)
			return null;
		String ticket = (String) casToken.getCredentials();
		if (!StringUtils.hasText(ticket))
			return null;
		TicketValidator ticketValidator = ensureTicketValidator();
		try {
			Assertion casAssertion = ticketValidator.validate(ticket,
					getCasService());
			AttributePrincipal casPrincipal = casAssertion.getPrincipal();
			String userId = casPrincipal.getName();
			log.debug(
					"Validate ticket : {} in CAS server : {} to retrieve user : {}",
					new Object[] { ticket, getCasServerUrlPrefix(), userId });
			Map attributes = casPrincipal.getAttributes();
			casToken.setUserId(userId);
			String rememberMeAttributeName = getRememberMeAttributeName();
			String rememberMeStringValue = (String) attributes
					.get(rememberMeAttributeName);
			boolean isRemembered = rememberMeStringValue != null
					&& Boolean.parseBoolean(rememberMeStringValue);
			if (isRemembered)
				casToken.setRememberMe(true);
			List principals = CollectionUtils.asList(new Object[] { userId,
					attributes });
			PrincipalCollection principalCollection = new SimplePrincipalCollection(
					principals, getName());

			// 这里可以拿到Cas的登录账号信息,加载到对应权限体系信息放到缓存中...

			return new SimpleAuthenticationInfo(principalCollection, ticket);
		} catch (TicketValidationException e) {
			throw new CasAuthenticationException((new StringBuilder())
					.append("Unable to validate ticket [").append(ticket)
					.append("]").toString(), e);
		}
	}

	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		SimplePrincipalCollection principalCollection = (SimplePrincipalCollection) principals;
		List listPrincipals = principalCollection.asList();
		Map attributes = (Map) listPrincipals.get(1);
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		addRoles(simpleAuthorizationInfo, split(getDefaultRoles()));
		return simpleAuthorizationInfo;
	}

	protected List split(String s) {
		List list = new ArrayList();
		String elements[] = StringUtils.split(s, ',');
		if (elements != null && elements.length > 0) {
			String arr$[] = elements;
			int len$ = arr$.length;
			for (int i$ = 0; i$ < len$; i$++) {
				String element = arr$[i$];
				if (StringUtils.hasText(element))
					list.add(element.trim());
			}

		}
		return list;
	}

	protected void addRoles(SimpleAuthorizationInfo simpleAuthorizationInfo,
			List roles) {
		String role;
		for (Iterator i$ = roles.iterator(); i$.hasNext(); simpleAuthorizationInfo
				.addRole(role))
			role = (String) i$.next();

	}

	protected void addPermissions(
			SimpleAuthorizationInfo simpleAuthorizationInfo, List permissions) {
		String permission;
		for (Iterator i$ = permissions.iterator(); i$.hasNext(); simpleAuthorizationInfo
				.addStringPermission(permission))
			permission = (String) i$.next();

	}

	/** 重写退出时缓存处理方法 */
	protected void doClearCache(PrincipalCollection principals) {
		Object principal = principals.getPrimaryPrincipal();
		try {
			getCache().remove(principal);
			log.debug(new StringBuffer().append(principal)
					.append(" on logout to remove the cache [")
					.append(principal).append("]").toString());
		} catch (CacheException e) {
			log.error(e.getMessage());
		}
	}

	/** 获取缓存管理器的缓存堆实例 */
	protected Cache<Object, Object> getCache() throws CacheException {
		return cacheManager.getCache(Constants.CURRENT_USER);
	}

	public CacheManager getCacheManager() {
		return cacheManager;
	}

	public void setCacheManager(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}
}
