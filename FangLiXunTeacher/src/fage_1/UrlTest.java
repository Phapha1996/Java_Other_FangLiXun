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
		 * <a href="/MyWebProject/sb.html">���</a>
		 * 
		 * <form action="/MyWebProject/servlet/Servletdemo"></form>
		 * 
		 * <img src="/MyWebProject/sb.png">
		 * 
		 * */

		//һ����˵����������õľ��ǡ�/web��Ŀ��/������Դ���������������õľ��ǡ�/������Դ�����˴�ʡ����WebRoot��
		//��б�ܷ��ʵ���Ӳ���������Դ��
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
