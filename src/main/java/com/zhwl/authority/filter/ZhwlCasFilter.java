package com.zhwl.authority.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.cas.CasFilter;
import org.jasig.cas.client.authentication.AttributePrincipal;

import com.zhwl.authority.token.ZhwlCasToken;


/**
 * @ClassName: ZhwlCasFilter
 * @Description: 整合单点登陆时的CASFILTER(这里用一句话描述这个类的作用)
 * @author Administrator
 * @date 2016年6月11日 下午3:52:50
 * 
 */
public class ZhwlCasFilter extends CasFilter {
	
	@Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        AttributePrincipal principal = (AttributePrincipal) httpRequest.getUserPrincipal();
        Object userId = principal.getAttributes().get("userId");//当然前提是cas服务端已经将userId放置到principal中
        return new ZhwlCasToken(userId.toString(), principal);
    }

}
