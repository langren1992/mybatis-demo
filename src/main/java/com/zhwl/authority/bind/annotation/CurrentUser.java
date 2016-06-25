package com.zhwl.authority.bind.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.zhwl.common.util.Constants;


/**
 * @ClassName: CurrentUser
 * @Description: 绑定当前登录的用户，不同于@ModelAttribute(这里用一句话描述这个类的作用)
 * @author Administrator
 * @date 2016年6月11日 下午4:42:58
 * 
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentUser {
	
    /** 
     * @Title: value 
     * @Description: 当前用户在request中的名字(这里用一句话描述这个方法的作用) 
     * @author Administrator
     * @return String 返回类型 
     * @throws 
     */ 
    String value() default Constants.CURRENT_USER;
}
