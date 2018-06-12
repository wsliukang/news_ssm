package cn.lk.newsssm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.lk.newsssm.dao.CommentDao;
import cn.lk.newsssm.dao.NewsDao;
import cn.lk.newsssm.entity.Comment;
import cn.lk.newsssm.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Resource
	private CommentDao dao;

	@Override
	public void addComment(Comment comment) {
		// TODO Auto-generated method stub
		dao.insertSelective(comment);
	}
	
	@Override
	public void deleteComment(int id) {
		// TODO Auto-generated method stub
		dao.deleteByPrimaryKey(id);
	}
	
	@Override
	public List<Comment> listComments(int newsId) {
		// TODO Auto-generated method stub
		return dao.getCommentsByNewsId(newsId);
	}

	@Override
	public int getComentCount(int newsId) {
		// TODO Auto-generated method stub
		return dao.getCount(newsId);
	}

	@Override
	public List<Comment> listDgComment(int newsId, int page, int rows) {
		// TODO Auto-generated method stub
		if (page < 1) {
			page = 1;
			}
			if (rows < 1) {
			rows = 10;
			}
			page=(page-1)*rows;
		return dao.list(newsId, page, rows);
	}

	@Override
	public void approve(int id, int favour) {
		// TODO Auto-generated method stub
		dao.approve(id,favour);
	}

	@Override
	public void disapprove(int id, int disfavour) {
		// TODO Auto-generated method stub
		dao.disapprove(id,disfavour);
	}

	

}
