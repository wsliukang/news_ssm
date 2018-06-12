package cn.lk.newsssm.service;

import java.util.List;

import cn.lk.newsssm.entity.News;

public interface NewsService {
	
	void addNews(News news) throws Exception;
	
	void deleteNews(int id) throws Exception;
	
	void updateNews(News news) throws Exception;
	
	List<News> listDgNews(String title,int page,int rows);
	
	News getNews( int id);
	
	int getNewsCount();

	int getCout();
	
	

}
