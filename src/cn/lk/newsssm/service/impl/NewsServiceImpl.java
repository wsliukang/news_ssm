package cn.lk.newsssm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.lk.newsssm.dao.NewsDao;
import cn.lk.newsssm.entity.News;
import cn.lk.newsssm.service.NewsService;


@Service
public class NewsServiceImpl implements NewsService {

	
	@Resource
	private NewsDao dao;
	
	@Override
	public void addNews(News news) throws Exception {
		// TODO Auto-generated method stub
		dao.add(news);
	}

	@Override
	public void deleteNews(int id) throws Exception {
		// TODO Auto-generated method stub
		News u =(News) dao.get(id);
		dao.delete(u);
	}

	@Override
	public void updateNews(News news) throws Exception {
		// TODO Auto-generated method stub
		dao.update(news);
	}

	@Override
	public List<News> listDgNews(String title, int page, int rows) {
		// TODO Auto-generated method stub
		if (page < 1) {
			page = 1;
			}
			if (rows < 1) {
			rows = 10;
			}
			page=(page-1)*rows;
			return dao.list(title, page, rows);
			/*if(title == null || "".equals(title)) return
			dao.list(page, rows,);
			else return dao.list(title, page, rows);*/
	}

	@Override
	public News getNews(int id) {
		// TODO Auto-generated method stub
		News news=dao.get(id);
		news.setHitnum(news.getHitnum()+1);//点击量增加
		dao.update(news);
		return news;
	}

	@Override
	public int getNewsCount() {
		// TODO Auto-generated method stub
		try{
			int a=dao.getCount();
			return a;
			}catch(Exception e){
			e.printStackTrace();
			return 0;
			}
	}

	@Override
	public int getCout() {
		// TODO Auto-generated method stub
		return dao.getCount();
	}

}
