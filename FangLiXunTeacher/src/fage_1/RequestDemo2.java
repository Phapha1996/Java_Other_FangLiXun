package fage_1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//����ת����ʹ��requestת����Դ
public class RequestDemo2 extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
		
	}
	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//�����ݹ�jsp
		String data = "aaaaaa";
		request.setAttribute("data", data);
		
		
		//requestʵ��ת��
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		return;
	}

}
