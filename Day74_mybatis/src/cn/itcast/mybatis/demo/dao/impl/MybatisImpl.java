package cn.itcast.mybatis.demo.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.itcast.mybatis.demo.dao.MybatisDao;
import cn.itcast.mybatis.demo.domain.User;

public class MybatisImpl implements MybatisDao{
	//工厂属性
	private SqlSessionFactory factory ;
	public MybatisImpl(SqlSessionFactory factory) {
		super();
		this.factory = factory;
	}

	@Override
	public User findOneById(Integer id) {
		
		SqlSession session = factory.openSession();
		//执行sql语句
		User user = session.selectOne("findOneById", id);
		
		System.out.println(user);
		
		session.close();
		return user;
	}

	
}
