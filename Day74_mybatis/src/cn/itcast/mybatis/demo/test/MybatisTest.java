package cn.itcast.mybatis.demo.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.lf5.util.Resource;
import org.junit.Test;

import cn.itcast.mybatis.demo.domain.User;

public class MybatisTest {
	//建立工厂builder
	SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
	SqlSessionFactory factory = null;
	/**
	 * 通过id查找一条数据
	 * @throws IOException 
	 */
	@Test
	public void findOneById() throws IOException{
		//创建io流
		InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
		//创建工厂
		factory = factoryBuilder.build(in);
		//创建session
		SqlSession session = factory.openSession();
		//执行sql语句
		User user = (User)session.selectOne("test.findOneById", 1);
		
		System.out.println(user);
		session.close();
	}
	
	/**
	 * 模糊查询
	 * @throws IOException 
	 */
	@Test
	public void findByLike() throws IOException{
		//创建io流
		InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
		//创建工厂
		factory = factoryBuilder.build(in);
		//创建session
		SqlSession session = factory.openSession();
		//执行sql语句
		//方式一
		
		//List<User> user = session.selectList("findByLike","明");
		List<User> user = session.selectList("findByLikea","明");
		for (User user2 : user) {
			System.out.println(user2);
		}
		session.close();
	}
	
	/**
	 * 添加
	 * @throws IOException 
	 */
	@Test
	public void insert() throws IOException{
		//创建io流
		InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		//创建工厂
		factory = factoryBuilder.build(inputStream);
		//创建session对象
		SqlSession session = factory.openSession();
		//创建user对象
		User user = new User();
		user.setUsername("张三男");
		user.setBirthday(new Date());
		user.setSex("2");
		user.setAddress("japan");
		//执行sql语句
		session.insert("insert", user);
		session.commit();
		session.close();
		
	}
	
	/**
	 * 更改
	 * @throws IOException 
	 */
	@Test
	public void update() throws IOException{
		//创建io流
		InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		//创建工厂
		factory = factoryBuilder.build(inputStream);
		//创建session对象
		SqlSession session = factory.openSession();
		//创建user对象
		User user = new User();
		user.setId(27);
		user.setUsername("李四男");
		
		//执行sql语句
		session.update("update", user);
		session.commit();
		User user2 = session.selectOne("findOneById", 27);
		System.out.println(user2);
		session.close();
		
	}
	
	/**
	 * 删除
	 * @throws IOException 
	 */
	@Test
	public void delete() throws IOException{
		//创建io流
		InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		//创建工厂
		factory = factoryBuilder.build(inputStream);
		//创建session对象
		SqlSession session = factory.openSession();
		
		//执行sql语句
		session.delete("delete", 27);
		session.commit();
		
		session.close();
		
	}
}
