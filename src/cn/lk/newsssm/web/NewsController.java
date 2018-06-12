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

import cn.lk.newsssm.entity.News;
import cn.lk.newsssm.service.CommentService;
import cn.lk.newsssm.service.NewsService;
import cn.lk.newsssm.utils.BaseUtil;

@Controller
@RequestMapping("/news")
public class NewsController {

	@Autowired
	private NewsService newsSvc;
	
	@Autowired
	private CommentService commentSvc;
	private String jsonResult;
	private HashMap<String, Object> jsonobj = new HashMap<String, Object>();

	// /////////////////增
	// /////////////////////////////////////////////////////
	//
	@RequestMapping(value = "/goAdd")
	public String goAdd() {
		return "newsadd";
	}

	@RequestMapping(value = "/saveAdd", method = RequestMethod.POST)
	public void saveAdd(News news, HttpServletResponse response) {
		jsonobj.clear();
		try {
			news.setTjdate(new Date());// 提交日期由后端生成
			news.setHitnum(0);
			newsSvc.addNews(news);
			jsonobj.put("ok", true);
			jsonobj.put("msg", "goadmin");
		} catch (Exception e) {
			e.printStackTrace();
			jsonobj.put("ok", false);
			jsonobj.put("msg", "系统错误2");
		}
		jsonResult = BaseUtil.toJson(jsonobj);
		BaseUtil.outPrint(response, jsonResult);
	}

	// /////////////////删
	// /////////////////////////////////////////////////////
	//
	@RequestMapping(value = "/doDel1", method = RequestMethod.POST)
	public void doDel1(int id, HttpServletResponse response) {
		jsonobj.clear();
		boolean delflag = false;
		try {
			newsSvc.deleteNews(id);
			delflag = true;
		} catch (Exception e) {
			e.printStackTrace();
			delflag = false;
		}
		jsonobj.put("delflag", delflag);
		BaseUtil.outPrint(response, BaseUtil.toJson(jsonobj));
	}

	// /////////////////改
	// /////////////////////////////////////////////////////
	//
	@RequestMapping(value = "/goEdit", method = RequestMethod.GET)
	public String goEdit(int id, Model model) {
		model.addAttribute("news", newsSvc.getNews(id));
		return "newsedit";
	}

	@RequestMapping(value = "/saveEdit", method = RequestMethod.POST)
	public void saveEdit(News news, HttpServletResponse response) {
		jsonobj.clear();
		try {
			News news0 = newsSvc.getNews(news.getId());
			news0.setContent(news.getContent());
			news0.setCruser(news.getCruser());
			news0.setTitle(news.getTitle());
			newsSvc.updateNews(news0);
			jsonobj.put("ok", true);
			jsonobj.put("msg", "goadmin");
		} catch (Exception e) {
			e.printStackTrace();
			jsonobj.put("ok", false);
			jsonobj.put("msg", "系统错误2");
		}
		jsonResult = BaseUtil.toJson(jsonobj);
		BaseUtil.outPrint(response, jsonResult);
	}

	// /////////////////查
	// /////////////////////////////////////////////////////
	//
	@RequestMapping(value = "/goList")
	public String goList() {
		return "newslist";
	}

	@RequestMapping(value = "/getCount", method = RequestMethod.POST)
	public void getCount(HttpServletResponse response) {
		int c = 0;
		try {
			c = newsSvc.getNewsCount();
		} catch (Exception e) {
			e.printStackTrace();
			c = 0;
		}
		jsonobj.clear();
		jsonobj.put("newscount", c);
		jsonResult = BaseUtil.toJson(jsonobj);
		BaseUtil.outPrint(response, jsonResult);
	}

	@RequestMapping(value = "/getNews", method = RequestMethod.GET)
	public String getNews(int id, Model model) {
		model.addAttribute("news", newsSvc.getNews(id));
		model.addAttribute("comments", commentSvc.listComments(id));
		return "newsread";
	}

	@RequestMapping(value = "/listNews", method = RequestMethod.POST)
	public void listNews(String s_name, int page, int rows,
			HttpServletResponse response) {
		System.out.println(page);
		System.out.println(rows);
		List<News> newslist = newsSvc.listDgNews(s_name, page, rows);
		jsonobj.clear();
		jsonobj.put("total", newsSvc.getCout());
		jsonobj.put("rows", newslist);
		jsonResult = BaseUtil.toJson(jsonobj);
		BaseUtil.outPrint(response, jsonResult);
	}
}
