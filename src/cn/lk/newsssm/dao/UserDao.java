package cn.lk.newsssm.dao;

import org.apache.ibatis.annotations.Param;

import cn.lk.newsssm.entity.User;

public interface UserDao {

	void add(User user);

	User get(@Param("uid")String uid,@Param("pwd") String pwd);

	Long countofUser();

}
