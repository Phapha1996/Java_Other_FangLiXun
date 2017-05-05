package fage_1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//防盗链的实现
public class Referer extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String referer = request.getHeader("referer");				//得到来访者是从哪个页面链接过来的
		
		if(referer==null||!referer.startsWith("http://localhost")){	//如果是复制地址找到的或者不是首页过来的
			response.sendRedirect("/MyWebProject/index.jsp");				//如果不符合上述地址，直接重定向。拒绝非法访问
			return;   //直接结束servlet执行
		}
		
		String data = "绯闻男孩日志";
		response.getWriter().println("data");
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
		
	}

}
