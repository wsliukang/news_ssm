package cn.lk.newsssm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.lk.newsssm.dao.MenuDao;
import cn.lk.newsssm.entity.Cmenu;
import cn.lk.newsssm.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {

	@Resource
	private MenuDao dao;
	
	@Override
	public List<Cmenu> listMenu(int pid) {
		// TODO Auto-generated method stub
		return dao.list(pid);
	}
	

}
