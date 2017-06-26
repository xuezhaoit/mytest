package cn.itcast.mybatis.demo.map;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.lf5.util.Resource;
import org.junit.Test;

import cn.itcast.mybatis.demo.domain.User;

public class TestUserMap {
	@Test
	public void test() throws IOException{
		SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
		InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
		SqlSessionFactory build = factoryBuilder.build(in);
		SqlSession session = build.openSession();
		UserMap mapper = session.getMapper(UserMap.class);
		User user = mapper.findOneById(1);
		System.out.println(user);
		
	}
}
