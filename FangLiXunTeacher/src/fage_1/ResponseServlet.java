package fage_1;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//���������������
public class ResponseServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("content-type", "text/html;charset=UTF-8");
//		response.setContentType("text/html;charset=UTF-8");
		OutputStream out = response.getOutputStream();
		String f="�й�";
		out.write(f.getBytes("UTF-8"));
		
	/*
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> ģ��ͷ�����������UTF-8��
		request.setCharacterEncoding("UTF-8");	
		response.setCharacterEncoding("UTF-8");------1
		response.setHeader("content-type", "text/html;charset=UTF-8");--------2
		����1,2�������Լ���Ϊresponse.setContentType("text/html;charset=UTF-8");
	*/
	
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
		
	}

}
