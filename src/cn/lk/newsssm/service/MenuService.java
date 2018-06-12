package cn.lk.newsssm.service;

import java.util.List;

import cn.lk.newsssm.entity.Cmenu;

public interface MenuService {
	
	List<Cmenu> listMenu(int pid);

}
