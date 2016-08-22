package com.zhwl.demo.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

import junit.framework.Assert;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tk.mybatis.mapper.entity.Example;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhwl.authority.mapper.RaUserRoleMapper;
import com.zhwl.authority.model.RaUserRole;
import com.zhwl.basis.mapper.TsUserMapper;
import com.zhwl.basis.model.TsRole;
import com.zhwl.basis.model.TsUser;
import com.zhwl.basis.service.TsUserService;
import com.zhwl.common.IdWorker;

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
//			final TsUserMapper mapper = sqlSession.getMapper(TsUserMapper.class);
//			PageHelper.startPage(1, 10);
//			List<TsUser> list = mapper.selectAll();
//			String findUserRole = mapper.findUserRole("000");
//			System.out.println(findUserRole);
//			PageInfo<TsUser> page = new PageInfo<TsUser>(list);
//			page.set
//			assertEquals(183, list.size());
//	        assertEquals(183, page.getTotal());
//			TsUser role = new TsUser();
//			role.setUserNo("3");;
//			//jdk6,7用法，创建接口
//			Page<TsUser> paging = PageHelper.startPage(1, 10).setOrderBy("USER_ID desc").doSelectPage(new ISelect() {
//			    @Override
//			    public void doSelect() {
//			    	mapper.selectAll();
//			    }
//			});
			
			
			final RaUserRoleMapper mapper = sqlSession.getMapper(RaUserRoleMapper.class);
			PageHelper.startPage(1, 10);
			Set<String> findUserRole = mapper.findRoleByUser("admin");
			System.out.println(findUserRole);
//			RaUserRole raUserRole = new RaUserRole();
//			raUserRole.setUrUserNo("admin");
//			raUserRole.setUrRoleNo("000001");
//			raUserRole.setCreateTime(new Date());
//			raUserRole.setCreator("admin");
//			raUserRole.setModifyTime(new Date());
//			raUserRole.setModifier("admin");
//			raUserRole.setRecVer(1);
//			mapper.insert(raUserRole);
			
//		    System.out.println(mapper.selectCount(role));
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

	@Test
	public void testUserService(){
		TsUserService tsUserService = ac.getBean("tsUserServiceImpl",TsUserService.class);
//		TsUser tsUser = tsUserService.findByUsername("admin");
//		TsRole role = new TsRole();
//		role.setRoleNo("000");
//		String s = tsUserService.findUserRole(role);
//		TsUser tsUser = new TsUser();
//		tsUser.setUserNo("000000");
//		tsUser.setUserName("000000");
//		tsUser.setUserPassword("000000");
//		tsUser.setUserStatus(1);
//		tsUser.setCreator("admin");
//		tsUser.setCreateTime(new Date());
//		tsUser.setModifier("admin");
//		tsUser.setModifyTime(new Date());
//		tsUser.setRecVer(0);
//		int createUser = tsUserService.createUser(tsUser);
//		System.out.println(createUser);
		
		
	}
	
	
}
