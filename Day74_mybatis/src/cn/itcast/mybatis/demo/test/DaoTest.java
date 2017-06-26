package cn.itcast.mybatis.demo.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.itcast.mybatis.demo.dao.MybatisDao;
import cn.itcast.mybatis.demo.dao.impl.MybatisImpl;
import cn.itcast.mybatis.demo.domain.User;

public class DaoTest {
	
	
	//��������builder
	SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
	SqlSessionFactory factory = null;
	/**
	 * ͨ��id����һ������
	 * @throws IOException 
	 */
	@Test
	public void findOneById() throws IOException{
		//����io��
		InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
		//��������
		factory = factoryBuilder.build(in);
		MybatisDao mybatisDao = new MybatisImpl(factory);
		User user = mybatisDao.findOneById(1);
		
		System.out.println(user);
		
	}
}
