package fage_1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UrlTest extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//1
		request.getRequestDispatcher("/sb.html").forward(request, response);
		
		//2
		response.sendRedirect("/MyWebProject/sb.html");
		
		//3
		this.getServletContext().getRealPath("/sb.html");
		
		//4
		this.getServletContext().getResourceAsStream("/MyWebProject/sb.html");
		
		//5
		/***
		 * <a href="/MyWebProject/sb.html">点击</a>
		 * 
		 * <form action="/MyWebProject/servlet/Servletdemo"></form>
		 * 
		 * <img src="/MyWebProject/sb.png">
		 * 
		 * */

		//一般来说，给浏览器用的就是“/web项目名/访问资源”，给服务器调用的就是“/访问资源”，此处省略了WebRoot。
		//反斜杠访问的是硬盘上面的资源。
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
