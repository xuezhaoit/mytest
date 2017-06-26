package cn.itcast.mybatis.demo.dao;

import java.util.List;

import cn.itcast.mybatis.demo.domain.User;

public interface MybatisDao {
	User findOneById(Integer id);
	
}
