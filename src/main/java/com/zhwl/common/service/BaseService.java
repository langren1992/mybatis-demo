package com.zhwl.common.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;

public class BaseService extends SqlSessionTemplate {

	/**
	 * @Fields sqlSessionFactory : TODO(用一句话描述这个变量表示什么)
	 */
	private SqlSessionFactory sqlSessionFactory;

	public BaseService(SqlSessionFactory sqlSessionFactory) {
		super(sqlSessionFactory);
		this.sqlSessionFactory = sqlSessionFactory;
	}

	/** 
	 * @Title: getSqlSession 
	 * @Description: 获取SESSION(这里用一句话描述这个方法的作用) 
	 * @author Administrator
	 * @return SqlSession 返回类型 
	 * @throws 
	 */ 
	public SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}

}
