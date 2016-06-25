package com.zhwl.demo.test;

import static org.junit.Assert.*;

import java.util.List;

import junit.framework.Assert;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tk.mybatis.mapper.entity.Example;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhwl.demo.domain.entity.RoleEntity;
import com.zhwl.demo.server.mapper.RoleMapper;

public class RoleTestCase {
	
	private static ApplicationContext ac;
	
	static{
		ac = new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
		
	}
	
	@Test
	public void testRole(){
		SqlSession sqlSession = ac.getBean("sqlSessionFactory",SqlSessionFactory.class).openSession();
		try {
		    //获取Mapper
			final RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
			PageHelper.startPage(1, 10);
			List<RoleEntity> list = mapper.selectAll();
			PageInfo<RoleEntity> page = new PageInfo<RoleEntity>(list);
//			assertEquals(183, list.size());
//	        assertEquals(183, page.getTotal());
			RoleEntity role = new RoleEntity();
			role.setCode(3);
			//jdk6,7用法，创建接口
			Page<RoleEntity> paging = PageHelper.startPage(1, 10).setOrderBy("id desc").doSelectPage(new ISelect() {
			    @Override
			    public void doSelect() {
			    	mapper.selectAll();
			    }
			});
			
			
		    System.out.println(mapper.selectCount(role));
//		    //查询100
//		    RoleEntity country = mapper.selectByPrimaryKey(100);
//		    //根据主键删除
//		    Assert.assertEquals(1, mapper.deleteByPrimaryKey(100));
//		    //查询总数
//		    Assert.assertEquals(182, mapper.selectCount(new RoleEntity()));
//		    //插入
//		    Assert.assertEquals(1, mapper.insert(country));
//		    RoleEntity role1 = new RoleEntity();
//			role1.setCode(88);
//			role1.setAlias("111111");
//			int insert = mapper.insert(role1);
//			System.out.println(insert);
//			Example e = new Example(RoleMapper.class);
//			e.createCriteria().andIsNotNull("code");
		} finally {
		    sqlSession.close();
		}
	}

}
