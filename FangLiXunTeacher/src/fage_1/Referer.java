package fage_1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//��������ʵ��
public class Referer extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String referer = request.getHeader("referer");				//�õ��������Ǵ��ĸ�ҳ�����ӹ�����
		
		if(referer==null||!referer.startsWith("http://localhost")){	//����Ǹ��Ƶ�ַ�ҵ��Ļ��߲�����ҳ������
			response.sendRedirect("/MyWebProject/index.jsp");				//���������������ַ��ֱ���ض��򡣾ܾ��Ƿ�����
			return;   //ֱ�ӽ���servletִ��
		}
		
		String data = "����к���־";
		response.getWriter().println("data");
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
		
	}

}
