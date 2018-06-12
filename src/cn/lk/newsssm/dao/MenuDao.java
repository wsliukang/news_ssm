package cn.lk.newsssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.lk.newsssm.entity.Cmenu;

public interface MenuDao {

	public List<Cmenu> list(@Param("id") int pid);

}
