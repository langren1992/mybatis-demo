package com.zhwl.authority.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhwl.basis.model.TsUser;
import com.zhwl.basis.service.TsUserService;
import com.zhwl.common.util.Constants;



public class ZhwlUserFilter extends PathMatchingFilter {

    @Autowired
    private TsUserService tsUserService;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        String username = (String)SecurityUtils.getSubject().getPrincipal();
        
        request.setAttribute(Constants.CURRENT_USER, tsUserService.findByUsername(new TsUser(username)));
        return true;
    }
}
