package cn.lk.newsssm.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baidu.ueditor.ActionEnter;

public class FileAct extends HttpServlet {
	public FileAct() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 百度富文本编辑器：图片上传
	 * 
	 * @param request
	 * @param response
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setHeader("Content-Type", "text/html");
		ServletContext application = request.getServletContext();
		String rootPath = application.getRealPath("/");
		PrintWriter out = response.getWriter();
		out.write(new ActionEnter(request, rootPath).exec());
	}
}
