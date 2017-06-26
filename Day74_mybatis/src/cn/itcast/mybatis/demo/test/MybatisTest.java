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
		//����session
		SqlSession session = factory.openSession();
		//ִ��sql���
		User user = (User)session.selectOne("test.findOneById", 1);
		
		System.out.println(user);
		session.close();
	}
	
	/**
	 * ģ����ѯ
	 * @throws IOException 
	 */
	@Test
	public void findByLike() throws IOException{
		//����io��
		InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
		//��������
		factory = factoryBuilder.build(in);
		//����session
		SqlSession session = factory.openSession();
		//ִ��sql���
		//��ʽһ
		
		//List<User> user = session.selectList("findByLike","��");
		List<User> user = session.selectList("findByLikea","��");
		for (User user2 : user) {
			System.out.println(user2);
		}
		session.close();
	}
	
	/**
	 * ���
	 * @throws IOException 
	 */
	@Test
	public void insert() throws IOException{
		//����io��
		InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		//��������
		factory = factoryBuilder.build(inputStream);
		//����session����
		SqlSession session = factory.openSession();
		//����user����
		User user = new User();
		user.setUsername("������");
		user.setBirthday(new Date());
		user.setSex("2");
		user.setAddress("japan");
		//ִ��sql���
		session.insert("insert", user);
		session.commit();
		session.close();
		
	}
	
	/**
	 * ����
	 * @throws IOException 
	 */
	@Test
	public void update() throws IOException{
		//����io��
		InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		//��������
		factory = factoryBuilder.build(inputStream);
		//����session����
		SqlSession session = factory.openSession();
		//����user����
		User user = new User();
		user.setId(27);
		user.setUsername("������");
		
		//ִ��sql���
		session.update("update", user);
		session.commit();
		User user2 = session.selectOne("findOneById", 27);
		System.out.println(user2);
		session.close();
		
	}
	
	/**
	 * ɾ��
	 * @throws IOException 
	 */
	@Test
	public void delete() throws IOException{
		//����io��
		InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		//��������
		factory = factoryBuilder.build(inputStream);
		//����session����
		SqlSession session = factory.openSession();
		
		//ִ��sql���
		session.delete("delete", 27);
		session.commit();
		
		session.close();
		
	}
}
