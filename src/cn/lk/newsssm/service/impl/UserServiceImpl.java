package cn.lk.newsssm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.lk.newsssm.dao.UserDao;
import cn.lk.newsssm.entity.User;
import cn.lk.newsssm.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao dao;
	
	@Override
	public void addU(User user) {
		// TODO Auto-generated method stub
		dao.add(user);
	}

	@Override
	public User findU(String uid, String pwd) {
		// TODO Auto-generated method stub
		return dao.get(uid,pwd);
	}

	@Override
	public Long getCount() {
		// TODO Auto-generated method stub
		return dao.countofUser();
	}

}
