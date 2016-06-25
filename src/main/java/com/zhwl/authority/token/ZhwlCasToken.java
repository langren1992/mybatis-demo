package com.zhwl.authority.token;

import org.apache.shiro.authc.RememberMeAuthenticationToken;
import org.jasig.cas.client.authentication.AttributePrincipal;

/**
 * @ClassName: ZhwlCasToken
 * @Description: 整合CAS的密码主体(这里用一句话描述这个类的作用)
 * @author Administrator
 * @date 2016年6月11日 下午3:53:47
 * 
 */
public class ZhwlCasToken implements RememberMeAuthenticationToken{

	/**  
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */   
    private static final long serialVersionUID = 3799272138671567827L;
    private AttributePrincipal principal;
    private String userId;
    
    public ZhwlCasToken(String userId, AttributePrincipal principal) {
        this.userId = userId;
        this.principal = principal;
    }
    @Override
    public Object getPrincipal() {
        return this.principal;
    }

    @Override
    public Object getCredentials() {
        return this.userId;
    }

    @Override
    public boolean isRememberMe() {
        // TODO Auto-generated method stub
        return false;
    }

}
