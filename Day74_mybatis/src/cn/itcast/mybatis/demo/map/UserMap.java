package cn.itcast.mybatis.demo.map;

import cn.itcast.mybatis.demo.domain.User;

public interface UserMap {
	public User findOneById(Integer id);
}
