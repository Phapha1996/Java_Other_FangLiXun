package Cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class CookieDemo extends HttpServlet {
	

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println("���ϴη��ʵ�ʱ��Ϊ��");
		
		//����û���ʱ��cookie
		Cookie[] cookies = request.getCookies();		//�õ��û�������cookie
		for(int i=0;cookies!=null&&i<cookies.length;i++){
			if(cookies[i].getName().equals("lastAccessTime")){  
				long cookieValue = Long.parseLong(cookies[i].getValue());			//ת���ɺ���ֵ
				Date date = new Date(cookieValue);				//ֱ������ʱ��
				out.println(date.toLocaleString());				//�й���ʽ
			}
		}
		
	
		//���û��ͻ����µķ���ʱ��
		Cookie cookie = new Cookie("lastAccessTime",System.currentTimeMillis()+"");	//����һ��cookie
		cookie.setMaxAge(1*24*60*60);		//cookie�Ĵ��ʱ��
		cookie.setPath("/MyWebProject");	//cookie����·��
		response.addCookie(cookie);			//��IE��Cookie
		
		
		out.flush();
		out.close();
		
		
		
		
		/**
		 * public Cookie(String name ,String value)
		 * setValue(),getValue()�õ�cookie��ֵ
		 * setMaxAge(),getMaxAge()���û��ߵõ���Ч��
		 * setPath(),getPath()����cookie����ЧĿ¼�����������Ŀ¼�µ���Դʱ��������������cookieȥ����
		 * setDomain(),getDomain()
		 * getName()�õ�cookie������
		 * 
		 * */
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
		
	}

}
