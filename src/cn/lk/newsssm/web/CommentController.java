package cn.lk.newsssm.web;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.lk.newsssm.entity.Comment;
import cn.lk.newsssm.entity.News;
import cn.lk.newsssm.service.CommentService;
import cn.lk.newsssm.utils.BaseUtil;


@Controller
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	private CommentService commentService;
	private String jsonResult;
	private HashMap<String,Object> jsonobj=new HashMap<String,Object>();
	
	@RequestMapping(value = "/addComment", method = RequestMethod.POST)
	public void addComment(Comment comment, HttpServletResponse response) {
		jsonobj.clear();
		try {
			comment.setCommentTime(new Date());
			int floor=commentService.getComentCount(comment.getNewsId())+1;
			comment.setFloor(floor);
			commentService.addComment(comment);
			jsonobj.put("ok", true);
			jsonobj.put("floor", floor);
			jsonobj.put("msg", "newsread");
		} catch (Exception e) {
			e.printStackTrace();
			jsonobj.put("ok", false);
			jsonobj.put("msg", "系统错误2");
		}
		jsonResult = BaseUtil.toJson(jsonobj);
		BaseUtil.outPrint(response, jsonResult);
	}
	
	@RequestMapping(value = "/deleteComment")
	public void deleteCommen(Comment comment, Model model) {
		commentService.deleteComment(comment.getId());
	}
	
/*	@RequestMapping(value = "/listComment")
	public void getComments(int newsId, HttpServletResponse response) {
		List<Comment>list=commentService.listComments(newsId);
	}*/
	
	@RequestMapping(value = "/getCount", method = RequestMethod.GET)
	public void getCount(int newsId,HttpServletResponse response) {
		int c = 0;
		try {
			c = commentService.getComentCount(newsId);
		} catch (Exception e) {
			e.printStackTrace();
			c = 0;
		}
		jsonobj.clear();
		jsonobj.put("commentcount", c);
		jsonResult = BaseUtil.toJson(jsonobj);
		BaseUtil.outPrint(response, jsonResult);
	}
	
	@RequestMapping(value = "/listComment", method = RequestMethod.POST)
	public void listComment(int newsId, int page, int rows,
			HttpServletResponse response) {
		System.out.println(page);
		System.out.println(rows);
		List<Comment> list = commentService.listDgComment(newsId, page, rows);
		System.out.println(list.toString());
		jsonobj.clear();
		jsonobj.put("total", commentService.getComentCount(newsId));
		jsonobj.put("rows", list);
		jsonResult = BaseUtil.toJson(jsonobj);
		BaseUtil.outPrint(response, jsonResult);
	}
	
	@RequestMapping(value = "/approve", method = RequestMethod.POST)
	public void approve(int id,int favour,
			HttpServletResponse response) {
		jsonobj.clear();
		try{
			commentService.approve(id,favour+1);
			jsonobj.put("ok", true);
		}catch (Exception e) {
			jsonobj.put("ok", false);
			e.printStackTrace();
		}
		jsonResult = BaseUtil.toJson(jsonobj);
		BaseUtil.outPrint(response, jsonResult);
	}
	
	@RequestMapping(value = "/disapprove", method = RequestMethod.POST)
	public void disapprove(int id,int disfavour,
			HttpServletResponse response) {
		jsonobj.clear();
		try{
			commentService.disapprove(id,disfavour+1);
			jsonobj.put("ok", true);
		}catch (Exception e) {
			jsonobj.put("ok", false);
			e.printStackTrace();
		}
		jsonResult = BaseUtil.toJson(jsonobj);
		BaseUtil.outPrint(response, jsonResult);
	}
	
}
