package fage_1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//请求转发，使用request转发资源
public class RequestDemo2 extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
		
	}
	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//带数据过jsp
		String data = "aaaaaa";
		request.setAttribute("data", data);
		
		
		//request实现转发
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		return;
	}

}
