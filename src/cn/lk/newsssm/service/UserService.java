package cn.lk.newsssm.service;

import cn.lk.newsssm.entity.User;

public interface UserService {
	
	void addU(User user);
	
	User findU(String uid, String pwd);
	
	Long getCount();
}
