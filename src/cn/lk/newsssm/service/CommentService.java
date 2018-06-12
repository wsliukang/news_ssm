package cn.lk.newsssm.service;

import java.util.List;

import cn.lk.newsssm.entity.Comment;

public interface CommentService {
	
	void addComment(Comment comment);
	
	void deleteComment(int id);

	List<Comment> listComments(int newsId);

	int getComentCount(int newsId);

	List<Comment> listDgComment(int newsId, int page, int rows);

	void approve(int id, int favour);

	void disapprove(int id, int disfavour);

}
