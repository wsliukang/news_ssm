package cn.lk.newsssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.lk.newsssm.entity.News;

public interface NewsDao {

	/*Long countofNews();*/

	void add(News news);

	News get(@Param("id")int id);

	void delete(News u);

	void update(News news);

	List<News> list(@Param("s1") String title,@Param("offset") int page, @Param("rows")int rows);

	int getCount();

}
